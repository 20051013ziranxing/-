package com.example.night.Bean;

public class shopMessageSum {
    private String name;
    private int ImageID;

    public shopMessageSum(String name, int imageID) {
        this.name = name;
        ImageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }
}
