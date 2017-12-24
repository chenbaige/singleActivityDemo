package com.hbandroid.fragmentactivitydemo.common.exception;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
public class BaseException extends Exception {


    /**
     * API 错误
     */
    public static final int API_ERROR = 0X00;

    /**
     * 网络 错误
     */
    public static final int NETWORK_ERROR = 0X01;

    /**
     * http 错误
     */
    public static final int HTTP_ERROR = 0X02;

    /**
     * fastjson 错误
     */
    public static final int JSON_ERROR = 0X03;

    /**
     * 未知 错误
     */
    public static final int UNKNOW_ERROR = 0X04;

    /**
     * 运行时异常 错误
     */
    public static final int RUNTIME_ERROR = 0X05;

    /**
     * 域名解析异常错误
     */
    public static final int UNKONWHOST_ERROR = 0X06;

    /**
     * 网络连接超时异常
     */
    public static final int TIMEOUT_ERROR = 0X07;

    /**
     * 无网络连接异常
     */
    public static final int SOCKET_ERROR = 0X08;


    /**
     * 详细异常定义
     */

    /**
     * 定义所有服务器返回的错误码
     */
    //服务区错误
    public static final int ERR_API_SYSTEM = 10001;
    //登陆错误，用户名密码错误
    public static final int ERR_API_LOGIN = 10002;
    //调用无权限API
    public static final int ERR_API_NO_PERMISSION = 10003;
    //账户被冻结
    public static final int ERR_API_ACCOUNT_FREEZE = 10004;


    /**
     * http STATUSCODE
     */
    public static final int ERROR_HTTP_400 = 400;
    public static final int ERROR_HTTP_404 = 404;
    public static final int ERROR_HTTP_405 = 405;
    public static final int ERROR_HTTP_500 = 500;

    /**
     *
     */

    private int code;

    private String displayMessage;

    public BaseException() {
    }

    public BaseException(int code, String displayMessage) {
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public BaseException(String message, int code, String displayMessage) {
        super(message);
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
