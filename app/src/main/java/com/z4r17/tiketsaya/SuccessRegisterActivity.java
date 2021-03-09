package com.z4r17.tiketsaya;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessRegisterActivity extends AppCompatActivity {

    Button btn_explore;
    Animation app_splash, bottomtothetop, toptothebottom;
    ImageView icon_success;
    TextView app_title, app_subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);

        icon_success = findViewById(R.id.icon_success);
        app_title = findViewById(R.id.app_title);
        app_subtitle = findViewById(R.id.app_subtitle);
        btn_explore = findViewById(R.id.btn_explore);

        // load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        bottomtothetop = AnimationUtils.loadAnimation(this, R.anim.bottomtothetop);
        toptothebottom  = AnimationUtils.loadAnimation(this, R.anim.toptothebottom);

        // run animation
        btn_explore.startAnimation(bottomtothetop);
        icon_success.startAnimation(app_splash);
        app_title.startAnimation(toptothebottom);
        app_subtitle.startAnimation(toptothebottom);

        btn_explore.setOnClickListener(view -> {
            Intent gotohome = new Intent(SuccessRegisterActivity.this,HomeActivity.class);
            startActivity(gotohome);
        });
    }
}