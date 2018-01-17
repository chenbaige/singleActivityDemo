package com.hbandroid.fragmentactivitydemo.ui.mvp.presenter;

import com.hbandroid.fragmentactivitydemo.common.rx.subscribe.ProgressDialogSubscribe;
import com.hbandroid.fragmentactivitydemo.db.http.entity.WeatherDto;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;
import com.hbandroid.fragmentactivitydemo.db.local.cache.CacheUtil;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;
import com.hbandroid.fragmentactivitydemo.ui.base.BasePresenter;
import com.hbandroid.fragmentactivitydemo.ui.mvp.contract.HomeContract;
import com.hbandroid.fragmentactivitydemo.ui.mvp.model.HomeModel;

import java.util.List;

import javax.inject.Inject;

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

public class HomePresenter extends BasePresenter<HomeContract.View, HomeContract.Model> implements HomeContract.presenter {

    @Inject
    public HomePresenter(CacheUtil cacheUtil) {
        super(cacheUtil);
        this.mModel = new HomeModel(cacheUtil);
    }

    @Override
    public void request() {
        mModel.request().subscribe(new ProgressDialogSubscribe<Reply<List<User>>>((BaseFragment) mView) {
            @Override
            public void onNext(Reply<List<User>> listReply) {
                mView.showOnUI("来源:" + listReply.getSource() + "<----->" + "data:" + listReply.getData().get(0).getBirthday());
            }

            @Override
            public void onShowData(Reply<List<User>> listReply) {

            }
        });
    }

    @Override
    public void getUser() {
        mModel.getUser(mView.getSelectUser()).subscribe(new ProgressDialogSubscribe<User>((BaseFragment) mView) {
            @Override
            public void onNext(User user) {
                mView.showOnUI(user.getEmail());
            }

            @Override
            public void onShowData(User user) {

            }
        });
    }

    @Override
    public void getWeather() {
        mModel.getWeather("广元").subscribe(new ProgressDialogSubscribe<WeatherDto>((BaseFragment) mView) {
            @Override
            public void onShowData(WeatherDto weatherDto) {
                mView.showWeather(weatherDto.getData().getYesterday().getNotice());
            }
        });
    }
}
