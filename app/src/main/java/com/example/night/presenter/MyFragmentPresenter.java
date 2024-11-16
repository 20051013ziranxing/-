package com.example.night.presenter;

import com.example.night.Bean.ShopMessageSum;
import com.example.night.SQLiteHelper.model.AllShopMessage;
import com.example.night.fragmentManage.MyFragment;

import java.util.List;

public class MyFragmentPresenter {
    MyFragment myFragment;
    AllShopMessage allShopMessage;

    public MyFragmentPresenter(MyFragment myFragment) {
        this.myFragment = myFragment;
        allShopMessage = new AllShopMessage();
    }
    public List<ShopMessageSum> getShopMessageSum() {
        List<ShopMessageSum> list = allShopMessage.getShopMessageSumList();
        return list;
    }
}
