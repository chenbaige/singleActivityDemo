package com.hbandroid.fragmentactivitydemo.db.http;

import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseListEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;

import retrofit.http.GET;
import rx.Observable;

/**
 * Title: BasicMvpFramwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
public interface ApiService {

    public static final String BASE_URL = "http://192.168.31.154:8080";

    @GET("/user/index")
    Observable<ResponseListEntity<User>> getresponse();
}
