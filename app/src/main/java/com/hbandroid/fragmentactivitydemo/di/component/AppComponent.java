package com.hbandroid.fragmentactivitydemo.di.component;

import com.hbandroid.fragmentactivitydemo.app.MyApp;
import com.hbandroid.fragmentactivitydemo.common.rx.RXErrorHandler;
import com.hbandroid.fragmentactivitydemo.di.module.AppModule;
import com.hbandroid.fragmentactivitydemo.di.module.HttpModule;
import com.hbandroid.fragmentactivitydemo.db.http.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Title: BasicMvpFramwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    public ApiService getApiService();

    public MyApp getApplication();

    public RXErrorHandler getRXErrorHandler();

}
