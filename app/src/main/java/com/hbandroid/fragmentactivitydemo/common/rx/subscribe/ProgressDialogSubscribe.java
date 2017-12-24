package com.hbandroid.fragmentactivitydemo.common.rx.subscribe;

import android.content.Context;

import com.hbandroid.fragmentactivitydemo.common.rx.ProgressDialogHandler;

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


    public ProgressDialogSubscribe(Context context) {
        super(context);
        this.mDialogHandler = new ProgressDialogHandler(context, true, this);
    }

    public boolean isCancel(){
        return true;
    }

    @Override
    public void onStart() {
        mDialogHandler.showDialog();
    }

    @Override
    public void onCompleted() {
        mDialogHandler.dismissDialog();
    }

    @Override
    public void onError(Throwable e) {
        mDialogHandler.dismissDialog();
        super.onError(e);
    }

    @Override
    public void onProgressCancel() {
        unsubscribe();
    }
}
