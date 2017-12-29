package com.hbandroid.fragmentactivitydemo.db.local.cache;

import com.hbandroid.fragmentactivitydemo.common.rx.RXResponseCompat;
import com.hbandroid.fragmentactivitydemo.db.http.ApiService;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import io.victoralbertos.jolyglot.JolyglotGenerics;
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

    private static File cacheDirectory = FileUtil.getcacheDirectory();
//
//    private static final CacheProviders providers = new RxCache.Builder()
//            .useExpiredDataIfLoaderNotAvailable(true)
//            .persistence(cacheDirectory, null)
//            .using(CacheProviders.class);

    private ApiService mService;

    private CacheUtil(ApiService mService) {
        this.mService = mService;
    }

    public static CacheUtil getInstance(ApiService mService){
        if(null==mInstance){
            synchronized (CacheUtil.class){
                if(null==mInstance){
                    mInstance = new CacheUtil(mService);
                }
            }
        }
        return mInstance;
    }

    public void getUsers(Observer<List<User>> observer) {
//        Observable<List<User>> observable = mService.getresponse().compose(RXResponseCompat.<User>compatListResult());
//        Observable<List<User>> observableCache = providers.getUsers(observable, new DynamicKey("获取用户列表"), new EvictDynamicKey(false));
//        setSubscribe(observableCache, observer);
    }

    /**
     * 插入观察者
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }

}
