package com.example.tracex.livedatas;

import com.example.tracex.db.User;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class MyLiveData extends MutableLiveData<List<User>> {
    private static MyLiveData mMyLiveData;

    public static MyLiveData getMyLiveData() {
        if(mMyLiveData == null){
            mMyLiveData = new MyLiveData();
            mMyLiveData.setValue(new ArrayList<>());
        }
        return mMyLiveData;
    }


}
