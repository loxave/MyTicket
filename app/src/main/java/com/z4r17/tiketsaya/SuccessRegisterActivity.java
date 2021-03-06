package com.z4r17.tiketsaya;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SuccessRegisterActivity extends AppCompatActivity {

    Button btn_explore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);

        btn_explore = findViewById(R.id.btn_explore);
        btn_explore.setOnClickListener(view -> {
            Intent gotohome = new Intent(SuccessRegisterActivity.this,HomeActivity.class);
            startActivity(gotohome);
        });
    }
}