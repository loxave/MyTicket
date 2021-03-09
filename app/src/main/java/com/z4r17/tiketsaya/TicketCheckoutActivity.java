package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TicketCheckoutActivity extends AppCompatActivity {

    Button btn_buy_ticket, btn_minus, btn_plus;
    LinearLayout btn_back_to_dashboard;
    TextView text_ticketTotal;
    Integer valueTicketTotal = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        text_ticketTotal = findViewById(R.id.text_ticketTotal);

        btn_plus.setOnClickListener(view -> {
            valueTicketTotal+=1;
            text_ticketTotal.setText(valueTicketTotal.toString());
        });


        btn_minus.setOnClickListener(view -> {
            valueTicketTotal-=1;
            text_ticketTotal.setText(valueTicketTotal.toString());
        });



        btn_back_to_dashboard = findViewById(R.id.btn_back_to_dashboard);
        btn_back_to_dashboard.setOnClickListener(view -> {
            Intent backToDashboard = new Intent(TicketCheckoutActivity.this, HomeActivity.class);
            startActivity(backToDashboard);
        });

        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        btn_buy_ticket.setOnClickListener(view -> {
            Intent goToSuccessTicket = new Intent(TicketCheckoutActivity.this, SuccessBuyTicketActivity.class);
            startActivity(goToSuccessTicket);
        });
    }
}