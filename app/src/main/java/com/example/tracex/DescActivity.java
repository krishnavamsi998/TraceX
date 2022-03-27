package com.example.tracex;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class DescActivity extends AppCompatActivity {

    public static final String PHONE_KEY = "com.example.tracex.DescActivity.PHONE_KEY";
    public static String NAME_KEY = "com.example.tracex.DescActivity.TITLE_KEY";
    public static String EMAIL_KEY = "com.example.tracex.DescActivity.SUBTITLE_KEY";

    EditText mName,mEmail,mPhone;
    String data1,data2,data3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);


        mName = findViewById(R.id.name_field);
        mEmail = findViewById(R.id.email_field);
        mPhone = findViewById(R.id.phone_field);

        getData();
        setData();
    }

    public void getData(){
        data1 = getIntent().getStringExtra(NAME_KEY);
        data2 = getIntent().getStringExtra(EMAIL_KEY);
        data3 = getIntent().getStringExtra(PHONE_KEY);
    }

    public void setData(){
        mName.setText(data1);
        mEmail.setText(data2);
        mPhone.setText(data3);
    }
}