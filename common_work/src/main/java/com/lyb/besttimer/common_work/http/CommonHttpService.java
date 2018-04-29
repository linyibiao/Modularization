package com.lyb.besttimer.common_work.http;

import com.lyb.besttimer.common_work.bean.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 公共http
 *
 * @author linyibiao
 * @since 2018/4/29 上午12:05
 */
public interface CommonHttpService {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

}
