package com.example.night.presenter;

import android.util.Log;
import android.view.View;

import com.example.night.ActivityManage.RegistrationActivity;
import com.example.night.R;
import com.example.night.SQLiteHelper.AllUserBaseMessageHelper;

public class RegistrationAPresenter {
    final static String TAG = "nightText";
    RegistrationActivity view;
    AllUserBaseMessageHelper allUserBaseMessageHelper;
    public RegistrationAPresenter(RegistrationActivity view) {
        this.view = view;
        allUserBaseMessageHelper = new AllUserBaseMessageHelper(view, "AllUserBaseMessage", null, 1);
    }
    public void registration(String userNumber, String userPassword, String userName) {
        if (userName.isEmpty() || userNumber.isEmpty() || userPassword.isEmpty()) {
            view.sendTip("所填内容不能为空");
        } else {
            Log.d(TAG,"我打算添加了" + userName + userNumber + userPassword);
            boolean success = allUserBaseMessageHelper.insertUser(userName, userNumber, userPassword, String.valueOf(R.drawable.draw4));
            if (success) {
                Log.d(TAG,"我打算添加了并成功了");
                view.success();
            } else {
                Log.d(TAG,"我打算添加了但失败了");
                view.failed();
            }
        }
    }
}
