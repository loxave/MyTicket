package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TicketDetailActivity extends AppCompatActivity {

    Button btn_buy_ticket;
    LinearLayout btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToDashboard = new Intent(TicketDetailActivity.this, HomeActivity.class);
                startActivity(backToDashboard);
            }
        });

        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);

        btn_buy_ticket.setOnClickListener(view -> {

            Intent goToCheckOut = new Intent(TicketDetailActivity.this, TicketCheckoutActivity.class);
            startActivity(goToCheckOut);
        });

    }
}