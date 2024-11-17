package com.example.night.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.night.ActivityManage.ShopSelect;
import com.example.night.Bean.ShopMessage1;
import com.example.night.R;

import org.w3c.dom.Text;

import java.util.List;

public class ShopMealFAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> shopMessage1;

    public ShopMealFAdapter2(List<Object> shopMessage1) {
        this.shopMessage1 = shopMessage1;
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView recyclerView;
        View view;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_title);
            recyclerView = itemView.findViewById(R.id.shopMealFragment_recycler_recycler);
            view = itemView;
        }
    }
    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
        View view;
        ImageButton imageButtonAdd;
        ImageButton imageButtonDelete;
        TextView textViewCount;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            Log.d("nightaaa", "allMeal.getMealName(aaaaaaaa)");
            imageView = itemView.findViewById(R.id.imageView_mealPicture);
            textViewName = itemView.findViewById(R.id.textView_mealName);
            textViewPrice = itemView.findViewById(R.id.textView_mealPrice);
            imageButtonAdd = itemView.findViewById(R.id.imageButton_mealAddMeal);
            imageButtonDelete = itemView.findViewById(R.id.imageButton_mealDeleteMeal);
            textViewCount = itemView.findViewById(R.id.textView_mealCountBuy);
            view = itemView;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (shopMessage1.get(position) instanceof ShopMessage1.AllMeal) {
            return 2;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view;
        if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopmealfragment_recyclerview2,
                    parent, false);
            return new MyViewHolder1(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.smf_recyclerview_recycleritem,
                    parent, false);
            return new MyViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder1) {
            String s = (String) shopMessage1.get(position);
            ((MyViewHolder1) holder).textView.setText(s);
            Log.d("nightaaa", "speciesMeal.getKindName(111)" + s);
        } else {
            ShopMessage1.AllMeal allMeal = (ShopMessage1.AllMeal) shopMessage1.get(position);
            ((MyViewHolder2) holder).imageView.setImageResource(allMeal.getMealPicture());
            ((MyViewHolder2) holder).textViewName.setText(allMeal.getMealName());
            ((MyViewHolder2) holder).textViewPrice.setText(allMeal.getMealPrice());
            ((MyViewHolder2) holder).imageButtonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = String.valueOf(((MyViewHolder2) holder).textViewCount.getText());
                    String i = String.valueOf(1 + Double.valueOf(s));
                    ((MyViewHolder2) holder).textViewCount.setText(i);
                    ((ShopSelect)((MyViewHolder2) holder).imageView.getContext()).
                            refreshAdd(String.valueOf(((MyViewHolder2) holder).textViewPrice.getText()));
                }
            });
            ((MyViewHolder2) holder).imageButtonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = String.valueOf(((MyViewHolder2) holder).textViewCount.getText());
                    if (Double.valueOf(s) > 0) {
                        String i = String.valueOf(Double.valueOf(s) - 1);
                        ((MyViewHolder2) holder).textViewCount.setText(i);
                        ((ShopSelect)((MyViewHolder2) holder).imageView.getContext()).
                                refreshDelete(String.valueOf(((MyViewHolder2) holder).textViewPrice.getText()));
                    } else {

                    }
                }
            });
            Log.d("nightaaa", allMeal.getMealName() + "allMeal.getMealName()");
        }
    }

    /*@Override
    public void onBindViewHolder(@NonNull ShopMealFAdapter2.MyViewHolder holder, int position) {
        ShopMessage1.AllMeal speciesMeal = shopMessage1.get(position);
        holder.textView.setText(speciesMeal.getKindName());
        Log.d("nightaaa", "speciesMeal.getKindName(111)" + speciesMeal.getKindName());
        ShopMealFragmentRecyAdapter2_2 shopMealFragmentRecyAdapter22 = new ShopMealFragmentRecyAdapter2_2(speciesMeal);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.setAdapter(shopMealFragmentRecyAdapter22);
    }*/

    @Override
    public int getItemCount() {
        return shopMessage1.size();
    }
}
