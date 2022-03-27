package com.example.tracex.network;

import android.content.Context;
import android.widget.Toast;

import com.example.tracex.db.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DaoFirebase {
    public static FirebaseDatabase mFirebaseDatabase;
    Context context;
    public DaoFirebase(Context context){
        this.context = context;
        if(mFirebaseDatabase == null){
            mFirebaseDatabase = FirebaseDatabase.getInstance("https://tracex-12cee-default-rtdb.asia-southeast1.firebasedatabase.app");
        }
    }

    public void push(User user){
        DatabaseReference databaseReference = mFirebaseDatabase.getReference(User.class.getSimpleName());
        databaseReference
                .push()
                .setValue(user)
                .addOnSuccessListener(unused -> Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show());

    }
}
