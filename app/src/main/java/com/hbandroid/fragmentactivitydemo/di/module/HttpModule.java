package com.hbandroid.fragmentactivitydemo.di.module;

import android.content.Context;

import com.hbandroid.fragmentactivitydemo.app.MyApp;
import com.hbandroid.fragmentactivitydemo.common.constant.IConstant;
import com.hbandroid.fragmentactivitydemo.common.interceptor.requestInterceptor;
import com.hbandroid.fragmentactivitydemo.common.rx.RXErrorHandler;
import com.hbandroid.fragmentactivitydemo.db.http.ApiService;
import com.hbandroid.fragmentactivitydemo.db.local.cache.CacheUtil;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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

    private Context mContext;

    public HttpModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        okHttpClient
                .readTimeout(IConstant.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(IConstant.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true);

        okHttpClient.addInterceptor(new requestInterceptor());

        return okHttpClient.build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(IConstant.BASE_URL)
                .client(okHttpClient)
<<<<<<< HEAD
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
=======
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
        return builder.build();
    }

    @Singleton
    @Provides
    public ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Singleton
    @Provides
    public CacheUtil provideCacheProvicer(ApiService service) {
        return CacheUtil.getInstance(service, mContext);
    }

    @Singleton
    @Provides
    public RXErrorHandler provideRXErrorHandler(MyApp app) {
        return new RXErrorHandler(app);
    }

}

