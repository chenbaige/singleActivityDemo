package com.hbandroid.fragmentactivitydemo.common.rx;

import com.hbandroid.fragmentactivitydemo.common.exception.ApiException;
import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseListEntity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Title: basicmvpframwork
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-05-24
 */
public class RXResponseCompat {

//    public static <T> Observable.Transformer<ResponseEntity<T>, T> compatResult() {
//        return new Observable.Transformer<ResponseEntity<T>, T>() {
//            @Override
//            public Observable<T> call(Observable<ResponseEntity<T>> responseEntityObservable) {
//                return responseEntityObservable.flatMap(new Func1<ResponseEntity<T>, Observable<T>>() {
//                    @Override
//                    public Observable<T> call(final ResponseEntity<T> ResponseEntity) {
//                        if (ResponseEntity.success()) {
//                            //返回状态吗为1，即请求正常，返回正常,需要返回Observable<T>
//                            return Observable.create(new Observable.OnSubscribe<T>() {
//                                @Override
//                                public void call(Subscriber<? super T> subscriber) {
//                                    try {
//                                        subscriber.onNext(ResponseEntity.getTList());
//                                        subscriber.onCompleted();
//                                    } catch (Exception e) {
//                                        Observable.error(e);
//                                    }
//                                }
//                            });
//                        } else {
//                            //返回错误吗为0，即请求数据出错了，把错误交由Observable统一处理
//                            return Observable.error(new ApiException(ResponseEntity.getStatus(), ResponseEntity.getMessage()));
//                        }
//                    }//进行线程切换，请求网络任务再io线程，更新ui再android主线程
//                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
//            }
//        };
//    }

    public static <T> Observable.Transformer<ResponseListEntity<T>, List<T>> compatListResult() {
        return new Observable.Transformer<ResponseListEntity<T>, List<T>>() {
            @Override
            public Observable<List<T>> call(Observable<ResponseListEntity<T>> responseListEntityObservable) {
                return responseListEntityObservable.flatMap(new Func1<ResponseListEntity<T>, Observable<List<T>>>() {
                    @Override
                    public Observable<List<T>> call(final ResponseListEntity<T> tResponseListEntity) {
                        if (tResponseListEntity.getStatus() == 1) {
                            return Observable.create(new Observable.OnSubscribe<List<T>>() {
                                @Override
                                public void call(Subscriber<? super List<T>> subscriber) {
                                    try {
                                        subscriber.onNext(tResponseListEntity.getData());
                                        subscriber.onCompleted();
                                    } catch (Exception e) {
                                        Observable.error(e);
                                    }
                                }
                            });
                        } else {
                            return Observable.error(new Exception(tResponseListEntity.getMsg()));
                        }
                    }
                });
            }
        };
    }

    public static <T> Observable.Transformer<ResponseEntity<T>, T> compatResult() {
        return new Observable.Transformer<ResponseEntity<T>, T>() {
            @Override
            public Observable<T> call(Observable<ResponseEntity<T>> responseListEntityObservable) {
                return responseListEntityObservable.flatMap(new Func1<ResponseEntity<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(final ResponseEntity<T> tResponseListEntity) {
                        if(tResponseListEntity.getStatus()==1){
                            return Observable.create(new Observable.OnSubscribe<T>() {
                                @Override
                                public void call(Subscriber<? super T> subscriber) {
                                    try {
                                        subscriber.onNext(tResponseListEntity.getData());
                                        subscriber.onCompleted();
                                    } catch (Exception e) {
                                        Observable.error(e);
                                    }
                                }
                            });
                        }else {
                            return Observable.error(new Exception(tResponseListEntity.getMsg()));
                        }
                    }
                });
            }
        };
    }

}
