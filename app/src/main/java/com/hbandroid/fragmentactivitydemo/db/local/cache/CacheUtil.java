package com.hbandroid.fragmentactivitydemo.db.local.cache;

import android.content.Context;

import com.hbandroid.fragmentactivitydemo.common.rx.RXResponseCompat;
import com.hbandroid.fragmentactivitydemo.db.http.ApiService;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;

import java.util.List;

import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.JacksonSpeaker;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Title:singleActivityDemo
 * <p>
 * Description:
 * <p>
 * <p>
 * Author: baigege(baigegechen@gmail.com)
 * <p>
 * Date：2017-12-29
 */

public class CacheUtil {

    private static CacheUtil mInstance = null;

//    private static File cacheDirectory = FileUtil.getcacheDirectory();

    private static CacheProviders providers;

    private ApiService mService;

    private CacheUtil(ApiService mService, Context context) {
        this.mService = mService;
        providers = new RxCache.Builder()
                .useExpiredDataIfLoaderNotAvailable(true)
                .persistence(FileUtil.getcacheDirectory(context), new JacksonSpeaker())
                .using(CacheProviders.class);
    }

    public static CacheUtil getInstance(ApiService mService, Context context) {
        if (null == mInstance) {
            synchronized (CacheUtil.class) {
                if (null == mInstance) {
                    mInstance = new CacheUtil(mService,context);
                }
            }
        }
        return mInstance;
    }

    public void getUsers(Observer<Reply<List<User>>> observer) {
        Observable<List<User>> observable = mService.getresponse().compose(RXResponseCompat.<User>compatListResult());
        Observable<Reply<List<User>>> observableCache = providers.getUsers(observable, new DynamicKey("获取用户列表"), new EvictDynamicKey(false));
        setSubscribe(observableCache, observer);
    }

//    public void getUsers(Observer<Reply<List<User>>> observer) {
//        Observable<List<User>> observable = mService.getresponse().compose(RXResponseCompat.<User>compatListResult());
//        Observable<Reply<List<User>>> observableCache = providers.getUsers(observable, new DynamicKey("获取用户列表"), new EvictDynamicKey(false));
//        setSubscribe(observableCache, observer);
//    }

    /**
     * 插入观察者
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public <T> void setSubscribe(Observable<Reply<T>> observable, Observer<Reply<T>> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }

}
