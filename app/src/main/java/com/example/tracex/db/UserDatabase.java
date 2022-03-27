package com.example.tracex.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao getDao();

    public static UserDatabase instance;

    public static UserDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context,UserDatabase.class,"user_data_base_2")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
