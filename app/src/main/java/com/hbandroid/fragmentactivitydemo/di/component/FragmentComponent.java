package com.hbandroid.fragmentactivitydemo.di.component;

import com.hbandroid.fragmentactivitydemo.di.FragmentScope;
import com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.home.HomeFragment;

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
@FragmentScope
@Component(dependencies = AppComponent.class)
public interface FragmentComponent {

    void inject(HomeFragment fragment);

}
