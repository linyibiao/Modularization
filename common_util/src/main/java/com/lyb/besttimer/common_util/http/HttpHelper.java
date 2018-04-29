package com.lyb.besttimer.common_util.http;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 网络请求类
 *
 * @author linyibiao
 * @since 2018/4/29 上午4:19
 */
public class HttpHelper {

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new SimpleInterceptor())
            .build();

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public static Retrofit getRetrofit(HttpUrl httpUrl) {
        return new Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(getOkHttpClient())
                .build();
    }

}
