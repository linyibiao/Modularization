package com.lyb.besttimer.common_work.bean;

/**
 * 例子
 *
 * @author linyibiao
 * @since 2018/4/29 上午4:05
 * <p>
 * { "id": 18221276,
 * "name": "git-consortium",
 * "full_name": "octocat/git-consortium"
 * }
 */
public class Repo {

    private int id;
    private String name;
    private String full_name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }
}
