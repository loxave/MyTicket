package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    Animation app_splash, bottomtothetop;
    ImageView app_logo;
    TextView app_tagLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        bottomtothetop = AnimationUtils.loadAnimation(this, R.anim.bottomtothetop);
        // load element
        app_logo = findViewById(R.id.app_logo);
        app_tagLine = findViewById(R.id.app_tagLine);

        // run animation
        app_logo.startAnimation(app_splash);
        app_tagLine.startAnimation(bottomtothetop);

        //setting timer untuk 2 detik
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                //merubah activity ke activity lain
            Intent goGetStarted = new Intent(SplashActivity.this,GetStartedActivity.class);
            startActivity(goGetStarted);
            finish();
            }
        }, 2000); //2000 ms = 2 s
    }
}