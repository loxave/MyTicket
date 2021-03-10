package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TicketCheckoutActivity extends AppCompatActivity {

    Button btn_buy_ticket, btn_minus, btn_plus;
    LinearLayout btn_back_to_dashboard;
    TextView text_ticketTotal, text_myBalance, text_totalCost;
    Integer valueTicketTotal = 1;
    Integer myBalance = 500;
    Integer valueTotalCost = 50;
    Integer valueTicketCost = 75;
    ImageView money_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        text_ticketTotal = findViewById(R.id.text_ticketTotal);

        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        money_notice = findViewById(R.id.money_notice);

        text_myBalance = findViewById(R.id.text_myBalance);
        text_totalCost = findViewById(R.id.text_totalCost);

        //setting new value for some components
        text_ticketTotal.setText(valueTicketTotal.toString());
        text_myBalance.setText("US$ " +myBalance+"");
        valueTotalCost = valueTicketCost * valueTicketTotal;
        text_totalCost.setText("US$ " + valueTotalCost);

        //secara default, kita menghide hide button minus
        btn_minus.animate().alpha(0).setDuration(300).start();
        btn_minus.setEnabled(false);
        money_notice.setVisibility(View.GONE);

        btn_plus.setOnClickListener(view -> {
            valueTicketTotal+=1;
            text_ticketTotal.setText(valueTicketTotal.toString());
            if (valueTicketTotal >= 1){
                btn_minus.animate().alpha(1).setDuration(300).start();
                btn_minus.setEnabled(true);
            }
            valueTotalCost = valueTicketCost * valueTicketTotal;
            text_totalCost.setText("US$ " + valueTotalCost);
            if (valueTotalCost >= myBalance){
                btn_buy_ticket.animate().translationY(250).alpha(0).setDuration(350).start();
                btn_buy_ticket.setEnabled(false);
                text_myBalance.setTextColor(Color.parseColor("#D1206B"));
                money_notice.setVisibility(View.VISIBLE);
            }
        });

        btn_minus.setOnClickListener(view -> {
            valueTicketTotal-=1;
            text_ticketTotal.setText(valueTicketTotal.toString());
            if (valueTicketTotal < 2){
                btn_minus.animate().alpha(0).setDuration(300).start();
                btn_minus.setEnabled(false);
            }
            valueTotalCost = valueTicketCost * valueTicketTotal;
            text_totalCost.setText("US$ " + valueTotalCost);
            if (valueTotalCost <= myBalance){
                btn_buy_ticket.animate().translationY(0).alpha(1).setDuration(300).start();
                btn_buy_ticket.setEnabled(true);
                text_myBalance.setTextColor(Color.parseColor("#203DD1"));
                money_notice.setVisibility(View.GONE);
            }
        });



        btn_back_to_dashboard = findViewById(R.id.btn_back_to_dashboard);
        btn_back_to_dashboard.setOnClickListener(view -> {
            Intent backToDashboard = new Intent(TicketCheckoutActivity.this, HomeActivity.class);
            startActivity(backToDashboard);
        });


        btn_buy_ticket.setOnClickListener(view -> {
            Intent goToSuccessTicket = new Intent(TicketCheckoutActivity.this, SuccessBuyTicketActivity.class);
            startActivity(goToSuccessTicket);
        });
    }
}