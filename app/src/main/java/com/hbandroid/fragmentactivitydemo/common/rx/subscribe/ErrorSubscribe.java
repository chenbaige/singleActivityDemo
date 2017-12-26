package com.hbandroid.fragmentactivitydemo.common.rx.subscribe;

import android.content.Context;
import android.util.Log;

import com.hbandroid.fragmentactivitydemo.common.constant.IConstant;
import com.hbandroid.fragmentactivitydemo.common.exception.BaseException;
import com.hbandroid.fragmentactivitydemo.common.rx.RXErrorHandler;

/**
 * Title: basicmvpframwork
 * <p>
 * Description:专用于处理onerror的subscribe
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-05-24
 */
public abstract class ErrorSubscribe<T> extends DefaultSubscribe<T> {

    private RXErrorHandler mHandler;

    private Context mContext;

    public ErrorSubscribe(Context context) {
        this.mContext = context;
        this.mHandler = new RXErrorHandler(mContext);
    }

    @Override
    public void onError(Throwable e) {
        Log.e(IConstant.LOG_DESC, e.getMessage());
        BaseException baseException = mHandler.handleError(e);

        if (baseException == null) {

        } else {
            mHandler.showMessage(baseException);
        }


    }
}
