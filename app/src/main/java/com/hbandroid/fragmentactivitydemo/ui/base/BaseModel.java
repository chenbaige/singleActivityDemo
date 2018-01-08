package com.hbandroid.fragmentactivitydemo.ui.base;

import com.hbandroid.fragmentactivitydemo.db.http.ApiService;
import com.hbandroid.fragmentactivitydemo.db.local.cache.CacheUtil;

/**
 * Title:singleActivityDemo
 * <p>
 * Description:
 * <p>
 * <p>
 * Author: baigege(baigegechen@gmail.com)
 * <p>
 * Date：2017-12-25
 */

public class BaseModel implements IModel {

    protected ApiService mService;

    protected CacheUtil mCacheUtil;

    public BaseModel(CacheUtil cacheUtil) {
        this.mCacheUtil = cacheUtil;
        this.mService = cacheUtil.getService();
    }
}
