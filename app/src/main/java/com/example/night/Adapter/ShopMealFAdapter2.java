package com.example.night.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.night.Bean.ShopMessage1;
import com.example.night.R;

public class ShopMealFAdapter2 extends RecyclerView.Adapter<ShopMealFAdapter2.MyViewHolder> {
    ShopMessage1 shopMessage1;

    public ShopMealFAdapter2(ShopMessage1 shopMessage1) {
        this.shopMessage1 = shopMessage1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView recyclerView;
        View view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_title);
            recyclerView = itemView.findViewById(R.id.shopMealFragment_recycler_recycler);
            view = itemView;
        }
    }
    @NonNull
    @Override
    public ShopMealFAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopmealfragment_recyclerview2, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopMealFAdapter2.MyViewHolder holder, int position) {
        ShopMessage1.SpeciesMeal speciesMeal = shopMessage1.getSpeciesMeal().get(position);
        holder.textView.setText(speciesMeal.getKindName());
        Log.d("nightaaa", "speciesMeal.getKindName(111)" + speciesMeal.getKindName());
        ShopMealFragmentRecyAdapter2_2 shopMealFragmentRecyAdapter22 = new ShopMealFragmentRecyAdapter2_2(speciesMeal);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.setAdapter(shopMealFragmentRecyAdapter22);
    }

    @Override
    public int getItemCount() {
        return shopMessage1.getSpeciesMeal().size();
    }
}
