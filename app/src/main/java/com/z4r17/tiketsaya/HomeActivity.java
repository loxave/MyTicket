package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.florent37.shapeofview.shapes.CircleView;

public class HomeActivity extends AppCompatActivity {

    LinearLayout btn_ticket_pisa;
    CircleView btn_to_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_to_profile = findViewById(R.id.btn_to_profile);
        btn_ticket_pisa = findViewById(R.id.btn_ticket_pisa);

        btn_to_profile.setOnClickListener(view -> {
            Intent goToProfile = new Intent(HomeActivity.this,MyProfileActivity.class);
            startActivity(goToProfile);
        });
        btn_ticket_pisa.setOnClickListener(view -> {
            Intent goToPisaTicket = new Intent(HomeActivity.this, TicketDetailActivity.class);
            startActivity(goToPisaTicket);
        });
    }
}