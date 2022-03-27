package com.example.tracex;

import android.content.Intent;
import android.provider.ContactsContract;
import android.widget.EditText;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import static org.junit.Assert.*;


public class DescActivityTest {


    static Intent intent;
    static{
        intent = new Intent(ApplicationProvider.getApplicationContext(),DescActivity.class);
        intent.putExtra(DescActivity.NAME_KEY,"krishna vamsi");
        intent.putExtra(DescActivity.EMAIL_KEY,"krishna.vamsi543@gmail.com");
        intent.putExtra(DescActivity.PHONE_KEY,"7981451677");
    }
    @Rule
    public ActivityScenarioRule<DescActivity> activityScenarioRule = new ActivityScenarioRule<DescActivity>(intent);

    @Test
    public void test(){
        activityScenarioRule.getScenario().onActivity(activity -> {
           EditText e1 = activity.findViewById(R.id.name_field);
           EditText e2 = activity.findViewById(R.id.email_field);
           EditText e3 = activity.findViewById(R.id.phone_field);
           boolean e = e1 !=null && e2 !=null && e3 !=null;
           assertTrue(e);

           boolean b1 = e1.getText().toString().equals(intent.getStringExtra(DescActivity.NAME_KEY));
           boolean b2 = e2.getText().toString().equals(intent.getStringExtra(DescActivity.EMAIL_KEY));
           boolean b3 = e3.getText().toString().equals(intent.getStringExtra(DescActivity.PHONE_KEY));
           boolean b = b1 && b2 && b3;
           assertTrue(b);
        });


    }

}