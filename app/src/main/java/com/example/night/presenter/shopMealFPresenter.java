package com.example.night.presenter;

import android.util.Log;

import com.example.night.Bean.ShopMessage1;
import com.example.night.SQLiteHelper.model.shopMessageModel;
import com.example.night.fragmentManage.shop.ShopMealFragment;

public class shopMealFPresenter {
    final static String TAG = "nightaaa";
    ShopMealFragment shopMealFragment;
    shopMessageModel shopMessageModel;

    public shopMealFPresenter(ShopMealFragment shopMealFragment) {
        this.shopMealFragment = shopMealFragment;
        this.shopMessageModel = new shopMessageModel();
    }
    public ShopMessage1 getShopMessage1() {
        ShopMessage1 shopMessage1 = shopMessageModel.getShopMessage1();
        if (shopMessage1 != null) {
            Log.d(TAG, "我成功获取到了数据");
        } else {
            Log.d(TAG, "好吧，我承认我失败了，我没有获取到数据");
        }
        return shopMessage1;
    }
}
