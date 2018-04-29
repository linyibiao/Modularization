package com.lyb.besttimer.common_work.http;

import com.lyb.besttimer.common_util.http.HttpHelper;
import com.lyb.besttimer.common_work.bean.Repo;

import java.util.List;

import okhttp3.HttpUrl;
import retrofit2.Callback;

/**
 * 公共请求
 *
 * @author linyibiao
 * @since 2018/4/29 上午4:34
 */
public class CommonHttpUtil {

    public static void getRepoList(Callback<List<Repo>> callback) {
        HttpHelper.getRetrofit(HttpUrl.parse("https://api.github.com/")).create(CommonHttpService.class).listRepos("octocat")
                .enqueue(callback);
    }

}
