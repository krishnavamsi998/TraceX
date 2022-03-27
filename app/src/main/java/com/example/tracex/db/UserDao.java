package com.example.tracex.db;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Query("SELECT * FROM USER")
    List<User> getAllData();

    @Insert
    void insert(User user);

    @Query("SELECT * FROM USER")
    LiveData<List<User>> getAllDataLive();
}
