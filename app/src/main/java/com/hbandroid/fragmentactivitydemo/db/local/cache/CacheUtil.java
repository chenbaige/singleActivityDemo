package com.hbandroid.fragmentactivitydemo.db.local.cache;

import android.content.Context;

import com.hbandroid.fragmentactivitydemo.common.rx.RXResponseCompat;
import com.hbandroid.fragmentactivitydemo.db.http.ApiService;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;

import java.util.List;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.JacksonSpeaker;


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

    private CacheProviders providers;

    private ApiService mService;

    public ApiService getService() {
        return mService;
    }

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
                    mInstance = new CacheUtil(mService, context);
                }
            }
        }
        return mInstance;
    }

//    public Observable<Reply<List<User>>> getUsers() {
//        Observable<List<User>> observable = mService.getresponse().compose(RXResponseCompat.<User>compatListResult());
//        return providers.getUsers(observable, new DynamicKey("获取用户列表"), new EvictDynamicKey(false));
//    }

    public Observable<Reply<List<User>>> getUsers() {
        Observable<List<User>> observable = mService.getresponse().compose(RXResponseCompat.<User>compatListResult());
        return providers.getUsers(observable, new DynamicKey("获取用户列表"), new EvictDynamicKey(false)).compose(RXResponseCompat.<Reply<List<User>>>applyIoSchedulers());
    }


}
