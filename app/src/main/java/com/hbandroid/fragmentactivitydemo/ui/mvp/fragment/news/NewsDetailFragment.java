package com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.news;


import android.os.Bundle;
import android.widget.TextView;

import com.hbandroid.fragmentactivitydemo.R;
import com.hbandroid.fragmentactivitydemo.di.component.AppComponent;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;

import butterknife.BindView;

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
public class NewsDetailFragment extends BaseFragment {

    @BindView(R.id.tv_content)
    TextView mTvContent;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void onLazyRequest() {

    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_news_detail;
    }

    public static NewsDetailFragment newInstance(Bundle bundle) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void init() {
        mTvContent.setText(getArguments().getString("content"));
    }

}
