package com.hbandroid.fragmentactivitydemo.common.interceptor;

import android.util.Log;

import com.hbandroid.fragmentactivitydemo.common.constant.IConstant;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Title: singleActivityDemo
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-12-26
 */

public class requestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        //获得请求信息，此处如有需要可以添加headers信息
        Request request = chain.request();
        String method = request.method().toUpperCase();

        String body = request.body().toString();

        String interName = request.url().encodedPath();

        //添加Cookie信息
        request.newBuilder().addHeader("Cookie", "aaaa");
        //打印请求信息
        Log.e(IConstant.LOG_DESC, "url:" + request.url());
        Log.e(IConstant.LOG_DESC, "method:" + request.method());
        Log.e(IConstant.LOG_DESC, "request-body:" + request.body());

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
        Log.e(IConstant.LOG_DESC, "耗时:" + tookMs + "ms");
        //使用response获得headers(),可以更新本地Cookie。
        Log.e(IConstant.LOG_DESC, "headers==========");
        Headers headers = response.headers();
        Log.e(IConstant.LOG_DESC, headers.toString());

        //获得返回的body，注意此处不要使用responseBody.string()获取返回数据，原因在于这个方法会消耗返回结果的数据(buffer)
        ResponseBody responseBody = response.body();

        //为了不消耗buffer，我们这里使用source先获得buffer对象，然后clone()后使用
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        //获得返回的数据
        Buffer buffer = source.buffer();
        //使用前clone()下，避免直接消耗
        Log.e(IConstant.LOG_DESC, "response:" + buffer.clone().readString(Charset.forName("UTF-8")));
        return response;
    }
}
