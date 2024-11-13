package com.example.night.Bean;

import java.util.List;

public class PersonalHistory {
    String personalName;
    String personalPassword;
    String personalNumber;
    List<BoughtShop> boughtShopList;
    List<BoughtSomething> boughtSomethingList;

    public PersonalHistory(String personalName, String personalPassword, String personalNumber,
                           List<BoughtShop> boughtShopList, List<BoughtSomething> boughtSomethingList) {
        this.personalName = personalName;
        this.personalPassword = personalPassword;
        this.personalNumber = personalNumber;
        this.boughtShopList = boughtShopList;
        this.boughtSomethingList = boughtSomethingList;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getPersonalPassword() {
        return personalPassword;
    }

    public void setPersonalPassword(String personalPassword) {
        this.personalPassword = personalPassword;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public List<BoughtShop> getBoughtShopList() {
        return boughtShopList;
    }

    public void setBoughtShopList(List<BoughtShop> boughtShopList) {
        this.boughtShopList = boughtShopList;
    }

    public List<BoughtSomething> getBoughtSomethingList() {
        return boughtSomethingList;
    }

    public void setBoughtSomethingList(List<BoughtSomething> boughtSomethingList) {
        this.boughtSomethingList = boughtSomethingList;
    }

    public static class BoughtShop {
        String shopName;
        int shopPicture;
        int boughtCount;

        public BoughtShop(String shopName, int shopPicture, int boughtCount) {
            this.shopName = shopName;
            this.shopPicture = shopPicture;
            this.boughtCount = boughtCount;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public int getShopPicture() {
            return shopPicture;
        }

        public void setShopPicture(int shopPicture) {
            this.shopPicture = shopPicture;
        }

        public String getBoughtCount() {
            return String.valueOf(boughtCount);
        }

        public void setBoughtCount(int boughtCount) {
            this.boughtCount = boughtCount;
        }
    }

    public static class BoughtSomething {
        String shopName;
        int shopPicture;
        String totalCost;
        List<BoughtThing> boughtThingList;

        public BoughtSomething(String shopName, int shopPicture, String totalCost, List<BoughtThing> boughtThingList) {
            this.shopName = shopName;
            this.shopPicture = shopPicture;
            this.totalCost = totalCost;
            this.boughtThingList = boughtThingList;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public int getShopPicture() {
            return shopPicture;
        }

        public void setShopPicture(int shopPicture) {
            this.shopPicture = shopPicture;
        }

        public String getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(String totalCost) {
            this.totalCost = totalCost;
        }

        public List<BoughtThing> getBoughtThingList() {
            return boughtThingList;
        }

        public void setBoughtThingList(List<BoughtThing> boughtThingList) {
            this.boughtThingList = boughtThingList;
        }
    }

    public static class BoughtThing {
        String thingName;
        int thingPicture;

        public BoughtThing(String thingName, int thingPicture) {
            this.thingName = thingName;
            this.thingPicture = thingPicture;
        }

        public String getThingName() {
            return thingName;
        }

        public void setThingName(String thingName) {
            this.thingName = thingName;
        }

        public int getThingPicture() {
            return thingPicture;
        }

        public void setThingPicture(int thingPicture) {
            this.thingPicture = thingPicture;
        }
    }
}
