package com.hbandroid.fragmentactivitydemo.ui.mvp.contract;

import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;
import com.hbandroid.fragmentactivitydemo.ui.base.IModel;
import com.hbandroid.fragmentactivitydemo.ui.base.IPresenter;
import com.hbandroid.fragmentactivitydemo.ui.base.IView;

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

public interface HomeContract {

    interface View extends IView{
        void showOnUI(String s);
    }

    interface presenter extends IPresenter<View>{
       void request();
    }

    interface Model extends IModel{
        Observable<List<User>> request();
    }

}
