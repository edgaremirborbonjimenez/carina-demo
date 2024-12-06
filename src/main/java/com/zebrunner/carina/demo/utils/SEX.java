package com.zebrunner.carina.demo.utils;

public enum SEX {
    FEMALE("F"),MALE("M");

    private final String sex;

    SEX(String sex){
        this.sex = sex;
    }

    public String getSex(){
        return sex;
    }
}
