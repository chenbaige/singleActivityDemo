package com.hbandroid.fragmentactivitydemo.db.http.entity;

import java.io.Serializable;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
public class ResponseEntity<T> implements Serializable {
    //请求接口成功状态吗
    public static final int SUCCESS = 1;

    public boolean success() {
        return status == SUCCESS;
    }

    private int status;

    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
