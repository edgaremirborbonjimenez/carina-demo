package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum ModifyDiet {
    TRACK_MACROS(1),
    EAT_VEGAN(2),
    EAT_VEGETARIAN(3),
    EAT_PESCATARIAN(4),
    LESS_SUGAR(5),
    LESS_PROTEIN(6),
    LESS_DAIRY(7),
    FEWER_CARBS(8),
    LESS_FAT(9),
    MORE_PROTEIN(10),
    MORE_FAT(11),
    MORE_FRUIT_AND_VEGETABLES(12),
    OTHERS(13);

    private final int option;

    ModifyDiet(int option){
        this.option=option;
    }

    public int getOption() {
        return option;
    }
}
