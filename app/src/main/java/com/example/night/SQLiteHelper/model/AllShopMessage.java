package com.example.night.SQLiteHelper.model;

import com.example.night.Bean.ShopMessageSum;
import com.example.night.R;

import java.util.ArrayList;
import java.util.List;

public class AllShopMessage {
    List<ShopMessageSum> shopMessageSumList;

    public AllShopMessage() {
        shopMessageSumList = new ArrayList<>();
        ShopMessageSum shopMessageSum = new ShopMessageSum("兰湘子·湘菜小炒", R.drawable.img_10);
        ShopMessageSum shopMessageSum1 = new ShopMessageSum("茶话弄", R.drawable.img_12);
        ShopMessageSum shopMessageSum2 = new ShopMessageSum("蜜雪冰城", R.drawable.img_13);
        for (int i = 0; i < 7; i++) {
            shopMessageSumList.add(shopMessageSum);
            shopMessageSumList.add(shopMessageSum1);
            shopMessageSumList.add(shopMessageSum2);
        }
    }
    public List<ShopMessageSum> getShopMessageSumList() {
        return shopMessageSumList;
    }
}
