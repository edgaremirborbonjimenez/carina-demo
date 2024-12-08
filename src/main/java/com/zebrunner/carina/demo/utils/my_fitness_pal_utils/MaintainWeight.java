package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum MaintainWeight {
    LACK_OF_TIME(1),
    HARD_REGIMEN(2),
    LACK_VARIETY(3),
    STRESS_FOOD_CHOICE(4),
    HOLIDAYS_VACATION_SOCIAL_EVENTS(5),
    FOOD_CRAVING(6),
    LACK_OF_PROGRESS(7),
    HEALTHY_FOOD_DOESNT_TASTE_GOOD(8),
    HEALTHY_FOOD_IS_EXPENSIVE(9),
    COOKING_WAS_HARD_OR_TIME_CONSUMING(10),
    I_DIDNT_EXPERIENCE_BARRIERS(11);

    private final int option;

    MaintainWeight(int option){
        this.option=option;
    }

    public int getOption() {
        return option;
    }
}
