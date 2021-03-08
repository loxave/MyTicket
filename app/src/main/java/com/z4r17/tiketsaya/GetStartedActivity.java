package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class GetStartedActivity extends AppCompatActivity {

    Button btn_sign_in, btn_new_account_create;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_new_account_create = findViewById(R.id.btn_new_account_create);

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