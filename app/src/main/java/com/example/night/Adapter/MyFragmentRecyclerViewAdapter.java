package com.example.night.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.night.Bean.shopMessageSum;
import com.example.night.R;

import org.w3c.dom.Text;

import java.util.List;

public class MyFragmentRecyclerViewAdapter extends RecyclerView.Adapter<MyFragmentRecyclerViewAdapter.MyViewHolder> {
    List<shopMessageSum> shopMessageSumList;

    public MyFragmentRecyclerViewAdapter(List<shopMessageSum> shopMessageSumList) {
        this.shopMessageSumList = shopMessageSumList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.myFragment_item_imageView);
            textView = itemView.findViewById(R.id.myFragment_item_shopName);
            view = itemView;
        }
    }
    @NonNull
    @Override
    public MyFragmentRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_recyclerview_item_1, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyFragmentRecyclerViewAdapter.MyViewHolder holder, int position) {
        shopMessageSum shopMessageSum = shopMessageSumList.get(position);
        holder.imageView.setImageResource(shopMessageSum.getImageID());
        holder.textView.setText(shopMessageSum.getName());
    }

    @Override
    public int getItemCount() {
        return shopMessageSumList.size();
    }
}
