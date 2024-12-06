package com.zebrunner.carina.demo.gui.pages.myfitnesspal;

import com.zebrunner.carina.demo.gui.pages.myfitnesspal.components.*;
import com.zebrunner.carina.demo.utils.SEX;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyFitnessPalSignUpPage extends MyFitnessPalBasePage {

    @FindBy(xpath = "//button")
    ExtendedWebElement continueBtn;

    @FindBy(xpath = "//form")
    ExtendedWebElement form;

    @Context(dependsOn = "form")
    InputNameModal nameModal;

    @Context(dependsOn = "form")
    GoalsModal goalsModal;

    @FindBy(xpath = "//button")
    ExtendedWebElement generalNext;

    @Context(dependsOn = "form")
    GainWeightModal gainWeightModal;

    @Context(dependsOn = "form")
    ActivityLevelModal activityLevelModal;

    @Context(dependsOn = "form")
    DemographicModal demographicModal;

    @Context(dependsOn = "form")
    Demographic2Modal demographic2Modal;

    @Context(dependsOn = "form")
    WeeklyGoalModal weeklyGoalModal;

    @Context(dependsOn = "form")
    CreateModal createModal;

    @Context(dependsOn = "form")
    UserNameModal userNameModal;

    public MyFitnessPalSignUpPage(WebDriver driver){
        super(driver);
        setUiLoadedMarker(continueBtn);
    }

    public void clickContinue(){
        continueBtn.click();
    }

    public void enterName(String name){
        PageFactory.initElements(getDriver(),this);
        nameModal.enterName(name);
    }

    public void clickNextFromName(){
        PageFactory.initElements(getDriver(),this);
        nameModal.clickNext();
    }

    public void selectGoalOption(int option){
        PageFactory.initElements(getDriver(),this);
        goalsModal.selectOption(option);
    }

    public void clickNextFromGoals(){
        PageFactory.initElements(getDriver(),this);
        goalsModal.clickNext();
    }

    public void clickGeneralNext(){
        PageFactory.initElements(getDriver(),this);
        generalNext.click();
    }

    public void selectGainWeightOption(int option){
        PageFactory.initElements(getDriver(),this);
        gainWeightModal.selectOption(option);
    }

    public void clickNextFromGainWeight(){
        PageFactory.initElements(getDriver(),this);
        gainWeightModal.clickNext();
    }

    public void selectActivityLevelOption(int option){
        PageFactory.initElements(getDriver(),this);
        activityLevelModal.selectOption(option);
    }

    public void clickNextFromActivityLevel(){
        PageFactory.initElements(getDriver(),this);
        activityLevelModal.clickNext();
    }

    public void selectSex(SEX sex){
        PageFactory.initElements(getDriver(),this);
        demographicModal.selectSex(sex);
    }

    public void chooseBirthday(String date){
        PageFactory.initElements(getDriver(),this);
        demographicModal.chooseBirthday(date);
    }

    public void selectCountry(String country){
        PageFactory.initElements(getDriver(),this);
        demographicModal.selectCountry(country);
    }

    public void clickNextFromDemographic(){
        PageFactory.initElements(getDriver(),this);
        demographicModal.clickNext();
    }

    public void enterHeightFeet(String heightFeet){
        PageFactory.initElements(getDriver(),this);
        demographic2Modal.enterHeightFeet(heightFeet);
    }

    public void enterHeightInches(String heightInches){
        PageFactory.initElements(getDriver(),this);
        demographic2Modal.enterHeightInches(heightInches);
    }

    public void enterWeight(String weight){
        PageFactory.initElements(getDriver(),this);
        demographic2Modal.enterWeight(weight);
    }

    public void enterGoalWeight(String goalWeight){
        PageFactory.initElements(getDriver(),this);
        demographic2Modal.enterGoalWeight(goalWeight);
    }

    public void clickNextFromDemographic2(){
        PageFactory.initElements(getDriver(),this);
        demographic2Modal.clickNext();
    }

    public void selectWeeklyGoalOption(int option){
        PageFactory.initElements(getDriver(),this);
        weeklyGoalModal.selectOption(option);
    }

    public void clickNextWeeklyGoal(){
        PageFactory.initElements(getDriver(),this);
        weeklyGoalModal.clickNext();
    }

    public void enterEmail(String email){
        PageFactory.initElements(getDriver(),this);
        createModal.enterEmail(email);
    }

    public void enterPassword(String password){
        PageFactory.initElements(getDriver(),this);
        createModal.enterPassword(password);
    }

    public void checkTermsAndConditions(){
        PageFactory.initElements(getDriver(),this);
        createModal.checkTermsAndConditions();
    }

    public void clickContinueFromCreate(){
        PageFactory.initElements(getDriver(),this);
        createModal.clickContinue();
    }

    public void enterUserName(String userName){
        PageFactory.initElements(getDriver(),this);
        userNameModal.enterUserName(userName);
    }

    public void clickNextFromUserName(){
        PageFactory.initElements(getDriver(),this);
        userNameModal.clickNext();
    }

}
