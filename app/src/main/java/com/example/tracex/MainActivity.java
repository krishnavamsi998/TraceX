package com.example.tracex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import com.example.tracex.adapters.MyAdapter;
import com.example.tracex.db.User;
import com.example.tracex.viewmodels.MyViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initializing recycler view and Adapters and connecting respective components
        mAdapter = new MyAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //adding observers to live data
        MyViewModel vm = new ViewModelProvider(this).get(MyViewModel.class);
        Observer<List<User>> observer = users -> mAdapter.setData(users);
        vm.getLiveData().observe(this,observer);



        //Floating action button to add new data
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
        });

    }
}