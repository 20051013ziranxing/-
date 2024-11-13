package com.example.night.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.night.Bean.PersonalHistory;
import com.example.night.R;

public class IntentFragmentRecyclerViewAdapter2 extends RecyclerView.Adapter<IntentFragmentRecyclerViewAdapter2.MyViewHolder> {
    PersonalHistory personalHistory;

    public IntentFragmentRecyclerViewAdapter2(PersonalHistory personalHistory) {
        this.personalHistory = personalHistory;
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewShopName;
        RecyclerView recyclerView;
        Button buttonCount;
        View view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.intent_fragment_recycler_item2_imageView);
            textViewShopName = itemView.findViewById(R.id.intent_fragment_recycler_shopName);
            recyclerView = itemView.findViewById(R.id.intent_fragment_recycler_item2_recycler);
            buttonCount = itemView.findViewById(R.id.intent_fragment_recycler_item2_pieceSum);
            view = itemView;
        }
    }

    @NonNull
    @Override
    public IntentFragmentRecyclerViewAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.intent_fragment_recycler_item2, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IntentFragmentRecyclerViewAdapter2.MyViewHolder holder, int position) {
        PersonalHistory.BoughtSomething boughtSomething = personalHistory.getBoughtSomethingList().get(position);
        holder.imageView.setImageResource(boughtSomething.getShopPicture());
        holder.textViewShopName.setText(boughtSomething.getShopName());
        holder.buttonCount.setText(boughtSomething.getTotalCost());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        Intent_ftagment_2_2Adapter intentFtagment22Adapter = new Intent_ftagment_2_2Adapter(boughtSomething);
        holder.recyclerView.setAdapter(intentFtagment22Adapter);
    }

    @Override
    public int getItemCount() {
        return personalHistory.getBoughtSomethingList().size();
    }
}
