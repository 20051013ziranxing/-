package com.example.night.fragmentManage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.night.Adapter.IntentFragmentRecyclerAdapter1;
import com.example.night.Adapter.IntentFragmentAdapter;
import com.example.night.Bean.PersonalHistory;
import com.example.night.R;
import com.example.night.fragmentManage.intent.All_intent_Fragment;
import com.example.night.fragmentManage.intent.Intent_refund_Fragment;
import com.example.night.fragmentManage.intent.Wait_evaluateFragment;
import com.example.night.presenter.PersonalHistoryPresenter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IndentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndentFragment extends Fragment {
    NestedScrollView nestedScrollView;
    LinearLayout layout;
    PersonalHistoryPresenter personalHistoryPresenter;
    PersonalHistory personalHistory;
    TabLayout tableLayout;
    ViewPager2 viewPager2;
    RecyclerView recyclerView_boughtShop;
    List<Fragment> viewPagerSubclass;
    IntentFragmentAdapter intentFragmentAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public IndentFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment indentFragment.
     */

    public static IndentFragment newInstance(String param1, String param2) {
        IndentFragment fragment = new IndentFragment();
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

        return inflater.inflate(R.layout.fragment_indent, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        personalHistoryPresenter = new PersonalHistoryPresenter(this);
        personalHistory = personalHistoryPresenter.getPersonalHistory();
        nestedScrollView = view.findViewById(R.id.intent_fragment_nestedScrollView);
        layout = view.findViewById(R.id.layoutLinear);
        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > 30) {
                    layout.setVisibility(View.VISIBLE);
                } else {
                    layout.setVisibility(View.GONE);
                }
            }
        });

        tableLayout = view.findViewById(R.id.intent_tablelayout);
        viewPager2 = view.findViewById(R.id.intent_viewpager);
        recyclerView_boughtShop = view.findViewById(R.id.intent_recyclerView1);
        IntentFragmentRecyclerAdapter1 intentFragmentRecyclerAdapter1 = new IntentFragmentRecyclerAdapter1(personalHistory);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_boughtShop.setLayoutManager(linearLayoutManager);
        recyclerView_boughtShop.setAdapter(intentFragmentRecyclerAdapter1);

        intentFragmentAdapter = new IntentFragmentAdapter(getActivity(), viewPagerSubclass);
        viewPager2.setAdapter(intentFragmentAdapter);
        new TabLayoutMediator(tableLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                if (i == 0) {
                    tab.setText("全部订单");
                } else if (i == 1) {
                    tab.setText("待评价");
                } else if (i == 2) {
                    tab.setText("退款/售后");
                } else {
                    tab.setText("加载失败");
                }
            }
        }).attach();
    }

    public void initData() {
        viewPagerSubclass = new ArrayList<>();
        All_intent_Fragment fragment1 = new All_intent_Fragment();
        Intent_refund_Fragment fragment2 = new Intent_refund_Fragment();
        Wait_evaluateFragment fragment3 = new Wait_evaluateFragment();
        viewPagerSubclass.add(fragment1);
        viewPagerSubclass.add(fragment2);
        viewPagerSubclass.add(fragment3);
    }
}