package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum Goals {

    LOSE_WIGHT(1),
    MAINTAIN_WEIGHT(2),
    GAIN_WEIGHT(3),
    GAIN_MUSCLE(4),
    MODIFY_MY_DIET(5),
    MANAGE_STRESS(6),
    INCREASE_STEP_COUNT(7);

    private final int option;

    Goals(int option){
        this.option=option;
    }

    public int getOption() {
        return option;
    }
}
