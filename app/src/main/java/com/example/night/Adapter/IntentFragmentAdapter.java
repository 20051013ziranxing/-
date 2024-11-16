package com.example.night.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class IntentFragmentAdapter extends FragmentStateAdapter {
    List<Fragment> mfragmentList;

    public IntentFragmentAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        this.mfragmentList = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mfragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return mfragmentList.size();
    }
}
