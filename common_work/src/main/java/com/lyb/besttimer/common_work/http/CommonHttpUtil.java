package com.lyb.besttimer.common_work.http;

import com.lyb.besttimer.common_util.http.HttpHelper;
import com.lyb.besttimer.common_work.bean.Repo;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;
import retrofit2.Callback;

/**
 * 公共请求
 *
 * @author linyibiao
 * @since 2018/4/29 上午4:34
 */
public class CommonHttpUtil {

    private static CommonHttpService service(String url) {
        return HttpHelper.getRetrofit(HttpUrl.parse(url)).create(CommonHttpService.class);
    }

    public static void getRepoList(Callback<List<Repo>> callback) {
        service("https://api.github.com/")
                .listRepos("octocat")
                .enqueue(callback);
    }

    public static void getRepoList_rx(Consumer<List<Repo>> consumer) {
        service("https://api.github.com/")
                .listRepos_rx("octocat")
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }

}
