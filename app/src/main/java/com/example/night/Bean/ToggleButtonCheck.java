package com.example.night.Bean;

public class ToggleButtonCheck {
    String name;
    Boolean CheckChoice;

    public ToggleButtonCheck(String name, Boolean checkChoice) {
        this.name = name;
        CheckChoice = checkChoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCheckChoice() {
        return CheckChoice;
    }

    public void setCheckChoice(Boolean checkChoice) {
        CheckChoice = checkChoice;
    }
}
