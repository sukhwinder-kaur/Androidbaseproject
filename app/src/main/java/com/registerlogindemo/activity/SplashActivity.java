package com.registerlogindemo.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.registerlogindemo.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //--------------set thresd for sleep the splash for 2 seconds-------------//
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                gotoLoginActivity();
            }
        }, 2000);
    }
}
