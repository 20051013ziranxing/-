package com.example.night.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.night.Bean.PersonalHistory;
import com.example.night.R;

import org.w3c.dom.Text;

public class IntentFragmentRecyclerAdapter1 extends RecyclerView.Adapter<IntentFragmentRecyclerAdapter1.MyViewHolder> {
    PersonalHistory personalHistory;

    public IntentFragmentRecyclerAdapter1(PersonalHistory personalHistory) {
        this.personalHistory = personalHistory;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewShopName;
        TextView textViewCount;
        View view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.intent_fragment_re1_ImageView);
            textViewShopName = itemView.findViewById(R.id.intent_fragment_re1_shopName);
            textViewCount = itemView.findViewById(R.id.intent_fragment_re1_count);
            view = itemView;
        }
    }

    @NonNull
    @Override
    public IntentFragmentRecyclerAdapter1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.intent_fragment_recycler_item1, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IntentFragmentRecyclerAdapter1.MyViewHolder holder, int position) {
        PersonalHistory.BoughtShop boughtShop = personalHistory.getBoughtShopList().get(position);
        holder.imageView.setImageResource(boughtShop.getShopPicture());
        holder.textViewShopName.setText(boughtShop.getShopName());
        holder.textViewCount.setText(boughtShop.getBoughtCount());
    }

    @Override
    public int getItemCount() {
        return personalHistory.getBoughtShopList().size();
    }
}
