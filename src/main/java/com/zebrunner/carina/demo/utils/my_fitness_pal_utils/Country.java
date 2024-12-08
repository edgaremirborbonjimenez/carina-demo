package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum Country {
    MEXICO("Mexico"),
    United_States("United States");
    private final String option;

    Country(String option){
        this.option=option;
    }

    public String getOption() {
        return option;
    }
}
