package com.z4r17.tiketsaya;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {

    Button btn_sign_in;
    TextView btn_new_account;
    EditText xusername, xpassword;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_new_account = findViewById(R.id.btn_new_account);
        xusername = findViewById(R.id.xusername);
        xpassword = findViewById(R.id.xpassword);

        btn_sign_in.setOnClickListener(view -> {

           final String username = xusername.getText().toString();
            String password = xpassword.getText().toString();

            reference  = FirebaseDatabase.getInstance().getReference().child("Users")
                    .child(username);

            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                     if(snapshot.exists()){
                         Toast.makeText(getApplicationContext(), "Username ada", Toast.LENGTH_SHORT).show();

                         //berpindah activity
                         Intent goToHome = new Intent(SignInActivity.this, HomeActivity.class);
                         startActivity(goToHome);
                     }
                    else {
                         Toast.makeText(getApplicationContext(), "Username tidak ada!", Toast.LENGTH_SHORT).show();
                     }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getApplicationContext(), "Database Error", Toast.LENGTH_SHORT).show();
                }
            });

        });

        btn_new_account.setOnClickListener(view -> {
            Intent gotoRegisterOne = new Intent(SignInActivity.this, RegisterOneActivity.class);
            startActivity(gotoRegisterOne);
        });
    }
}