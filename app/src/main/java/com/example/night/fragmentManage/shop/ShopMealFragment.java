package com.example.night.fragmentManage.shop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.night.Adapter.ShopMealFAdapter;
import com.example.night.Adapter.ShopMealFAdapter2;
import com.example.night.Bean.ShopMessage1;
import com.example.night.ParentRecyclerView;
import com.example.night.R;
import com.example.night.SQLiteHelper.model.shopMessageModel;
import com.example.night.presenter.shopMealFPresenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopMealFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopMealFragment extends Fragment {
    final static String TAG = "nightAAA";
    NestedScrollView nestedScrollView;
    TextView textViewTitle;
    List<Object> objectList;
    Banner banner;
    ShopMessage1 shopMessage1;
    RecyclerView recyclerView_classify;
    ParentRecyclerView recyclerView_mael2;
    shopMealFPresenter shopMealFPresenter;
    List<Integer> imageViewList;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShopMealFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopMealFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopMealFragment newInstance(String param1, String param2) {
        ShopMealFragment fragment = new ShopMealFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_meal, container, false);
        shopMealFPresenter = new shopMealFPresenter(this);
        banner = view.findViewById(R.id.shopMealFragment_banner);

        nestedScrollView = view.findViewById(R.id.shopMealFragment_nestedScrollView);
        textViewTitle = view.findViewById(R.id.shopMealFragment_textView_title);
        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > 400) {
                    textViewTitle.setText("招牌推荐0");
                    textViewTitle.setVisibility(View.VISIBLE);
                    if (scrollY > 2800) {
                        textViewTitle.setText("家常炒菜0");
                    }
                    if(scrollY > 5400) {
                        textViewTitle.setText("小吃主食0");
                    }
                } else {
                    textViewTitle.setVisibility(View.GONE);
                }
            }
        });

        recyclerView_classify = view.findViewById(R.id.shopMealFragment_RecyclerView1);
        recyclerView_mael2 = view.findViewById(R.id.shopMealFragment_RecyclerView2);
        shopMessage1 = shopMealFPresenter.getShopMessage1();
        Log.d(TAG, String.valueOf(shopMessage1.getSpeciesMeal().size()));
        initData();
        ShopMealFAdapter2 shopMealFAdapter2 = new ShopMealFAdapter2(objectList);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_mael2.setLayoutManager(linearLayoutManager2);
        recyclerView_mael2.setAdapter(shopMealFAdapter2);

        ShopMealFAdapter shopMealFAdapter = new ShopMealFAdapter(shopMessage1);
        shopMealFAdapter.setOnItemClickListener(new ShopMealFAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d(TAG, "我点击了？？？aaaaaaa" + position);
                try {
                    recyclerView_mael2.scrollToPosition(position * 8);
                } catch (Exception e) {
                    Log.d(TAG, String.valueOf(e));
                }
                Log.d(TAG, "我点击了？？？因该滚动完了" + position);
            }
        });

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_classify.setLayoutManager(linearLayoutManager1);
        recyclerView_classify.setAdapter(shopMealFAdapter);
        banner.setAdapter(new BannerImageAdapter<Integer>(imageViewList) {
            @Override
            public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                holder.imageView.setImageResource(data);
            }
        });
        banner.setIndicator(new CircleIndicator(getContext()));
        banner.start();
        return view;
    }

    public void initData() {
        imageViewList = new ArrayList<Integer>();
        imageViewList.add(R.drawable.img_29);
        imageViewList.add(R.drawable.img_30);
        objectList = new ArrayList<>();
        for (int i = 0; i < shopMessage1.getSpeciesMeal().size(); i++) {
            objectList.add(shopMessage1.getSpeciesMeal().get(i).getKindName());
            Log.d(TAG, "shopMessage1.getSpeciesMeal().get(i).getKindName()" + shopMessage1.getSpeciesMeal().get(i).getKindName());
            for (int j = 0; j < shopMessage1.getSpeciesMeal().get(i).getAllMealList().size(); j++) {
                objectList.add(shopMessage1.getSpeciesMeal().get(i).getAllMealList().get(j));
                Log.d(TAG, "shopMessage1.getSpeciesMeal().get(i).getAllMealList().get(j)" +
                        shopMessage1.getSpeciesMeal().get(i).getAllMealList().get(j).getMealName());
            }
        }
    }
}