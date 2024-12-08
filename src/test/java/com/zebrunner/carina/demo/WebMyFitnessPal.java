package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.myfitnesspal.MyFitnessPalHomePageWithSession;
import com.zebrunner.carina.demo.gui.pages.myfitnesspal.MyFitnessPalLogInPage;
import com.zebrunner.carina.demo.gui.pages.myfitnesspal.MyFitnessPalSignUpPage;
import com.zebrunner.carina.demo.utils.my_fitness_pal_utils.*;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class WebMyFitnessPal implements IAbstractTest {

    @Test(description = "Validate Sign Up, create account")
    @MethodOwner(owner = "emir")
    public void validateSignUp(){
        WebDriver driver = getDriver();

        MyFitnessPalLogInPage logInPage = new MyFitnessPalLogInPage(driver);
        logInPage.open();

        MyFitnessPalSignUpPage signUpPage = logInPage.goToSignUp();

        //Check if Sign Up page was opened
        Assert.assertTrue(signUpPage.isPageOpened());

        signUpPage.clickContinue();

        //Check when click continue button redirect to enter firstname modal
        Assert.assertTrue(getDriver().getCurrentUrl().contains("input-name"));

        Goals[] goalsSelected = {Goals.GAIN_MUSCLE,Goals.MANAGE_STRESS,Goals.GAIN_WEIGHT};

        //Just one of this three
        LooseWeight[] looseWeightsOptionsSelected = {LooseWeight.DID_NOT_ENJOY_FOOD};
        MaintainWeight[] maintainWeightsOptionsSelected ={MaintainWeight.COOKING_WAS_HARD_OR_TIME_CONSUMING};
        GainWeight[] gainWeightsOptionsSelected = {GainWeight.GAIN_MUSCLE_FOR_GENERAL_FITNESS};

        GainMuscle[] gainMusclesOptionsSelected = {GainMuscle.TONE_UP};
        ModifyDiet[] modifyDietsOptionsSelected = {ModifyDiet.OTHERS};
        ManageStress[] manageStressesOptionsSelected = {ManageStress.LISTEN_MUSIC};
        IncreaseSteps[] increaseStepsOptionsSelected = {IncreaseSteps.LESS_1000};

        ActivityLevel activityLevelsOptionSelected = ActivityLevel.NOT_VERY_ACTIVE;

        WeeklyGoal weeklyGoalLooseWeightSelected = WeeklyGoal.LOSE_50KG;
        WeeklyGoal weeklyGoalGainWeightSelected = WeeklyGoal.GAIN_25KG;

        Account myAccount = new Account();
        myAccount.setFirstName(R.TESTDATA.get("account.first_name"));

        String birthday = R.TESTDATA.get("account.birthday");
        String myGoalWeight;
        String goalWeightLoosing = R.TESTDATA.get("account.goal_weight_loosing");
        String goalWeightGaining = R.TESTDATA.get("account.goal_weight_gaining");

        myAccount.setSex(Sex.MALE);
        myAccount.setBirthday(formatToBirthday(birthday));
        myAccount.setCountry(Country.United_States);
        myAccount.setZipCode(R.TESTDATA.get("account.zipcode"));
        myAccount.setHeightFeet(R.TESTDATA.get("account.height_feet"));
        myAccount.setHeightInches(R.TESTDATA.get("account.height_inches"));
        myAccount.setCurrentWeightLbs(R.TESTDATA.get("account.current_weight"));
        myAccount.setUserName(R.TESTDATA.get("account.user_name"));
        myAccount.setEmail(R.TESTDATA.get("account.email"));
        myAccount.setPassword(R.TESTDATA.get("account.password"));

        signUpPage.enterName(myAccount.getFirstName());
        signUpPage.clickNextFromName();

        signUpPage.selectGoalOption(goalsSelected);

        if(goalsSelected.length!=3){
            signUpPage.clickNextFromGoals();
        }

        signUpPage.clickNextBigStep();

        Arrays.stream(goalsSelected).forEach(goal->{
            switch (goal){
                case LOSE_WIGHT:
                    signUpPage.selectLoseWeightOption(looseWeightsOptionsSelected);
                    if(looseWeightsOptionsSelected.length<LooseWeight.values().length){
                        signUpPage.selectNextFromLoseWeight();
                    }
                    break;
                case MAINTAIN_WEIGHT:
                    signUpPage.selectMaintainWeightOption(maintainWeightsOptionsSelected);
                    if(maintainWeightsOptionsSelected.length<MaintainWeight.values().length){
                        signUpPage.selectNextFromMaintainWeight();
                    }
                    break;
                case GAIN_WEIGHT:
                    signUpPage.selectGainWeightOptionOption(gainWeightsOptionsSelected);
                    if(gainWeightsOptionsSelected.length<GainWeight.values().length){
                        signUpPage.clickNextFromGainWeight();
                    }
                    break;
                case GAIN_MUSCLE:
                    signUpPage.selectGainMuscleOption(gainMusclesOptionsSelected);
                    if(gainMusclesOptionsSelected.length<GainMuscle.values().length){
                        signUpPage.selectNextFromGainMuscle();
                    }
                    break;
                case MODIFY_MY_DIET:
                    signUpPage.selectModifyDietOption(modifyDietsOptionsSelected);
                    if(modifyDietsOptionsSelected.length<ModifyDiet.values().length){
                        signUpPage.selectNextFromModifyDiet();
                    }
                    break;
                case MANAGE_STRESS:
                    signUpPage.selectManageStressOptions(manageStressesOptionsSelected);
                    if(manageStressesOptionsSelected.length<ManageStress.values().length){
                        signUpPage.selectNextFromManageStress();
                    }
                    break;
                case INCREASE_STEP_COUNT:
                    signUpPage.selectIncreaseStepCountOptions(increaseStepsOptionsSelected);
                    break;
            }
            signUpPage.clickGeneralNext();
        });

        signUpPage.selectActivityLevelOption(activityLevelsOptionSelected);
        signUpPage.clickNextFromActivityLevel();

        signUpPage.selectSex(myAccount.getSex());

        signUpPage.chooseBirthday(birthday);
        myAccount.setBirthday(signUpPage.getBirthday());

        signUpPage.selectCountry(myAccount.getCountry());

        if(myAccount.getCountry().equals(Country.United_States)){
            signUpPage.enterZipCode(myAccount.getZipCode());
        }

        signUpPage.clickNextFromDemographic();

        signUpPage.enterHeightFeet(myAccount.getHeightFeet());
        signUpPage.enterHeightInches(myAccount.getHeightInches());

        if(goalsSelected[0].equals(Goals.LOSE_WIGHT)){
            myGoalWeight= goalWeightLoosing;
        }else{
            myGoalWeight = goalWeightGaining;
        }

        myAccount.setMyGoalWeight(myGoalWeight);

        signUpPage.enterWeight(myAccount.getCurrentWeightLbs());
        signUpPage.enterGoalWeight(myAccount.getMyGoalWeight());

        signUpPage.clickNextFromDemographic2();

        if(Arrays.asList(goalsSelected).contains(Goals.LOSE_WIGHT)){
            signUpPage.selectWeeklyGoalOption(weeklyGoalLooseWeightSelected);
            signUpPage.clickNextWeeklyGoal();
        }else if(Arrays.asList(goalsSelected).contains(Goals.GAIN_WEIGHT)){
            signUpPage.selectWeeklyGoalOption(weeklyGoalGainWeightSelected);
            signUpPage.clickNextWeeklyGoal();
        }

        signUpPage.enterEmail(myAccount.getEmail());
        signUpPage.enterPassword(myAccount.getPassword());
        signUpPage.checkTermsAndConditions();
        signUpPage.clickContinueFromCreate();

        signUpPage.enterUserName(myAccount.getUserName());
        signUpPage.clickNextFromUserName();

        signUpPage.acceptConsents();
        signUpPage.clickFinish();

        //Checks if congratulations message showed
        Assert.assertEquals(signUpPage.getCongratulationsMessage(),"Congratulations!","Could not get congratulations message");

        signUpPage.clickNewsCheckBox();
        MyFitnessPalHomePageWithSession homePageWithSession = signUpPage.goToMyFitnessPal();

        //Check if home page username is equals to the account username created
        Assert.assertEquals(homePageWithSession.getUserName(),myAccount.getUserName(),"User name from home page and account created are not equals");
    }

    public static String formatToBirthday(String birthday) {
        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMddyyyy");
            LocalDate date = LocalDate.parse(birthday, inputFormatter);

            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            return date.format(outputFormatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Wrong format 'ddMMyyyy'.", e);
        }
    }


    @Test(description = "Validate Food nutrients info")
    @MethodOwner(owner = "emir")
    public void validateFoodNutrients(){
        WebDriver driver = getDriver();

        User user = new User();
        user.setEmail(R.TESTDATA.get("account_email"));
        user.setPassword(R.TESTDATA.get("account_password"));

        MyFitnessPalLogInPage logInPage = new MyFitnessPalLogInPage(driver);
        logInPage.open();
        MyFitnessPalHomePageWithSession homePageWithSession = logInPage.logIn(user.getEmail(),user.getPassword());
        user.setUserName(homePageWithSession.getUserName());

    }
}
