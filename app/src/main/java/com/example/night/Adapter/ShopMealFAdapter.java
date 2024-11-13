package com.example.night.Adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.night.Bean.ShopMessage1;
import com.example.night.R;

public class ShopMealFAdapter extends RecyclerView.Adapter<ShopMealFAdapter.MyViewHolder> {
    final static String TAG = "nightAAA";

    OnItemClickListener onItemClickListener;
    ShopMessage1 shopMessage1;

    public ShopMealFAdapter(ShopMessage1 shopMessage1) {
        this.shopMessage1 = shopMessage1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.kind_of_selection);
            view = itemView;
        }
    }
    @NonNull
    @Override
    public ShopMealFAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopmealfragment_recyclerview1, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopMealFAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ShopMessage1.SpeciesMeal speciesMeal = shopMessage1.getSpeciesMeal().get(position);
        holder.textView.setText(speciesMeal.getKindName());
        Log.d(TAG, "我开始加载滚动控件了" + speciesMeal.getKindName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    Log.d(TAG, "我点击了？？？");
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopMessage1.getSpeciesMeal().size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}
