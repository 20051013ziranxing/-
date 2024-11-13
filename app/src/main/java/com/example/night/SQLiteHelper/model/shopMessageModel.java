package com.example.night.SQLiteHelper.model;

import com.example.night.Bean.ShopMessage1;
import com.example.night.R;

import java.util.ArrayList;
import java.util.List;

public class shopMessageModel {
    ShopMessage1 shopMessage1;
    public shopMessageModel() {
        List<ShopMessage1.AllMeal> allMealList;
        allMealList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ShopMessage1.AllMeal allMeal = new ShopMessage1.AllMeal("西红柿炒鸡蛋", R.drawable.img_31, "18");
            ShopMessage1.AllMeal allMeal1 = new ShopMessage1.AllMeal("招牌辣椒炒肉", R.drawable.img_34, "49.8");
            ShopMessage1.AllMeal allMeal2 = new ShopMessage1.AllMeal("豉油生菜", R.drawable.img_34, "26.8");
            ShopMessage1.AllMeal allMeal3 = new ShopMessage1.AllMeal("蔓越莓甜糕", R.drawable.img_34, "9.9");
            ShopMessage1.AllMeal allMeal4 = new ShopMessage1.AllMeal("米饭", R.drawable.img_34, "3");
            ShopMessage1.AllMeal allMeal5 = new ShopMessage1.AllMeal("一品鲜虾豆花", R.drawable.img_34, "35.8");
            ShopMessage1.AllMeal allMeal6 = new ShopMessage1.AllMeal("糖醋里脊", R.drawable.img_34, "33.8");
            allMealList.add(allMeal);
            allMealList.add(allMeal1);
            allMealList.add(allMeal2);
            allMealList.add(allMeal3);
            allMealList.add(allMeal4);
            allMealList.add(allMeal5);
            allMealList.add(allMeal6);
        }
        List<ShopMessage1.SpeciesMeal> speciesMeals;
        speciesMeals = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ShopMessage1.SpeciesMeal speciesMeal = new ShopMessage1.SpeciesMeal("招牌推荐" + i, allMealList);
            ShopMessage1.SpeciesMeal speciesMeal1 = new ShopMessage1.SpeciesMeal("家常炒菜" + i, allMealList);
            ShopMessage1.SpeciesMeal speciesMeal2 = new ShopMessage1.SpeciesMeal("小吃主食" + i, allMealList);
            speciesMeals.add(speciesMeal);
            speciesMeals.add(speciesMeal1);
            speciesMeals.add(speciesMeal2);
        }
        shopMessage1 = new ShopMessage1("兰湘子·湘菜小炒", speciesMeals);
    }

    public ShopMessage1 getShopMessage1() {
        return shopMessage1;
    }

    public void setShopMessage1(ShopMessage1 shopMessage1) {
        this.shopMessage1 = shopMessage1;
    }
}
