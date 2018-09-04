package com.hbandroid.fragmentactivitydemo.db.http;

import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseListEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.WeatherDto;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
<<<<<<< HEAD

=======
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9

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
<<<<<<< HEAD
//    String baseUrl = "http://www.sojson.com";
//    public static final String BASE_URL = "http://www.sojson.com";
    public static final String BASE_URL = "http://192.168.2.182:8080";
=======
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9

    @GET("/user/index")
    Observable<ResponseListEntity<User>> getresponse();

    @POST("/user/index")
    Observable<ResponseEntity<User>> getUser(@Query("id") int id);

<<<<<<< HEAD
    @GET("/open/api/weather/json.shtml")
=======
    @GET("open/api/weather/json.shtml")
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
    Observable<WeatherDto> getWeather(@Query("city") String city);
}
