package com.hbandroid.fragmentactivitydemo.di.module;


import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

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

    @Provides
    @Singleton
        // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

}
