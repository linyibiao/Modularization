package com.lyb.besttimer.modularization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lyb.besttimer.annotation_api.BindClassCenter;
import com.lyb.besttimer.lib_common.constants.IntentConstants;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, BindClassCenter.findClass(IntentConstants.ACTIVITY_LOGIN)));
    }
}
