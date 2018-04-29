package com.lyb.besttimer.common_util.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 简单的网络拦截器
 *
 * @author linyibiao
 * @since 2018/4/29 上午4:26
 */
public class SimpleInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }
}
