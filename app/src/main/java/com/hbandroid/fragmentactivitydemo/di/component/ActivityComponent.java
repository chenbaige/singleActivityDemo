package com.hbandroid.fragmentactivitydemo.di.component;

import com.hbandroid.fragmentactivitydemo.MainActivity;
import com.hbandroid.fragmentactivitydemo.di.ActivityScope;

import dagger.Component;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
