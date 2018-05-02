package com.lyb.besttimer.common_util.http;

import android.util.Log;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求类
 *
 * @author linyibiao
 * @since 2018/4/29 上午4:19
 */
public class HttpHelper {

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new SimpleInterceptor())
            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.d("retrofit_msg", message);
                }
            }).setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public static Retrofit getRetrofit(HttpUrl httpUrl) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(httpUrl)
                .client(getOkHttpClient())
                .build();
    }

}
