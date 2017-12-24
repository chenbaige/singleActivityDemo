package com.hbandroid.fragmentactivitydemo.listener;

import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;

/**
 * Title: fragmentActivityDemo
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-12-24
 */

public interface OnChangeActivityStatusListener {

    //设置头部标题
    public void setTitle(int resId);

    public void setTitle(String title);


    public void setBottomNavagationBarVisiable(int isVisiable);

    public void startFragment(BaseFragment fragment);


//    void onTbLeftClick();


}
