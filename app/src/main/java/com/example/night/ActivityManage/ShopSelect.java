package com.example.night.ActivityManage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.night.Adapter.ShopSelectVIewPager2Adapter;
import com.example.night.R;
import com.example.night.fragmentManage.PictureFragment_home;
import com.example.night.fragmentManage.shop.ShopMealFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class ShopSelect extends AppCompatActivity {
    TextView textViewSumCount;
    LinearLayout layout;
    NestedScrollView nestedScrollView;
    Button buttonClearing;
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
        layout = findViewById(R.id.ToolbarHide);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > 850) {
                    layout.setVisibility(View.VISIBLE);
                } else {
                    layout.setVisibility(View.GONE);
                }
            }
        });

        tableLayout = findViewById(R.id.shopSelectA_tableLayout);
        viewPager2 = findViewById(R.id.shopSelectA_viewPager2);
        textViewSumCount = findViewById(R.id.Sum_count);
        buttonClearing = findViewById(R.id.clearing);
        buttonClearing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonClearing.getText().equals("去结算")) {
                    /*ShopSelectVIewPager2Adapter shopSelectVIewPager2Adapter = new ShopSelectVIewPager2Adapter(ShopSelect.this, fragments);
                    viewPager2.setAdapter(shopSelectVIewPager2Adapter);
                    textViewSumCount.setText("0");*/
                    AlertDialog.Builder dialog = new AlertDialog.Builder(ShopSelect.this);
                    dialog.setTitle("提交订单后，骑手会飞奔过来的");
                    dialog.setMessage("确认进行结算吗，你总共花销" + textViewSumCount.getText() + ",还需2.5的配送费，总共" + (Double.valueOf((String) textViewSumCount.getText()) + 2.5));
                    dialog.setPositiveButton("确认订单", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ShopSelectVIewPager2Adapter shopSelectVIewPager2Adapter = new ShopSelectVIewPager2Adapter(ShopSelect.this, fragments);
                            viewPager2.setAdapter(shopSelectVIewPager2Adapter);
                            textViewSumCount.setText("0");
                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                }
            }
        });

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
    public void refreshAdd(String string) {
        double oldCount = Double.valueOf((String) textViewSumCount.getText()) + Double.valueOf(string);
        deliveryOrNot(oldCount);
        textViewSumCount.setText(String.format("%.2f", oldCount));
    }
    public void refreshDelete(String string) {
        double oldCount = Double.valueOf((String) textViewSumCount.getText()) - Double.valueOf(string);
        deliveryOrNot(oldCount);
        textViewSumCount.setText(String.format("%.2f", oldCount));
    }
    public void deliveryOrNot(double oldcount) {
        if (oldcount > 30 || oldcount == 30) {
            buttonClearing.setText("去结算");
        } else {
            buttonClearing.setText("满30起送");
        }
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
        for (int i = 0; i < 2; i++) {
            ShopMealFragment shopMealFragment = new ShopMealFragment();
            fragments.add(shopMealFragment);
        }

        PictureFragment_home pictureFragmentHome = new PictureFragment_home();
        Bundle bundle = new Bundle();
        bundle.putString("image_url", String.valueOf(R.drawable.draw5));
        pictureFragmentHome.setArguments(bundle);
        fragments.add(pictureFragmentHome);

        PictureFragment_home pictureFragmentHome2 = new PictureFragment_home();
        Bundle bundle2 = new Bundle();
        bundle2.putString("image_url", String.valueOf(R.drawable.draw6));
        pictureFragmentHome2.setArguments(bundle2);
        fragments.add(pictureFragmentHome2);
    }
}