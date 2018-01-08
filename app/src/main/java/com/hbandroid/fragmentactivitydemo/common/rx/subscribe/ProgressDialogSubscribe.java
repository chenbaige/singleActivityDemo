package com.hbandroid.fragmentactivitydemo.common.rx.subscribe;

import android.content.Context;

import com.hbandroid.fragmentactivitydemo.common.rx.ProgressDialogHandler;

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


    public ProgressDialogSubscribe(Context context) {
        super(context);
        this.mDialogHandler = new ProgressDialogHandler(context, true, this);
    }

    public boolean isCancel() {
        return true;
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.mDisposable = d;
        mDialogHandler.showDialog();
//        System.out.println(getClass().getSimpleName()+":onSubscribe");
    }

    @Override
    public void onError(Throwable e) {
        mDialogHandler.dismissDialog();
        super.onError(e);
    }

    @Override
    public void onComplete() {
//        System.out.println(getClass().getSimpleName()+":onComplete");
        mDialogHandler.dismissDialog();
    }

    @Override
    public void onProgressCancel() {
        mDisposable.dispose();
    }
}
