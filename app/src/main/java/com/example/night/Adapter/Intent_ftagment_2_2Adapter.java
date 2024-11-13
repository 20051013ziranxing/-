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

public class Intent_ftagment_2_2Adapter extends RecyclerView.Adapter<Intent_ftagment_2_2Adapter.MyViewHolder>{
    PersonalHistory.BoughtSomething boughtSomething;

    public Intent_ftagment_2_2Adapter(PersonalHistory.BoughtSomething boughtSomething) {
        this.boughtSomething = boughtSomething;
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.intent_fragment_2_2_imageView);
            textView = itemView.findViewById(R.id.intent_fragment_2_2_textView);
            view = itemView;
        }
    }
    @NonNull
    @Override
    public Intent_ftagment_2_2Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.intent_fragment_recycler_item_2_2, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Intent_ftagment_2_2Adapter.MyViewHolder holder, int position) {
        PersonalHistory.BoughtThing boughtThing = boughtSomething.getBoughtThingList().get(position);
        holder.imageView.setImageResource(boughtThing.getThingPicture());
        holder.textView.setText(boughtThing.getThingName());
    }

    @Override
    public int getItemCount() {
        return boughtSomething.getBoughtThingList().size();
    }
}
