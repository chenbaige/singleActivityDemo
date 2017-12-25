package com.hbandroid.fragmentactivitydemo.ui.mvp.model;

import com.hbandroid.fragmentactivitydemo.common.rx.RXResponseCompat;
import com.hbandroid.fragmentactivitydemo.db.http.ApiService;
import com.hbandroid.fragmentactivitydemo.db.http.entity.TestBaseEntity;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseModel;
import com.hbandroid.fragmentactivitydemo.ui.mvp.contract.HomeContract;

import java.util.List;

import rx.Observable;

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

    public HomeModel(ApiService mService) {
        super(mService);
}

    @Override
    public Observable<TestBaseEntity> request() {
        return mService.getresponse("128").compose(RXResponseCompat.<TestBaseEntity>compatResult());
    }
}
