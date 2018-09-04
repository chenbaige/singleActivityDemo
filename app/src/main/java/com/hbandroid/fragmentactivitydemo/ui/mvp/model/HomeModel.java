package com.hbandroid.fragmentactivitydemo.ui.mvp.model;

import com.hbandroid.fragmentactivitydemo.common.rx.RXResponseCompat;
import com.hbandroid.fragmentactivitydemo.db.http.entity.WeatherDto;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;
import com.hbandroid.fragmentactivitydemo.db.local.cache.CacheUtil;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseModel;
import com.hbandroid.fragmentactivitydemo.ui.mvp.contract.HomeContract;

import java.util.List;

import io.reactivex.Observable;
import io.rx_cache2.Reply;

/**
 * Title:singleActivityDemo
 * <p>
 * Description:
 * <p>
 * <p>
 * Author: baigege(baigegechen@gmail.com)
 * <p>
 * Date：2017-12-25
 */

public class HomeModel extends BaseModel implements HomeContract.Model {

    public HomeModel(CacheUtil cacheUtil) {
        super(cacheUtil);
    }

    @Override
<<<<<<< HEAD
    public Observable<List<User>> request() {
//        return mService.getresponse().compose(RXResponseCompat.<User>compatListResult());
        return null;
=======
    public Observable<Reply<List<User>>> request() {
        return mCacheUtil.getUsers();
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
    }

    @Override
    public Observable<User> getUser(int id) {
//        return mService.getUser(id).compose(RXResponseCompat.<User>compatResult());
        return null;
    }

    @Override
    public Observable<WeatherDto> getWeather(String city) {
        return mService.getWeather(city).compose(RXResponseCompat.<WeatherDto>applyIoSchedulers());
    }
}
