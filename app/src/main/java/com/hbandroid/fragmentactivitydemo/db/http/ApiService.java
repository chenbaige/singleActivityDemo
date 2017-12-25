package com.hbandroid.fragmentactivitydemo.db.http;

import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseListEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.TestBaseEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.TestEntity;

import retrofit.http.GET;
import retrofit.http.Query;
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

    public static final String BASE_URL = "http://us.2thewin.com";

    @GET("/Match/matchmanage")
    Observable<ResponseEntity<TestBaseEntity>> getresponse(@Query("MatchId") String MatchId);
}
