package com.example.tracex.db;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class UserDatabaseTest {

    private UserDatabase mUserDatabase;
    private UserDao mUserDao;
    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        mUserDatabase = Room.inMemoryDatabaseBuilder(context,UserDatabase.class).build();
        mUserDao = mUserDatabase.getDao();
    }

    @After
    public void tearDown() throws Exception {
        mUserDatabase.close();
    }

    @Test
    public void test1(){
        User user = new User();
        user.name = "Krishna";
        user.email = "krishna.vamsi543@gmail.com";
        user.phone = "7981451677";
        mUserDao.insert(user);
        List<User> list = mUserDao.getAllData();

        assertTrue(list.contains(user));
    }

    @Test

    public void test2(){
        User user = new User();
        user.name = "Krishna Vamsi";
        user.email = "VamsiKrishna@gmail.com";
        user.phone = "123456789";
        mUserDao.insert(user);
        List<User> list = mUserDao.getAllData();

        assertTrue(list.contains(user));
    }

    @Test
    public void test3(){
        User user = new User();
        user.name = "Vamsi Krishna";
        user.email = "kv@gmail.com";
        user.phone = "987654321";
        mUserDao.insert(user);
        List<User> list = mUserDao.getAllData();

        assertTrue(list.contains(user));
    }
}