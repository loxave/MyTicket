package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class RegisterOneActivity extends AppCompatActivity {

    Button btn_continue;
    LinearLayout btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_one);

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(view -> {
            Intent gotoNextRegister =  new Intent(RegisterOneActivity.this,RegisterTwoActivity.class);
            startActivity(gotoNextRegister);
        });
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent backToSignIn = new Intent(RegisterOneActivity.this, SignInActivity.class);
            startActivity(backToSignIn);
        });
    }
}