package com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.hbandroid.fragmentactivitydemo.R;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;
import com.hbandroid.fragmentactivitydemo.di.component.AppComponent;
import com.hbandroid.fragmentactivitydemo.di.component.DaggerFragmentComponent;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;
import com.hbandroid.fragmentactivitydemo.ui.mvp.contract.HomeContract;
import com.hbandroid.fragmentactivitydemo.ui.mvp.presenter.HomePresenter;
import com.hbandroid.fragmentactivitydemo.ui.util.RxVIewUtil;
import com.hbandroid.fragmentactivitydemo.ui.util.ToastManager;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.rx_cache2.Reply;
import rx.Subscriber;

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
        mCacheUtil.getUsers(new Subscriber<Reply<List<User>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Reply<List<User>> listReply) {
                System.out.println(listReply.getSource());
                System.out.println(listReply.getData().get(0).getUserName());
            }
        });
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
//        mPresenter.request();
    }

    @Override
    public void showOnUI(String s) {
        mTvHomeDesc.setText(s);
    }

    @Override
    public int getSelectUser() {
        return 6;
    }
}
