package com.example.night.ActivityManage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.night.Adapter.ShopSelectVIewPager2Adapter;
import com.example.night.R;
import com.example.night.fragmentManage.shop.ShopMealFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class ShopSelect extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tableLayout;
    ViewPager2 viewPager2;
    List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop_select);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbar = findViewById(R.id.shopSelectA_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.img_27);
        }

        tableLayout = findViewById(R.id.shopSelectA_tableLayout);
        viewPager2 = findViewById(R.id.shopSelectA_viewPager2);

        initData();
        ShopSelectVIewPager2Adapter shopSelectVIewPager2Adapter = new ShopSelectVIewPager2Adapter(this, fragments);
        viewPager2.setAdapter(shopSelectVIewPager2Adapter);
        new TabLayoutMediator(tableLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                if (i == 0) {
                    tab.setText("点菜");
                } else if (i == 1) {
                    tab.setText("超优惠");
                } else if (i == 2) {
                    tab.setText("评价");
                } else if (i == 3) {
                    tab.setText("商家");
                } else {
                    tab.setText("加载错了");
                }
            }
        }).attach();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void initData() {
        fragments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ShopMealFragment shopMealFragment = new ShopMealFragment();
            fragments.add(shopMealFragment);
        }
    }
}