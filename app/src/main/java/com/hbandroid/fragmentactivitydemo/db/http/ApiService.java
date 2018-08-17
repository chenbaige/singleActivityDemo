package com.hbandroid.fragmentactivitydemo.db.http;

import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseListEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.WeatherDto;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


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
//    String baseUrl = "http://www.sojson.com";
//    public static final String BASE_URL = "http://www.sojson.com";
    public static final String BASE_URL = "http://192.168.2.182:8080";

    @GET("/user/index")
    Observable<ResponseListEntity<User>> getresponse();

    @POST("/user/index")
    Observable<ResponseEntity<User>> getUser(@Query("id") int id);

    @GET("/open/api/weather/json.shtml")
    Observable<WeatherDto> getWeather(@Query("city") String city);
}
