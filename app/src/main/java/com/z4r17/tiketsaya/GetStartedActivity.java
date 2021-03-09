package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GetStartedActivity extends AppCompatActivity {

    Button btn_sign_in, btn_new_account_create;
    Animation topToTheBottom, bottomtothetop;
    ImageView emblem_app;
    TextView intro_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        //load animation
        topToTheBottom = AnimationUtils.loadAnimation(this, R.anim.toptothebottom);
        bottomtothetop = AnimationUtils.loadAnimation(this, R.anim.bottomtothetop);

        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_new_account_create = findViewById(R.id.btn_new_account_create);

        emblem_app = findViewById(R.id.emblem_app);
        intro_app = findViewById(R.id.intro_app);

        //run animation
        emblem_app.startAnimation(topToTheBottom);
        intro_app.startAnimation(topToTheBottom);
        btn_sign_in.startAnimation(bottomtothetop);
        btn_new_account_create.startAnimation(bottomtothetop);

        btn_sign_in.setOnClickListener(view -> {
            Intent goToSignIn = new Intent(GetStartedActivity.this,SignInActivity.class);
            startActivity(goToSignIn);
            //finish();
        });

        btn_new_account_create.setOnClickListener(view -> {
            Intent gotoRegisterOne = new Intent(GetStartedActivity.this, RegisterOneActivity.class);
            startActivity(gotoRegisterOne);
        });
    }
}