package com.example.night.presenter;

import com.example.night.Bean.shopMessageSum;
import com.example.night.SQLiteHelper.model.AllShopMessage;
import com.example.night.fragmentManage.myFragment;

import java.util.List;

public class MyFragmentPresenter {
    myFragment myFragment;
    AllShopMessage allShopMessage;

    public MyFragmentPresenter(com.example.night.fragmentManage.myFragment myFragment) {
        this.myFragment = myFragment;
        allShopMessage = new AllShopMessage();
    }
    public List<shopMessageSum> getShopMessageSum() {
        List<shopMessageSum> list = allShopMessage.getShopMessageSumList();
        return list;
    }
}
