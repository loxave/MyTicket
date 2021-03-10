package com.z4r17.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccessBuyTicketActivity extends AppCompatActivity {

    Button btn_view_ticket, btn_my_dashboard;
    Animation app_splash, bottomtothetop, toptothebottom;
    TextView app_subtitle, app_title;
    ImageView icon_success_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_buy_ticket);

        btn_view_ticket.findViewById(R.id.btn_view_ticket);
        btn_my_dashboard = findViewById(R.id.btn_my_dashboard);
        app_subtitle = findViewById(R.id.app_subtitle);
        app_title = findViewById(R.id.app_title);
        icon_success_ticket = findViewById(R.id.icon_success_ticket);

        // load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        bottomtothetop = AnimationUtils.loadAnimation(this, R.anim.bottomtothetop);
        toptothebottom = AnimationUtils.loadAnimation(this, R.anim.toptothebottom);
        
        // run animation
        btn_view_ticket.startAnimation(bottomtothetop);
        btn_my_dashboard.startAnimation(bottomtothetop);

        icon_success_ticket.startAnimation(app_splash);

        app_title.startAnimation(toptothebottom);
        app_subtitle.startAnimation(toptothebottom);

        btn_my_dashboard.setOnClickListener(view -> {

            Intent backToDashboard = new Intent(SuccessBuyTicketActivity.this, HomeActivity.class);
            startActivity(backToDashboard);
        });

    }
}