package com.example.night.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ShopSelectVIewPager2Adapter extends FragmentStateAdapter {
    List<Fragment> fragments;
    public ShopSelectVIewPager2Adapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments == null ? null : fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
