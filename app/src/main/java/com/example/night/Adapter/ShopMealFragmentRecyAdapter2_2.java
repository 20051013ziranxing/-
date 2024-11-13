package com.example.night.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.night.Bean.ShopMessage1;
import com.example.night.R;

import org.w3c.dom.Text;

import java.util.List;

public class ShopMealFragmentRecyAdapter2_2 extends RecyclerView.Adapter<ShopMealFragmentRecyAdapter2_2.MyViewHolder> {
    List<ShopMessage1.AllMeal> allMealList;

    public ShopMealFragmentRecyAdapter2_2(ShopMessage1.SpeciesMeal speciesMeal) {
        this.allMealList = speciesMeal.getAllMealList();
        Log.d("nightaaa", "allMeal.getMealName(aaaaaaaa)" + allMealList.size());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
        View view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d("nightaaa", "allMeal.getMealName(aaaaaaaa)");
            imageView = itemView.findViewById(R.id.imageView_mealPicture);
            textViewName = itemView.findViewById(R.id.textView_mealName);
            textViewPrice = itemView.findViewById(R.id.textView_mealPrice);
            view = itemView;
        }
    }
    @NonNull
    @Override
    public ShopMealFragmentRecyAdapter2_2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.smf_recyclerview_recycleritem, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopMealFragmentRecyAdapter2_2.MyViewHolder holder, int position) {
        ShopMessage1.AllMeal allMeal = allMealList.get(position);
        holder.imageView.setImageResource(allMeal.getMealPicture());
        holder.textViewName.setText(allMeal.getMealName());
        holder.textViewPrice.setText(allMeal.getMealPrice());
        Log.d("nightaaa", allMeal.getMealName() + "allMeal.getMealName()");
    }

    @Override
    public int getItemCount() {
        return allMealList.size();
    }
}
