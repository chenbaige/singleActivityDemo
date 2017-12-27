package com.hbandroid.fragmentactivitydemo.db.http;

import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseListEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
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

    public static final String BASE_URL = "http://192.168.1.253:8080";

    @GET("/user/index")
    Observable<ResponseListEntity<User>> getresponse();

    @POST("/user/index")
    Observable<ResponseEntity<User>> getUser(@Query("id") int id);
}
