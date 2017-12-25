package com.hbandroid.fragmentactivitydemo.di.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.hbandroid.fragmentactivitydemo.app.MyApp;
import com.hbandroid.fragmentactivitydemo.common.constant.IConstant;
import com.hbandroid.fragmentactivitydemo.common.rx.RXErrorHandler;
import com.hbandroid.fragmentactivitydemo.db.http.ApiService;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
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
        // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(IConstant.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(IConstant.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        //获得请求信息，此处如有需要可以添加headers信息
                        Request request = chain.request();
                        //添加Cookie信息
                        request.newBuilder().addHeader("Cookie","aaaa");
                        //打印请求信息
                        syso("url:" + request.url());
                        syso("method:" + request.method());
                        syso("request-body:" + request.body());

                        //记录请求耗时
                        long startNs = System.nanoTime();
                        okhttp3.Response response;
                        try {
                            //发送请求，获得相应，
                            response = chain.proceed(request);
                        } catch (Exception e) {
                            throw e;
                        }
                        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
                        //打印请求耗时
                        syso("耗时:"+tookMs+"ms");
                        //使用response获得headers(),可以更新本地Cookie。
                        syso("headers==========");
                        Headers headers = response.headers();
                        syso(headers.toString());

                        //获得返回的body，注意此处不要使用responseBody.string()获取返回数据，原因在于这个方法会消耗返回结果的数据(buffer)
                        ResponseBody responseBody = response.body();

                        //为了不消耗buffer，我们这里使用source先获得buffer对象，然后clone()后使用
                        BufferedSource source = responseBody.source();
                        source.request(Long.MAX_VALUE); // Buffer the entire body.
                        //获得返回的数据
                        Buffer buffer = source.buffer();
                        //使用前clone()下，避免直接消耗
                        syso("response:" + buffer.clone().readString(Charset.forName("UTF-8")));
                        return response;
                    }
                })
                .build();

        return okHttpClient;
    }


    private void syso(String message){
        System.out.println(message);
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

