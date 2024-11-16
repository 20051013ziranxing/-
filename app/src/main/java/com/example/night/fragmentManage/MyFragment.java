package com.example.night.fragmentManage;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.night.Adapter.MyFragmentRecyclerViewAdapter;
import com.example.night.Bean.ShopMessageSum;
import com.example.night.R;
import com.example.night.presenter.MyFragmentPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFragment extends Fragment {
    RecyclerView recyclerView;
    NestedScrollView nestedScrollView;
    Toolbar toolbar;
    MyFragmentPresenter myFragmentPresenter;
    FloatingActionButton floatingActionButton;
    List<ShopMessageSum> shopMessageSumList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public MyFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment myFragment.
     */
    public static MyFragment newInstance(String param1, String param2) {
        MyFragment fragment = new MyFragment();
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
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        myFragmentPresenter = new MyFragmentPresenter(this);
        toolbar = view.findViewById(R.id.myFragment_toolbar);
        recyclerView = view.findViewById(R.id.myFragment_recyclerView);
        nestedScrollView = view.findViewById(R.id.myFragment_nestedScrollView);
        floatingActionButton = view.findViewById(R.id.myFragment_floatingActionButton);
        initdata();
        MyFragmentRecyclerViewAdapter myFragmentRecyclerViewAdapter = new MyFragmentRecyclerViewAdapter(shopMessageSumList);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myFragmentRecyclerViewAdapter);
        return view;
    }
    public void initdata() {
        shopMessageSumList = myFragmentPresenter.getShopMessageSum();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nestedScrollView.smoothScrollTo(0,0);
            }
        });
        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > 70) {
                    floatingActionButton.setVisibility(View.VISIBLE);
                    toolbar.setVisibility(View.VISIBLE);
                } else {
                    floatingActionButton.setVisibility(View.GONE);
                    toolbar.setVisibility(View.GONE);
                }
            }
        });
    }
}