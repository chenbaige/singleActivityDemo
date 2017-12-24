package com.hbandroid.fragmentactivitydemo.common.exception;

import android.content.Context;

import com.hbandroid.fragmentactivitydemo.R;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-25
 */
public class ErrorMessageFactory {

    public static String getMessageByCode(Context context, int code) {

        String errMessage = "";

        switch (code) {
            case BaseException.API_ERROR:
                //根据错误吗获取string文件定义好的错误信息
                errMessage = context.getResources().getString(R.string.app_name);
                break;

            case BaseException.NETWORK_ERROR:

                break;

            case BaseException.HTTP_ERROR:

                break;

            case BaseException.JSON_ERROR:

                break;

            case BaseException.UNKNOW_ERROR:

                break;

            case BaseException.RUNTIME_ERROR:

                break;

            case BaseException.UNKONWHOST_ERROR:

                break;

            case BaseException.TIMEOUT_ERROR:

                break;

            case BaseException.SOCKET_ERROR:

                break;
        }
        return errMessage;

    }

}
