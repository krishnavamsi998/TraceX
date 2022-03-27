package com.example.tracex;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void test1(){
        mActivityScenarioRule.getScenario().onActivity(activity -> {
            RecyclerView rv = activity.findViewById(R.id.my_recycler_view);
            assertNotNull(rv);
        });
    }

    @Test
    public void test2(){
        mActivityScenarioRule.getScenario().onActivity(activity -> {
            FloatingActionButton fab = activity.findViewById(R.id.fab);
            assertNotNull(fab);
        });
    }

}