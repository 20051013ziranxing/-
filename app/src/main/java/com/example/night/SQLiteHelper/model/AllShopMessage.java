package com.example.night.SQLiteHelper.model;

import com.example.night.Bean.shopMessageSum;
import com.example.night.R;

import java.util.ArrayList;
import java.util.List;

public class AllShopMessage {
    List<shopMessageSum> shopMessageSumList;

    public AllShopMessage() {
        shopMessageSumList = new ArrayList<>();
        shopMessageSum shopMessageSum = new shopMessageSum("兰湘子·湘菜小炒", R.drawable.img_10);
        shopMessageSum shopMessageSum1 = new shopMessageSum("茶话弄", R.drawable.img_12);
        shopMessageSum shopMessageSum2 = new shopMessageSum("蜜雪冰城", R.drawable.img_13);
        for (int i = 0; i < 7; i++) {
            shopMessageSumList.add(shopMessageSum);
            shopMessageSumList.add(shopMessageSum1);
            shopMessageSumList.add(shopMessageSum2);
        }
    }
    public List<shopMessageSum> getShopMessageSumList() {
        return shopMessageSumList;
    }
}
