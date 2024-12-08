package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum LooseWeight {
    LACK_OF_TIME(1),
    HARD_REGIMEN(2),
    DID_NOT_ENJOY_FOOD(3),
    DIFFICULT_MAKE_FOOD_CHOICE(4),
    SOCIAL_EATING_AND_EVENTS(5),
    FOOD_CRAVING(6),
    LACK_OF_PROGRESS(7);

    private final int option;

    LooseWeight(int option){
        this.option=option;
    }

    public int getOption() {
        return option;
    }
}
