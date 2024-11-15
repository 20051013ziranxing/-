package com.example.night.fragmentManage;

import static android.app.ProgressDialog.show;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.night.Adapter.HomeButtonChoiceAdapter;
import com.example.night.Adapter.HomeRecyclerViewAdapter;
import com.example.night.Adapter.homeImageViewAdapter;
import com.example.night.Adapter.homeViewPager2Adapter;
import com.example.night.Bean.ToggleButtonCheck;
import com.example.night.Bean.shopMessageSum;
import com.example.night.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homeFragment extends Fragment {
    final static String TAG = "nightAAA";
    ImageView imageViewHide;
    RecyclerView recyclerView_buttonHide;
    ViewPager2 viewPager2_1;
    Toolbar toolbarHide;
    NestedScrollView nestedScrollView_1;
    List<Fragment> fragments_ViewPager2;
    List<ToggleButtonCheck> stringList_buttonChoice;
    RecyclerView recyclerView;
    HomeButtonChoiceAdapter homeButtonChoiceAdapter;
    CardView cardView;
    RecyclerView recyclerView_buttonChoice;
    List<shopMessageSum> shopMessageSumList;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public homeFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homeFragment.
     */
    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
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

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardView = view.findViewById(R.id.homeFragment_cardView);
        initData();
        toolbarHide = view.findViewById(R.id.homeFragment_Toolbar);
        recyclerView_buttonChoice = view.findViewById(R.id.Button_choice);
        recyclerView_buttonHide = view.findViewById(R.id.Button_choiceHide);
        homeButtonChoiceAdapter = new HomeButtonChoiceAdapter(stringList_buttonChoice, this);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_buttonChoice.setLayoutManager(linearLayoutManager1);
        recyclerView_buttonChoice.setAdapter(homeButtonChoiceAdapter);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_buttonHide.setLayoutManager(linearLayoutManager2);
        recyclerView_buttonHide.setAdapter(homeButtonChoiceAdapter);

        imageViewHide = view.findViewById(R.id.homeFragment_imageViewHide);

        viewPager2_1 = view.findViewById(R.id.home_ViewPager_1);
        homeViewPager2Adapter homeViewPager2Adapter = new homeViewPager2Adapter(getActivity(), fragments_ViewPager2);
        viewPager2_1.setAdapter(homeViewPager2Adapter);
        //首页的店铺的滚动控件
        recyclerView = view.findViewById(R.id.home_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        HomeRecyclerViewAdapter homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(shopMessageSumList);
        recyclerView.setAdapter(homeRecyclerViewAdapter);
        //对页面的滚动监听
        nestedScrollView_1 = view.findViewById(R.id.home_NestedScrollView_1);
        nestedScrollView_1.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > 180) {
                    toolbarHide.setVisibility(View.VISIBLE);

                } else {
                    toolbarHide.setVisibility(View.GONE);
                }
                if (scrollY > 1600) {
                    cardView.setVisibility(View.VISIBLE);
                } else {
                    cardView.setVisibility(View.GONE);
                }
            }
        });
    }

    public void initData() {
        stringList_buttonChoice = new ArrayList<>();
        stringList_buttonChoice.add(new ToggleButtonCheck("神卷商家", false));
        stringList_buttonChoice.add(new ToggleButtonCheck("配送进校", false));
        stringList_buttonChoice.add(new ToggleButtonCheck("减配送费", false));
        stringList_buttonChoice.add(new ToggleButtonCheck("津贴优惠", false));

        fragments_ViewPager2 = new ArrayList<>();
        PictureFragment_home pictureFragmentHome = new PictureFragment_home();
        Bundle bundle = new Bundle();
        bundle.putString("image_url", String.valueOf(R.drawable.draw1));
        pictureFragmentHome.setArguments(bundle);
        fragments_ViewPager2.add(pictureFragmentHome);

        PictureFragment_home pictureFragmentHome2 = new PictureFragment_home();
        Bundle bundle2 = new Bundle();
        bundle2.putString("image_url", String.valueOf(R.drawable.draw2));
        pictureFragmentHome2.setArguments(bundle2);
        fragments_ViewPager2.add(pictureFragmentHome2);

        shopMessageSumList = new ArrayList<>();
        shopMessageSum shopMessageSum = new shopMessageSum("兰湘子·湘菜小炒", R.drawable.img_10);
        shopMessageSum shopMessageSum1 = new shopMessageSum("茶话弄", R.drawable.img_12);
        shopMessageSum shopMessageSum2 = new shopMessageSum("蜜雪冰城", R.drawable.img_13);
        for (int i = 0; i < 3; i++) {
            shopMessageSumList.add(shopMessageSum);
            shopMessageSumList.add(shopMessageSum1);
            shopMessageSumList.add(shopMessageSum2);
        }
    }

    public void changeChoice(int position, Boolean choice) {
        stringList_buttonChoice.get(position).setCheckChoice(choice);
        Log.d(TAG, "我进行了刷新" + position + choice);
        try {
            homeButtonChoiceAdapter.notifyItemChanged(position);
        } catch (Exception e) {
            Log.d(TAG, e + "aa");
        }
    }
}