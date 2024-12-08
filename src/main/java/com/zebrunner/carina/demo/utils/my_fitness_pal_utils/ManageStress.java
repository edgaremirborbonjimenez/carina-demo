package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum ManageStress {
    WALK(1),
    RUN(2),
    STRENGTH_WORKOUT(3),
    BIKE_RIDE(4),
    YOGA_OR_FITNESS_CLASS(5),
    STRETCH(6),
    WATCH_READ_LISTEN_MOTIVATIONAL(7),
    MEDICATE_PRACTICE_MINDFULNESS(8),
    LISTEN_MUSIC(9),
    DO_SOMETHING_ELSE(10),
    NOTHING_HELPS_ME(11);

    private final int option;

    ManageStress(int option){
        this.option=option;
    }

    public int getOption() {
        return option;
    }
}
