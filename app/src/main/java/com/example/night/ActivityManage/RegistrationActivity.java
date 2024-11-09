package com.example.night.ActivityManage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.night.R;
import com.example.night.base.BaseView;
import com.example.night.presenter.RegistrationAPresenter;

public class RegistrationActivity extends AppCompatActivity implements BaseView {

    RegistrationAPresenter registrationAPresenter;
    final static String TAG = "nightText";
    Toolbar toolbar;
    Button button;
    EditText editTextName;
    EditText editTextNumber;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        registrationAPresenter = new RegistrationAPresenter(this);

        editTextName = findViewById(R.id.registration_userName);
        editTextNumber = findViewById(R.id.registration_number);
        editTextPassword = findViewById(R.id.registration_password);

        toolbar = findViewById(R.id.toolbar_registration);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //注册按钮的点击事件
        button = findViewById(R.id.button_registration);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "我执行到了点击事件");
                Log.d(TAG, "hh" + editTextNumber.getText().toString());
                registrationAPresenter.registration(editTextNumber.getText().toString(), editTextPassword.getText().toString(),
                        editTextName.getText().toString());
                Log.d(TAG, "我执行到了调转活动啊");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "我执行到了调转活动啊");
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, LoginUpActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPresenter(Object present) {
        registrationAPresenter = (RegistrationAPresenter) present;
    }

    public void sendTip(String  tip) {
        Log.d(TAG, tip);
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success() {
        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void failed() {
        Toast.makeText(this, "注册失败,你可能已经有帐号了，一个电话号码只能注册一次", Toast.LENGTH_SHORT).show();
    }
}