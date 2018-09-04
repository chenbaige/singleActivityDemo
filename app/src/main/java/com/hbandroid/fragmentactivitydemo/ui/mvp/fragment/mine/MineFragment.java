package com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.mine;


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
public class MineFragment extends BaseFragment {

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void onLazyRequest() {

    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_mine;
    }

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    public void init() {

    }
}
