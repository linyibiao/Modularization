package com.lyb.besttimer.modularization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lyb.besttimer.annotation_api.BindClassCenter;
import com.lyb.besttimer.annotation_bean.BindClass;
import com.lyb.besttimer.common_work.constants.IntentConstants;

@BindClass(path = IntentConstants.ACTIVITY_SPLASH)
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.btn_toLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, BindClassCenter.findClass(IntentConstants.ACTIVITY_SPLASH)));
            }
        });
    }
}
