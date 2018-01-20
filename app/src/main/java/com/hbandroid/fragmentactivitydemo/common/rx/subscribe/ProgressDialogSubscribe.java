package com.hbandroid.fragmentactivitydemo.common.rx.subscribe;

import com.hbandroid.fragmentactivitydemo.common.rx.ProgressDialogHandler;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;

import io.reactivex.disposables.Disposable;

/**
 * Title: basicmvpframwork
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-05-25
 */
public abstract class ProgressDialogSubscribe<T> extends ErrorSubscribe<T> implements ProgressDialogHandler.onProgressCancelistener {

    private ProgressDialogHandler mDialogHandler;

    private Disposable mDisposable;

    private BaseFragment mFragment;


    public ProgressDialogSubscribe(BaseFragment context) {
        super(context.getActivity());
        this.mFragment = context;
        this.mDialogHandler = new ProgressDialogHandler(context.getActivity(), true, this);
    }

    public boolean isCancel() {
        return true;
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.mDisposable = d;
        mFragment.showLoading();
        mDialogHandler.showDialog();
    }

    @Override
    public void onNext(T t) {
        if (null == t) {
            mFragment.showEmpty();
        } else {
            mFragment.showContent();
            onShowData(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        mFragment.showError();
        mDialogHandler.dismissDialog();
        super.onError(e);
    }

    @Override
    public void onComplete() {
//        mFragment.showContent();
        mDialogHandler.dismissDialog();
    }

    @Override
    public void onProgressCancel() {
        mDisposable.dispose();
    }

    public abstract void onShowData(T t);
}
