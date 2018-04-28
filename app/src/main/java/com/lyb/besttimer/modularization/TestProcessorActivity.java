package com.lyb.besttimer.modularization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lyb.besttimer.lib_annotation.BindClass;
import com.lyb.besttimer.lib_common.constants.IntentConstants;

@BindClass(path = IntentConstants.ACTIVITY_LOGIN)
public class TestProcessorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_processor);
    }
}
