package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyProfileActivity extends AppCompatActivity {

    Button btn_back_to_home;
    LinearLayout item_my_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        btn_back_to_home = findViewById(R.id.btn_back_to_home);

        item_my_ticket = findViewById(R.id.item_my_ticket);

        btn_back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHome =  new Intent(MyProfileActivity.this, HomeActivity.class);
                startActivity(goToHome);
            }
        });

        item_my_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMyTickets = new Intent(MyProfileActivity.this, MyTicketDetailActivity.class);
                startActivity(goToMyTickets);
            }
        });
    }
}