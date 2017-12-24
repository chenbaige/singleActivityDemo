package com.hbandroid.fragmentactivitydemo.di.module;


import com.hbandroid.fragmentactivitydemo.app.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Title: BasicMvpFramwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
@Module
public class AppModule {

    private MyApp mApplication;

    public AppModule(MyApp application) {
        mApplication = application;
    }

    @Singleton
    @Provides
    public MyApp provideApplication() {
        return mApplication;
    }

}
