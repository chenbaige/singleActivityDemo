package com.hbandroid.fragmentactivitydemo.http.entity;

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
    public static final int SUCCESS = 1;

    private int status;
    private String message;
    private T mTList;

    public boolean success(){
        return status == SUCCESS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getTList() {
        return mTList;
    }

    public void setTList(T TList) {
        mTList = TList;
    }
}
