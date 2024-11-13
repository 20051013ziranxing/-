package com.example.night.Bean;

import java.util.List;

public class ShopMessage1 {
    String ShopName;
    List<SpeciesMeal> speciesMeal;

    public ShopMessage1(String shopName, List<SpeciesMeal> speciesMeal) {
        ShopName = shopName;
        this.speciesMeal = speciesMeal;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public List<SpeciesMeal> getSpeciesMeal() {
        return speciesMeal;
    }

    public void setSpeciesMeal(List<SpeciesMeal> speciesMeal) {
        this.speciesMeal = speciesMeal;
    }

    public static class SpeciesMeal {
        String kindName;
        List<AllMeal> allMealList;

        public SpeciesMeal(String kindName, List<AllMeal> allMealList) {
            this.kindName = kindName;
            this.allMealList = allMealList;
        }

        public String getKindName() {
            return kindName;
        }

        public void setKindName(String kindName) {
            this.kindName = kindName;
        }

        public List<AllMeal> getAllMealList() {
            return allMealList;
        }

        public void setAllMealList(List<AllMeal> allMealList) {
            this.allMealList = allMealList;
        }
    }
    public static class AllMeal {
        String MealName;
        int MealPicture;
        String MealPrice;

        public AllMeal(String mealName, int mealPicture, String mealPrice) {
            MealName = mealName;
            MealPicture = mealPicture;
            MealPrice = mealPrice;
        }

        public String getMealName() {
            return MealName;
        }

        public void setMealName(String mealName) {
            MealName = mealName;
        }

        public int getMealPicture() {
            return MealPicture;
        }

        public void setMealPicture(int mealPicture) {
            MealPicture = mealPicture;
        }

        public String getMealPrice() {
            return MealPrice;
        }

        public void setMealPrice(String mealPrice) {
            MealPrice = mealPrice;
        }
    }
}
