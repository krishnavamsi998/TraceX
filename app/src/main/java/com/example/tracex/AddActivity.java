package com.example.tracex;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.tracex.db.User;

import com.example.tracex.network.DaoFirebase;
import com.example.tracex.viewmodels.MyViewModel;


public class AddActivity extends AppCompatActivity {

    EditText mName,mEmail,mPhone;
    Button mAdd,mCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mName = findViewById(R.id.name_input);
        mEmail = findViewById(R.id.email_input);
        mPhone = findViewById(R.id.phone_input);
        mAdd = findViewById(R.id.add);
        mCancel = findViewById(R.id.cancel);


        mAdd.setOnClickListener(view -> {
            String name = mName.getText().toString();
            String email = mEmail.getText().toString();
            String phone = mPhone.getText().toString();
            User user = new User();
            user.name = name;
            user.email = email;
            user.phone = phone;
            new MyViewModel(getApplication()).updateLive(user);
            new DaoFirebase(getApplicationContext()).push(user);
            finish();
        });

        mCancel.setOnClickListener(view -> finish());
    }
}
