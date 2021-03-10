package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyProfileActivity extends AppCompatActivity {


    LinearLayout item_my_ticket;
    Button btn_edit_profile;
    Button btn_sign_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        btn_sign_out = findViewById(R.id.btn_sign_out);
        btn_edit_profile = findViewById(R.id.btn_edit_profile);

        item_my_ticket = findViewById(R.id.item_my_ticket);

        btn_edit_profile.setOnClickListener(view -> {
            Intent goToEditProfile = new Intent(MyProfileActivity.this, EditProfileActivity.class );
            startActivity(goToEditProfile);
        });

        btn_sign_out.setOnClickListener(view -> {
            Intent goToHome =  new Intent(MyProfileActivity.this, HomeActivity.class);
            startActivity(goToHome);
        });

        item_my_ticket.setOnClickListener(view -> {
            Intent goToMyTickets = new Intent(MyProfileActivity.this, MyTicketDetailActivity.class);
            startActivity(goToMyTickets);
        });
    }
}