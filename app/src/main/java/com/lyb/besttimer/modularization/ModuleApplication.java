package com.lyb.besttimer.modularization;

import android.content.Context;

import com.lyb.besttimer.common_work.BaseApplication;

/**
 * module application
 *
 * @author linyibiao
 * @since 2018/4/28 15:57
 */
public class ModuleApplication extends BaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
