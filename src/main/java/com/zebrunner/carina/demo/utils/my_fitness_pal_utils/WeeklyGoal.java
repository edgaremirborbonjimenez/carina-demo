package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum WeeklyGoal {
    GAIN_25KG(1),
    GAIN_50KG(2),
    LOSE_25KG(1),
    LOSE_50KG(2),
    LOSE_75KG(3),
    LOSE_100KG(4);
    private final int option;

    WeeklyGoal(int option){
        this.option=option;
    }

    public int getOption() {
        return option;
    }
}
