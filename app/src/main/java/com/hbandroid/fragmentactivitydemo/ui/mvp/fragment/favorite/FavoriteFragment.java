package com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.favorite;


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
public class FavoriteFragment extends BaseFragment {

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_favorite;
    }

    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }

    @Override
    public void init() {

    }
}
