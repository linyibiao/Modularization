package com.lyb.besttimer.modularization;

import android.content.Context;

import com.lyb.besttimer.annotation_api.BindClassInit;
import com.lyb.besttimer.lib_common.BaseApplication;

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
        BindClassInit.getInstance().init();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
