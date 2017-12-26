package com.hbandroid.fragmentactivitydemo.ui.mvp.presenter;

import com.hbandroid.fragmentactivitydemo.common.rx.subscribe.ErrorSubscribe;
import com.hbandroid.fragmentactivitydemo.db.http.ApiService;
import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;
import com.hbandroid.fragmentactivitydemo.ui.base.BasePresenter;
import com.hbandroid.fragmentactivitydemo.ui.mvp.contract.HomeContract;
import com.hbandroid.fragmentactivitydemo.ui.mvp.model.HomeModel;

import java.util.List;

import javax.inject.Inject;

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
    public HomePresenter(ApiService apiService) {
        super(apiService);
        this.mModel = new HomeModel(apiService);
    }

    @Override
    public void request() {
        mModel.request().subscribe(new ErrorSubscribe<List<User>>(mActivity) {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onNext(List<User> users) {
                mView.showOnUI(users.get(1).getUserName() + "的电话号码是：" + users.get(1).getMobile());
            }
        });
    }
}
