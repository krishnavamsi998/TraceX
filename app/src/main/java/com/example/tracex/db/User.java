package com.example.tracex.db;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int key;

    @ColumnInfo(name = "name")
    public String name;

    public String email;

    public String phone;

    public User(){

    }


    public boolean equals(@Nullable User obj) {
        assert obj != null;
        return this.name.equals(((User) obj).getName()) && this.email.equals(((User) obj).getEmail()) && this.phone.equals(((User) obj).getPhone());
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
