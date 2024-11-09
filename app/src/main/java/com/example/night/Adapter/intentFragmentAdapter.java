package com.example.night.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.night.fragmentManage.indentFragment;

import java.util.List;

public class intentFragmentAdapter extends FragmentStateAdapter {
    List<Fragment> mfragmentList;

    public intentFragmentAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
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
