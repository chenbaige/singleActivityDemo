package com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.home;


import com.hbandroid.fragmentactivitydemo.R;
import com.hbandroid.fragmentactivitydemo.di.component.AppComponent;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;

/**
 * Title:fragmentActivityDemo
 * <p>
 * Description:
 * <p>
 * <p>
 * Author: baigege(baigegechen@gmail.com)
 * <p>
 * Date：2017-12-22
 */
public class HomeDetailFragment extends BaseFragment {

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void onLazyRequest() {

    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_home_detail;
    }

    public static HomeDetailFragment newInstance() {
        return new HomeDetailFragment();
    }

    @Override
    public void init() {
        mActivityStatusListener.setTitle("首页详情");
//        mActivityStatusListener.setBottomNavagationBarVisiable(View.GONE);
    }

}
