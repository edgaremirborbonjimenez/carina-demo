package com.zebrunner.carina.demo.utils.my_fitness_pal_utils;

public class Account {
//    private Goals[] myGoalsSelected;
//    private LooseWeight looseWeightOptionsSelected;
//    MaintainWeight[] maintainWeightsOptionsSelected;
//    GainWeight[] gainWeightsOptionsSelected;
//    GainMuscle[] gainMusclesOptionsSelected;
//    ModifyDiet[] modifyDietsOptionsSelected;
//    ManageStress[] manageStressesOptionsSelected;
//    IncreaseSteps[] increaseStepsOptionsSelected;
//    ActivityLevel activityLevelsOptionSelected;
//    WeeklyGoal weeklyGoalLooseWeightSelected;
//    WeeklyGoal weeklyGoalGainWeightSelected;
    String email;
    String password;
    String firstName;
    Sex sex;
    String birthday;
    Country country;
    String zipCode;
    String heightFeet;
    String heightInches;
    String currentWeightLbs;
    String myGoalWeight;
    String userName;

    public Account(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(String heightFeet) {
        this.heightFeet = heightFeet;
    }

    public String getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(String heightInches) {
        this.heightInches = heightInches;
    }

    public String getCurrentWeightLbs() {
        return currentWeightLbs;
    }

    public void setCurrentWeightLbs(String currentWeightLbs) {
        this.currentWeightLbs = currentWeightLbs;
    }

    public String getMyGoalWeight() {
        return myGoalWeight;
    }

    public void setMyGoalWeight(String myGoalWeight) {
        this.myGoalWeight = myGoalWeight;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
