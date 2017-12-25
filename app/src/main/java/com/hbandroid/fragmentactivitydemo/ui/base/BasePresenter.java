package com.hbandroid.fragmentactivitydemo.ui.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.hbandroid.fragmentactivitydemo.db.http.ApiService;
import com.hbandroid.fragmentactivitydemo.ui.util.ToastManager;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Title:singleActivityDemo
 * <p>
 * Description:
 * <p>
 * <p>
 * Author: baigege(baigegechen@gmail.com)
 * <p>
 * Date：2017-12-25
 */

public class BasePresenter<T extends IView, M extends IModel> implements IPresenter<T> {

    protected T mView;

    protected Activity mActivity;

    protected CompositeSubscription mCompositeSubscription;

    protected M mModel;

    public BasePresenter(ApiService apiService) {
    }

    @Override
    public void attachView(T activity) {
        this.mView = activity;
        if (activity instanceof Activity) {
            this.mActivity = (Activity) activity;
        } else {
            this.mActivity = ((Fragment) activity).getActivity();
        }
    }

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
