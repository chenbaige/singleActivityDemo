package com.hbandroid.fragmentactivitydemo.ui.mvp.contract;

import com.hbandroid.fragmentactivitydemo.db.http.entity.home.User;
import com.hbandroid.fragmentactivitydemo.ui.base.IModel;
import com.hbandroid.fragmentactivitydemo.ui.base.IPresenter;
import com.hbandroid.fragmentactivitydemo.ui.base.IView;

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

public interface HomeContract {

    interface View extends IView{
        void showOnUI(String s);

        int getSelectUser();
    }

    interface presenter extends IPresenter<View>{
       void request();

        void getUser();
    }

    interface Model extends IModel{
        io.reactivex.Observable<Reply<List<User>>> request();

        Observable<User> getUser(int id);
    }

}
