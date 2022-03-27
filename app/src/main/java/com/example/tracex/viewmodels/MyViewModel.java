package com.example.tracex.viewmodels;

import android.app.Application;
import android.content.Context;
import com.example.tracex.db.User;
import com.example.tracex.db.UserDatabase;

import org.jetbrains.annotations.NotNull;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class MyViewModel extends AndroidViewModel {


    LiveData<List<User>> live;
    Application mApplication;
    public MyViewModel(@NonNull @NotNull Application application) {
        super(application);
        mApplication = application;
        live = UserDatabase.getInstance(application.getApplicationContext()).getDao().getAllDataLive();

    }


    public void updateLive(User user){
        UserDatabase.getInstance(mApplication.getApplicationContext()).getDao().insert(user);
    }

    public LiveData<List<User>> getLiveData(){
        return live;
    }


}
