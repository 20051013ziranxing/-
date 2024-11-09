package com.example.night.ActivityManage;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.night.R;
import com.example.night.fragmentManage.homeFragment;
import com.example.night.fragmentManage.indentFragment;
import com.example.night.fragmentManage.memberFragment;
import com.example.night.fragmentManage.myFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        bottomNavigationView = findViewById(R.id.bottom_main);
        fragmentManager = getSupportFragmentManager();
        replaceFragment(new homeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.menu_main_home) {
                    replaceFragment(new homeFragment());
                } else if (menuItem.getItemId() == R.id.menu_main_member) {
                    replaceFragment(new memberFragment());
                } else if (menuItem.getItemId() == R.id.menu_main_indent) {
                    replaceFragment(new indentFragment());
                } else {
                    replaceFragment(new myFragment());
                }
                return true;
            }
        });
    }
    private void replaceFragment (Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_main, fragment);
        transaction.commit();
    }
}