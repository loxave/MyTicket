package com.z4r17.tiketsaya;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterTwoActivity extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_two);

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(view -> {
            Intent gotosuccess = new Intent(RegisterTwoActivity.this, SuccessRegisterActivity.class);
            startActivity(gotosuccess);
            finish();
        });

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent backtoprev = new Intent(RegisterTwoActivity.this, RegisterOneActivity.class);
            startActivity(backtoprev);
        });
    }
}