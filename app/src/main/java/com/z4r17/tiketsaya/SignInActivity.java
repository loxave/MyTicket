package com.z4r17.tiketsaya;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    Button btn_sign_in;
    TextView btn_new_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_new_account = findViewById(R.id.btn_new_account);

        btn_sign_in.setOnClickListener(view -> {
            Intent gotohome = new Intent(SignInActivity.this,HomeActivity.class);
            startActivity(gotohome);
        });

        btn_new_account.setOnClickListener(view -> {
            Intent gotoregisterone = new Intent(SignInActivity.this,RegisterOneActivity.class);
            startActivity(gotoregisterone);
        });
    }

}