package com.example.night.Adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.night.Bean.ToggleButtonCheck;
import com.example.night.R;
import com.example.night.fragmentManage.HomeFragment;

import java.util.List;

public class HomeButtonChoiceAdapter extends RecyclerView.Adapter<HomeButtonChoiceAdapter.MyViewHolder> {
    final static String TAG = "nightAAA";
    List<ToggleButtonCheck> stringList;
    RecyclerView recyclerView;
    HomeFragment homeFragment;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ToggleButton textView;
        View view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_button_choice);
            view = itemView;
        }
    }
    public HomeButtonChoiceAdapter(List<ToggleButtonCheck> stringList, HomeFragment homeFragment) {
        this.stringList = stringList;
        this.homeFragment = homeFragment;
    }
    @NonNull
    @Override
    public HomeButtonChoiceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recyclerview_button_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeButtonChoiceAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String s = stringList.get(position).getName();
        holder.textView.setText(s);
        holder.textView.setTextOff(s);
        holder.textView.setTextOn(s);
        holder.textView.setChecked(stringList.get(position).getCheckChoice());
        holder.textView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    homeFragment.changeChoice(position, true);
                    Log.d(TAG, position + s + "true");
                } else {
                    homeFragment.changeChoice(position, false);
                    Log.d(TAG, position + s + "false");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}
