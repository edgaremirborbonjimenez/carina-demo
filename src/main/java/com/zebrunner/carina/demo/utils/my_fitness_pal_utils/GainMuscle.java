package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum GainMuscle {
    TONE_UP(1),
    BULK_UP(2),
    GET_STRONG(3);

    private final int option;

    GainMuscle(int option){
        this.option=option;
    }

    public int getOption() {
        return option;
    }
}
