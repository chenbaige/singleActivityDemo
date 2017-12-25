package com.hbandroid.fragmentactivitydemo.ui.mvp.presenter;

import com.hbandroid.fragmentactivitydemo.common.rx.subscribe.ErrorSubscribe;
import com.hbandroid.fragmentactivitydemo.common.rx.subscribe.ProgressDialogSubscribe;
import com.hbandroid.fragmentactivitydemo.db.http.ApiService;
import com.hbandroid.fragmentactivitydemo.db.http.entity.TestBaseEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.TestEntity;
import com.hbandroid.fragmentactivitydemo.ui.base.BasePresenter;
import com.hbandroid.fragmentactivitydemo.ui.mvp.contract.HomeContract;
import com.hbandroid.fragmentactivitydemo.ui.mvp.model.HomeModel;
import com.hbandroid.fragmentactivitydemo.ui.util.ToastManager;

import org.json.JSONObject;

import javax.inject.Inject;

import rx.Subscriber;

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
        mModel.request().subscribe(new ErrorSubscribe<TestBaseEntity>(mActivity) {
                @Override
                public void onCompleted() {

            }

            @Override
            public void onNext(TestBaseEntity testEntity) {
                mView.showOnUI(testEntity.getGameName().toString());
            }
        });
    }
}
