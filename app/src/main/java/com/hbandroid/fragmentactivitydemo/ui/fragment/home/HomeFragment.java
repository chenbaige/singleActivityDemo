package com.hbandroid.fragmentactivitydemo.ui.fragment.home;


import android.widget.TextView;

import com.hbandroid.fragmentactivitydemo.R;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

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
public class HomeFragment extends BaseFragment {

    @BindView(R.id.tv_home_desc)
    TextView mTvHomeDesc;

    @Override
    public int setContentViewId() {
        return R.layout.fragment_home;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void init() {

    }

    @OnClick(R.id.tv_home_desc)
    public void onViewClicked() {
        mActivityStatusListener.startFragment(HomeDetailFragment.newInstance());
    }
}
