package com.hbandroid.fragmentactivitydemo.di.module;

import com.hbandroid.fragmentactivitydemo.BuildConfig;
import com.hbandroid.fragmentactivitydemo.app.MyApp;
import com.hbandroid.fragmentactivitydemo.common.constant.IConstant;
import com.hbandroid.fragmentactivitydemo.common.interceptor.requestInterceptor;
import com.hbandroid.fragmentactivitydemo.common.rx.RXErrorHandler;
import com.hbandroid.fragmentactivitydemo.db.http.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

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
public class HttpModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        okHttpClient
                .readTimeout(IConstant.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(IConstant.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient.addInterceptor(logging);
        }

        okHttpClient.addInterceptor(new requestInterceptor());

        return okHttpClient.build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();

    }

    @Singleton
    @Provides
    public ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Singleton
    @Provides
    public RXErrorHandler provideRXErrorHandler(MyApp app) {
        return new RXErrorHandler(app);
    }

}

