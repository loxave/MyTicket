package com.z4r17.tiketsaya;

import android.content.Intent;
import android.content.SharedPreferences;
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

    String USERNAME_KEY = "usernamekey";
    String username_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_new_account = findViewById(R.id.btn_new_account);
        xusername = findViewById(R.id.xusername);
        xpassword = findViewById(R.id.xpassword);


        btn_new_account.setOnClickListener(view -> {
            Intent gotoRegisterOne = new Intent(SignInActivity.this, RegisterOneActivity.class);
            startActivity(gotoRegisterOne);
        });

        btn_sign_in.setOnClickListener(view -> {

            // ubah state menjadi loading
            btn_sign_in.setEnabled(false);
            btn_sign_in.setText("Loading ...");

           final String username = xusername.getText().toString();
           final String password = xpassword.getText().toString();

           if(username.isEmpty()){
               Toast.makeText(getApplicationContext(),"Username kosong", Toast.LENGTH_SHORT).show();

               //ubah state menjadi loading
               btn_sign_in.setEnabled(true);
               btn_sign_in.setText("SIGN IN");
           } else {
               if (password.isEmpty()){
                   Toast.makeText(getApplicationContext(),"Password kosong!", Toast.LENGTH_SHORT).show();
                   btn_sign_in.setEnabled(true);
                   btn_sign_in.setText("SIGN IN");
               } else {

                   reference  = FirebaseDatabase.getInstance().getReference().child("Users")
                           .child(username);
               }
           }
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                     if(snapshot.exists()){

                         // ambil data password dari firebase
                         String passwordFromFirebase = snapshot.child("password").getValue().toString();

                         // validasi password dengan password firebase
                         if (password.equals(passwordFromFirebase)){

                             // simpan username (key) kepada local
                             SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                             SharedPreferences.Editor editor = sharedPreferences.edit();
                             editor.putString(username_key, xusername.getText().toString());
                             editor.apply();

                             //berpindah activity
                             Intent goToHome = new Intent(SignInActivity.this, HomeActivity.class);
                             startActivity(goToHome);
                         } else {
                             Toast.makeText(getApplicationContext(), "Password salah", Toast.LENGTH_SHORT).show();
                             btn_sign_in.setEnabled(true);
                             btn_sign_in.setText("SIGN IN");
                         }
                        //setelah username ada perlu simpan ke storage local
                         // ketika data usernamenya ada perlu cek dulu
                         // toast dihapus karena username sudah ada (masuk)
//                         Toast.makeText(getApplicationContext(), "Username ada", Toast.LENGTH_SHORT).show();

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

    }
}