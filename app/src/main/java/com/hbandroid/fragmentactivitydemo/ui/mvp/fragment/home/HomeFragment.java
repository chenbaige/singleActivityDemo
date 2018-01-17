package com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.hbandroid.fragmentactivitydemo.R;
import com.hbandroid.fragmentactivitydemo.di.component.AppComponent;
import com.hbandroid.fragmentactivitydemo.di.component.DaggerFragmentComponent;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;
import com.hbandroid.fragmentactivitydemo.ui.mvp.contract.HomeContract;
import com.hbandroid.fragmentactivitydemo.ui.mvp.presenter.HomePresenter;
import com.hbandroid.fragmentactivitydemo.ui.util.RxVIewUtil;
import com.hbandroid.fragmentactivitydemo.ui.util.ToastManager;

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
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.tv_home_desc)
    TextView mTvHomeDesc;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder().appComponent(appComponent).build().inject(this);
    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_home;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void init() {
        multipleStatusView.showEmpty();
    }

    @OnClick(R.id.tv_home_desc)
    public void onViewClicked() {
//        mActivityStatusListener.startFragment(HomeDetailFragment.newInstance());
//        RxVIewUtil.viewClick2TimerDown(mTvHomeDesc, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastManager.showShort(_mActivity,"begin click event");
//            }
//        });

        RxVIewUtil.viewClick(mTvHomeDesc, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastManager.showShort(_mActivity, "click event click");
            }
        });
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
//        mPresenter.request();
//        mPresenter.getUser();
        mPresenter.getWeather();
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
    }

    @Override
    public void showOnUI(String s) {
        mTvHomeDesc.setText(s);
    }

    @Override
    public int getSelectUser() {
        return 2;
    }

    @Override
    public void showWeather(String data) {
        mTvHomeDesc.setText(data);
    }
}
