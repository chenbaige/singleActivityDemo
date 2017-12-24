package com.hbandroid.fragmentactivitydemo.common.rx;

import android.content.Context;
import android.widget.Toast;

import com.hbandroid.fragmentactivitydemo.common.exception.ApiException;
import com.hbandroid.fragmentactivitydemo.common.exception.BaseException;
import com.hbandroid.fragmentactivitydemo.common.exception.ErrorMessageFactory;

import org.json.JSONException;

import java.net.SocketException;
import java.net.SocketTimeoutException;

import retrofit.HttpException;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-25
 */
public class RXErrorHandler {

    private Context mContext;

    public RXErrorHandler(Context context) {
        mContext = context;
    }

    public BaseException handleError(Throwable e) {
        /**
         * 处理多种异常
         * httpexception
         * ApiException
         * SocketException
         * JSONException
         *SocketTimeoutException
         */

        BaseException baseException = new BaseException();

        if (e instanceof HttpException) {
            baseException.setCode(BaseException.HTTP_ERROR);

        } else if (e instanceof SocketException) {
            baseException.setCode(BaseException.SOCKET_ERROR);

        } else if (e instanceof JSONException) {
            baseException.setCode(BaseException.JSON_ERROR);

        } else if (e instanceof ApiException) {
            baseException.setCode(((ApiException) e).getCode());

        } else if (e instanceof SocketTimeoutException) {
            baseException.setCode(BaseException.TIMEOUT_ERROR);
        } else {
            baseException.setCode(BaseException.UNKNOW_ERROR);
        }
        baseException.setDisplayMessage(ErrorMessageFactory.getMessageByCode(mContext, baseException.getCode()));

        return baseException;
    }

    public void showMessage(BaseException exception){
        Toast.makeText(mContext, exception.getDisplayMessage(), Toast.LENGTH_SHORT).show();
    }

}
