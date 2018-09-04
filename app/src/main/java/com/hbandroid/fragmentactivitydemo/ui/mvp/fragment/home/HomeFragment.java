package com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.home;


import android.view.View;
import android.widget.TextView;

import com.hbandroid.fragmentactivitydemo.R;
<<<<<<< HEAD
import com.hbandroid.fragmentactivitydemo.common.rx.subscribe.ProgressDialogSubscribe;
import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseListEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;
=======
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
import com.hbandroid.fragmentactivitydemo.di.component.AppComponent;
import com.hbandroid.fragmentactivitydemo.di.component.DaggerFragmentComponent;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;
import com.hbandroid.fragmentactivitydemo.ui.mvp.contract.HomeContract;
import com.hbandroid.fragmentactivitydemo.ui.mvp.presenter.HomePresenter;
import com.hbandroid.fragmentactivitydemo.ui.util.popup.DialogPopupWindow;
import com.hbandroid.fragmentactivitydemo.ui.util.rx.RxVIewUtil;
import com.hbandroid.fragmentactivitydemo.ui.util.toast.ToastManager;

import butterknife.BindView;
import butterknife.OnClick;
<<<<<<< HEAD
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.rx_cache2.Reply;
import rx.Subscriber;
=======
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9

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
    protected void onLazyRequest() {
//        mPresenter.getWeather();
        mPresenter.request();
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
<<<<<<< HEAD
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
//        mPresenter.request();
//        mPresenter.getUser();
        mCacheUtil.getUsers(new Observer<Reply<ResponseListEntity<User>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Reply<ResponseListEntity<User>> responseListEntityReply) {
                mTvHomeDesc.setText(responseListEntityReply.getSource() + ":" + responseListEntityReply.getData().getData().toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
=======
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
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
