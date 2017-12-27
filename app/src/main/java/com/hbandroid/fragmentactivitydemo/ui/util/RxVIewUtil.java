package com.hbandroid.fragmentactivitydemo.ui.util;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hbandroid.fragmentactivitydemo.common.constant.IConstant;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Title: singleActivityDemo
 * <p>
 * Description:依赖rxbinding实现按钮防抖，关键词搜索等工具类
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-12-27
 */

public class RxVIewUtil {

    //按钮防抖
    public static void viewClick(final View view, final View.OnClickListener listener) {
        TextView textView;
        //mButton就是需要进行防抖操作的View，这里设置2秒内防抖
        RxView.clicks(view).throttleFirst(IConstant.DEFALUT_THROTTLE_TIMER, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                //do sth  在一段时间内多次点击，只处理这段时间内的第一次点击事件
                //如果为防止多次点击按钮而带来的不必要开销，可以在这里对事件进行处理
                System.out.println(System.currentTimeMillis());
                listener.onClick(view);
            }
        });
    }

    //文本框搜索
    public static void viewSearch(EditText editText) {
        RxTextView.textChanges(editText).debounce(IConstant.ET_INTER_TIME, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())//对text的监听必须在ui线程中
                .filter(new Func1<CharSequence, Boolean>() {
                    @Override
                    public Boolean call(CharSequence charSequence) {
                        //这里过滤掉字符串为空的情况，防止为空时还发起请求
                        return charSequence.toString().length() > 0;
                    }
                }).map(new Func1<CharSequence, String>() {
            @Override
            public String call(CharSequence charSequence) {
                if (null != charSequence && !"".equals(charSequence.toString().trim()))
                    return charSequence.toString().trim();
                return null;
            }
        }).observeOn(Schedulers.io()).switchMap(new Func1<String, Observable<List<String>>>() {
            //flatmap：将所有请求排列起来，然后一个一个发射出去
            //switchMap操作符：只发射最近的一个请求
            @Override
            public Observable<List<String>> call(String s) {
                //在这里我们只处理0.3秒内文本框内容未发生变化，且最后一次请求的字符串数据，将最后一次变化产生的字符串作为请求参数向服务器请求
                //do sth  在这里通过keywords关键字进行网络请求，获取改关键字搜索到的记录
                // 这里模拟数据请求，返回list数据
                List<String> mDatas = new ArrayList<String>();
                mDatas.add("哈哈哈哈");
                mDatas.add("呵呵呵呵");
                return Observable.just(mDatas);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<List<String>>() {
            @Override
            public void call(List<String> strings) {
                //在这里订阅处理成功后的数据，进行相关逻辑处理
                System.out.println("------------当前时间:" + System.currentTimeMillis() + "---------------");
                for (String s : strings) {
                    System.out.println(s);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                //处理出错的逻辑

            }
        });
    }

    //倒计时处理
    public static void viewClick2TimerDown(final TextView view, final View.OnClickListener listener) {
        //每1秒发射一次数据，设置时间间隔为1秒
        Observable.interval(0, 1, TimeUnit.SECONDS)
                //设置总时间为60秒，即按钮在60秒内不可再次点击，并且在这段时间内每隔一秒发射一次数据，更新ui
                .take(IConstant.TIMER_DOWN)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        //在数据还在发射期间设置按钮不可点击
                        view.setEnabled(false);
                    }
                }).map(new Func1<Long, String>() {
            @Override
            public String call(Long integer) {
                //对发射过来的int类型数据进行转换，便于ui显示
                return String.valueOf(IConstant.TIMER_DOWN - integer);
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                //当数据发射完成（即60秒后），设置按钮可点击
                view.setEnabled(true);
            }

            @Override
            public void onError(Throwable e) {
                //错误处理逻辑
            }

            @Override
            public void onNext(String s) {
                //在这里接受发射过来的字符串数据，用于ui显示
                view.setText("剩余" + s + "秒");
            }

            @Override
            public void onStart() {
                super.onStart();
                listener.onClick(view);
            }
        });
    }


}
