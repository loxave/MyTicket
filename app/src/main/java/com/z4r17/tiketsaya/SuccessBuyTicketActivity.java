package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessBuyTicketActivity extends AppCompatActivity {

    Button btn_view_ticket;
    Button btn_my_dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_buy_ticket);

        btn_my_dashboard = findViewById(R.id.btn_my_dashboard);
        btn_my_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent backToDashboard = new Intent(SuccessBuyTicketActivity.this, HomeActivity.class);
                startActivity(backToDashboard);
            }
        });

    }
}