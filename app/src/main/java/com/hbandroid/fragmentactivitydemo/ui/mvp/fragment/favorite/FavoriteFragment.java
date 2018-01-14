package com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.favorite;


import android.widget.TextView;

import com.hbandroid.fragmentactivitydemo.R;
import com.hbandroid.fragmentactivitydemo.di.component.AppComponent;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;
import com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.NewsFragment;

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
public class FavoriteFragment extends BaseFragment {

    @BindView(R.id.tv_news)
    TextView mTvNews;

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

    @OnClick(R.id.tv_news)
    public void onViewClicked() {
        mActivityStatusListener.startFragment(NewsFragment.newInstance());
    }
}
