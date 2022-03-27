package com.example.tracex.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.tracex.DescActivity;
import com.example.tracex.R;
import com.example.tracex.db.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    List<User> list;
    Context context;

    public MyAdapter(Context context){
        this.context = context;
        list = new ArrayList<>();
    }
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_view_holder,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        User user = list.get(position);
        holder.mName.setText(user.getName());
        holder.mPhone.setText(user.getPhone());
        holder.mLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, DescActivity.class);
            intent.putExtra(DescActivity.NAME_KEY,user.getName());
            intent.putExtra(DescActivity.EMAIL_KEY,user.getEmail());
            intent.putExtra(DescActivity.PHONE_KEY,user.getPhone());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<User> list){
        this.list = list;
        notifyDataSetChanged();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mName, mPhone;
        ConstraintLayout mLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name);
            mPhone = itemView.findViewById(R.id.phone);
            mLayout = itemView.findViewById(R.id.view_holder_layout);
        }
    }
}
