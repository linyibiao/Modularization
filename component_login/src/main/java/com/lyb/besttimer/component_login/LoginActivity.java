package com.lyb.besttimer.component_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lyb.besttimer.annotation_api.BindClassCenter;
import com.lyb.besttimer.annotation_bean.BindClass;
import com.lyb.besttimer.common_work.constants.IntentConstants;

@BindClass(path = IntentConstants.ACTIVITY_LOGIN)
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        startActivity(new Intent(this, BindClassCenter.findClass(IntentConstants.ACTIVITY_HOME)));
    }

}
