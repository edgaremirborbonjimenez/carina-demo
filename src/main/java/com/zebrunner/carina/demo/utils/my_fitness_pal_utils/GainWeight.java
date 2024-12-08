package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum GainWeight {
    COMPETITIVE_SPORT_PERFORMANCE(1),
    GAIN_MUSCLE_FOR_GENERAL_FITNESS(2),
    I_AM_UNDERWEIGHT(3),
    HEALTHCARE_PROVIDER_RECOMMENDED(4),
    OTHER(5);

    private final int option;

    GainWeight(int option){
        this.option=option;
    }

    public int getOption() {
        return option;
    }
}
