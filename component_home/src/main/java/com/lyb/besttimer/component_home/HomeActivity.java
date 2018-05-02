package com.lyb.besttimer.component_home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lyb.besttimer.annotation_bean.BindClass;
import com.lyb.besttimer.common_work.bean.Repo;
import com.lyb.besttimer.common_work.constants.IntentConstants;
import com.lyb.besttimer.common_work.http.CommonHttpUtil;

import java.util.List;
import java.util.Locale;

import io.reactivex.functions.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@BindClass(path = IntentConstants.ACTIVITY_HOME)
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final TextView homeTv = findViewById(R.id.tv_home);
//        CommonHttpUtil.getRepoList(new Callback<List<Repo>>() {
//            @Override
//            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
//                if (response.body() != null) {
//                    homeTv.setText(String.format(Locale.CHINESE, "%d", response.body().size()));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Repo>> call, Throwable t) {
//
//            }
//        });
        CommonHttpUtil.getRepoList_rx(new Consumer<List<Repo>>() {
            @Override
            public void accept(List<Repo> repos) throws Exception {
                homeTv.setText(String.format(Locale.CHINESE, "%d", repos.size()));
            }
        });
    }
}
