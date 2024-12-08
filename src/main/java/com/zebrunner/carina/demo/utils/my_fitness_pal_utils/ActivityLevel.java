package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum ActivityLevel {
    NOT_VERY_ACTIVE(1),
    LIGHTLY_ACTIVE(2),
    ACTIVE(3),
    VERY_ACTIVE(4);
    private final int option;

    ActivityLevel(int option){
        this.option=option;
    }

    public int getOption() {
        return option;
    }
}
