package com.example.night.SQLiteHelper.model;

import com.example.night.Bean.PersonalHistory;
import com.example.night.R;

import java.util.ArrayList;
import java.util.List;

public class PersonalHistoryModel {
    PersonalHistory personalHistory;
    public PersonalHistoryModel() {
        List<PersonalHistory.BoughtThing> boughtThingList;
        boughtThingList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            PersonalHistory.BoughtThing boughtThing = new PersonalHistory.BoughtThing("辣椒炒肉", R.drawable.img_31);
            boughtThingList.add(boughtThing);
        }
        List<PersonalHistory.BoughtSomething> boughtSomethingList;
        boughtSomethingList = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            PersonalHistory.BoughtSomething boughtSomething = new PersonalHistory.BoughtSomething("兰湘子·湘菜小炒", R.drawable.img_10,
                    "80", boughtThingList);
            boughtSomethingList.add(boughtSomething);
        }

        List<PersonalHistory.BoughtShop> boughtShopList;
        boughtShopList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            PersonalHistory.BoughtShop boughtShop = new PersonalHistory.BoughtShop("兰湘子·湘菜小炒", R.drawable.img_10, 3);
            boughtShopList.add(boughtShop);
        }
        personalHistory = new PersonalHistory("睡到自然醒", "123456", "15353953771", boughtShopList, boughtSomethingList);
    }

    public PersonalHistory getPersonalHistory() {
        return personalHistory;
    }

    public void setPersonalHistory(PersonalHistory personalHistory) {
        this.personalHistory = personalHistory;
    }
}
