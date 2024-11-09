package com.example.night.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.night.ActivityManage.ShopSelect;
import com.example.night.Bean.shopMessageSum;
import com.example.night.R;

import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder> {
    List<shopMessageSum> shopMessageSumList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.home_item_imageView);
            textView = itemView.findViewById(R.id.dian_name);
            view = itemView;
        }
    }

    public HomeRecyclerViewAdapter(List<shopMessageSum> shopMessageSumList) {
        this.shopMessageSumList = shopMessageSumList;
    }

    @NonNull
    @Override
    public HomeRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recyclerview_item_1, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        Log.d("唉，又来测试了", "我来了");
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerViewAdapter.MyViewHolder holder, int position) {
        shopMessageSum shopMessageSum = shopMessageSumList.get(position);
        holder.imageView.setImageResource(shopMessageSum.getImageID());
        holder.textView.setText(shopMessageSum.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ShopSelect.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopMessageSumList.size();
    }
}
