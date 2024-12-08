package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum IncreaseSteps {
    LESS_1000(1),
    ONE_THOUSAND_TO_THREE_THOUSAND(2),
    THREE_THOUSAND_TO_SEVEN_THOUSAND(3),
    MORE_SEVEN_THOUSAND(4),
    I_DONT_KNOW(5);

    private final int option;

    IncreaseSteps(int option){
        this.option=option;
    }

    public int getOption() {
        return option;
    }
}
