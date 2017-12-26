package com.hbandroid.fragmentactivitydemo.db.http.entity;

import java.util.List;

/**
 * Title:TwoTheWinProj
 * <p>
 * Description:
 * <p>
 * <p>
 * Author: baigege(baigegechen@gmail.com)
 * <p>
 * Date：2017-05-04
 */

public class ResponseListEntity<T> {

    //请求接口成功状态吗
    public static final int SUCCESS = 1;

    public boolean success() {
        return status == SUCCESS;
    }

    private int status;

    private String msg;
    private List<T> data;

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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
