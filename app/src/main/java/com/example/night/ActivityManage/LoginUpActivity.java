package com.example.night.ActivityManage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.night.R;
import com.example.night.ActivityManage.RegistrationActivity;
import com.example.night.SQLiteHelper.AllUserBaseMessageHelper;
import com.example.night.base.BaseView;
import com.example.night.presenter.LoginUpAPresenter;
import com.example.night.presenter.RegistrationAPresenter;

public class LoginUpActivity extends AppCompatActivity implements BaseView {

    Toolbar toolbar;
    Button buttonLoginUp;
    Button buttonRegistration;
    LoginUpAPresenter loginUpAPresenter;
    EditText editTextUserNumber;
    EditText editTextUserPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginUpAPresenter = new LoginUpAPresenter(this);

        editTextUserNumber = findViewById(R.id.login_up_number);
        editTextUserPassword = findViewById(R.id.login_up_password);

        buttonLoginUp = findViewById(R.id.button_loginUp);
        buttonLoginUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUpAPresenter.loginUp(editTextUserNumber.getText().toString(), editTextUserPassword.getText().toString());
                /*Intent intent = new Intent(LoginUpActivity.this, MainActivity.class);
                startActivity(intent);*/
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar_login_up);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        buttonRegistration = findViewById(R.id.login_up_registration);
        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginUpActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    //将目录放置进去
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login_up_1, menu);
        return true;
    }


    @Override
    public void setPresenter(Object present) {
        loginUpAPresenter = (LoginUpAPresenter) present;
    }
    @Override
    public void sendTip(String tip) {
        Toast.makeText(LoginUpActivity.this, tip, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success() {
        Intent intent = new Intent(LoginUpActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void failed() {

    }
}