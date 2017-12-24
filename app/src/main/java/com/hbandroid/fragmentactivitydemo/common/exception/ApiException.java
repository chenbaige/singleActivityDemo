package com.hbandroid.fragmentactivitydemo.common.exception;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:这个类处理请求成功的情况下，返回状态吗不是1的情况下的异常，即data数据为空
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
public class ApiException extends BaseException {

    public ApiException(int code, String displayMessage) {
        super(code, displayMessage);
    }
}
