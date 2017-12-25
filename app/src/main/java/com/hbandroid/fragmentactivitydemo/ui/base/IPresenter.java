package com.hbandroid.fragmentactivitydemo.ui.base;

import android.app.Activity;

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

public interface IPresenter<T extends IView> {

    void attachView(T activity);

    void detachView();
}
