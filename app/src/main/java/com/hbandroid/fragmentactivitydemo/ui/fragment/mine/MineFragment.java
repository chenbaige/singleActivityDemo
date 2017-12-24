package com.hbandroid.fragmentactivitydemo.ui.fragment.mine;


import com.hbandroid.fragmentactivitydemo.R;
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
