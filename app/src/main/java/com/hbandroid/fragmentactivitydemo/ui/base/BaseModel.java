package com.hbandroid.fragmentactivitydemo.ui.base;

import android.app.Activity;
import android.content.Context;

import com.hbandroid.fragmentactivitydemo.db.http.ApiService;

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

    public BaseModel(ApiService mService) {
        this.mService = mService;
    }
}
