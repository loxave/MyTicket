package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //setting timer untuk 1 detik
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            //merubah activity ke activity lain
            Intent goGetStarted = new Intent(SplashActivity.this,GetStartedActivity.class);
            startActivity(goGetStarted);
            finish();
        }, 2000); //1000 ms = 1 s
    }
}