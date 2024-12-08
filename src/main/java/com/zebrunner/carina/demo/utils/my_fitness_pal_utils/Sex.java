package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public enum Sex {
    FEMALE("F"),MALE("M");

    private final String sex;

    Sex(String sex){
        this.sex = sex;
    }

    public String getSex(){
        return sex;
    }
}
