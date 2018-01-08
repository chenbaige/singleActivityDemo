package com.hbandroid.fragmentactivitydemo.db.local.cache;

import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.LifeCache;
import io.rx_cache2.ProviderKey;
import io.rx_cache2.Reply;

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

public interface CacheProviders {

    @ProviderKey("student")
    @LifeCache(duration = 7, timeUnit = TimeUnit.DAYS)
    Observable<Reply<List<User>>> getUsers(Observable<List<User>> oRepos, DynamicKey userName, EvictDynamicKey evictDynamicKey);

}
