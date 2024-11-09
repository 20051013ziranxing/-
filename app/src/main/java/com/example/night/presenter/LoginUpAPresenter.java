package com.example.night.presenter;

import android.view.View;

import com.example.night.ActivityManage.LoginUpActivity;
import com.example.night.SQLiteHelper.AllUserBaseMessageHelper;

public class LoginUpAPresenter {
    AllUserBaseMessageHelper allUserBaseMessageHelper;
    LoginUpActivity view;

    public LoginUpAPresenter(LoginUpActivity view) {
        this.view = view;
        allUserBaseMessageHelper = new AllUserBaseMessageHelper(view, "AllUserBaseMessage", null, 1);
    }

    public void loginUp(String userNumber, String userPassword) {
        if (userNumber == null || userPassword == null) {
            view.sendTip("账号或密码不能为空");
        } else {
            String s = allUserBaseMessageHelper.queryUser(userNumber);
            if (s.equals("这个电话号码并没有注册过，你可以注册一个哦！")) {
                view.sendTip("这个电话号码并没有注册过，你可以注册一个哦！");
            } else {
                if (userPassword.equals(s)) {
                    view.success();
                } else {
                    view.sendTip("账号与密码不对应");
                }
            }
        }
    }
}
