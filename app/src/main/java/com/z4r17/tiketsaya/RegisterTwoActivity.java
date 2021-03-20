package com.z4r17.tiketsaya;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class RegisterTwoActivity extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_continue, btn_add_photo;
    ImageView pic_photo_register_user;

    EditText bio, full_name;

    Uri photo_location;
    Integer photoMAX = 1;
    DatabaseReference reference;
    StorageReference storage;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_two);

        getUsernameLocal();

        btn_continue = findViewById(R.id.btn_continue);
        btn_back = findViewById(R.id.btn_back);
        btn_add_photo = findViewById(R.id.btn_add_photo);
        pic_photo_register_user = findViewById(R.id.pic_photo_register_user);
        full_name = findViewById(R.id.full_name);
        bio = findViewById(R.id.bio);

        btn_add_photo.setOnClickListener(view -> {
            findPhoto();
        });

        btn_continue.setOnClickListener(view -> {

            //ubah state menjadi loading
            btn_continue.setEnabled(false);
            btn_continue.setText("Loading...");

            //menyimpan pada firebase
            reference  = FirebaseDatabase.getInstance().getReference().child("Users").child(username_key_new);
            storage = FirebaseStorage.getInstance().getReference().child("Photousers").child(username_key_new);

            // validasi untuk file (apakah ada?)
            if (photo_location != null){
                StorageReference storageReference =
                        storage.child(System.currentTimeMillis() + "." +
                                getFileExtension(photo_location));
                storageReference.putFile(photo_location)
                        .addOnSuccessListener(taskSnapshot -> storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                String uri_photo = uri.toString();
                                reference.getRef().child("url_photo_profile").setValue(uri_photo);
                                reference.getRef().child("nama_lengkap").setValue(full_name);
                                reference.getRef().child("bio").setValue(bio);
                            }
                        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {

                                Intent goToSuccess = new Intent(RegisterTwoActivity.this, SuccessRegisterActivity.class);
                                startActivity(goToSuccess);
                                finish();
                            }
                        })).addOnCompleteListener(task -> {
                        });
            }
        });

        btn_back.setOnClickListener(view -> {
            Intent backToPrev = new Intent(RegisterTwoActivity.this, RegisterOneActivity.class);
            startActivity(backToPrev);
        });
    }

    String getFileExtension(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    public void findPhoto(){
        Intent pic = new Intent();
        pic.setType("Image/*");
        pic.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(pic, photoMAX);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == photoMAX && resultCode == RESULT_OK && resultCode == RESULT_OK && data != null && data.getData() != null){

            photo_location = data.getData();
            Picasso.with(this).load(photo_location).centerCrop().fit().into(pic_photo_register_user);
        }
    }

    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");
    }
}