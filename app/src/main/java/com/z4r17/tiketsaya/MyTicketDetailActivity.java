package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MyTicketDetailActivity extends AppCompatActivity {

    LinearLayout btn_back_to_edit_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ticket_detail);

        btn_back_to_edit_profile = findViewById(R.id.btn_back_to_edit_profile);
        btn_back_to_edit_profile.setOnClickListener(view -> {
            Intent prevEditProfile = new Intent(MyTicketDetailActivity.this, MyProfileActivity.class);
            startActivity(prevEditProfile);
        });

    }
}