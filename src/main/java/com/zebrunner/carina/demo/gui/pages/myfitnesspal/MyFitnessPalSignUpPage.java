package com.zebrunner.carina.demo.gui.pages.myfitnesspal;

import com.zebrunner.carina.demo.gui.pages.myfitnesspal.components.sign_up_components.*;
import com.zebrunner.carina.demo.utils.SEX;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
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

    @Context(dependsOn = "form")
    ConsentsModal consentsModal;

    @Context(dependsOn = "form")
    NutritionGoalModal nutritionGoalModal;

    public MyFitnessPalSignUpPage(WebDriver driver){
        super(driver);
        setUiLoadedMarker(continueBtn);
    }

    public void clickContinue(){
        continueBtn.click();
    }

    public void enterName(String name){
        nameModal.enterName(name);
    }

    public void clickNextFromName(){
        nameModal.clickNext();
    }

    public void selectGoalOption(int option){
        PageFactory.initElements(getDriver(), this);
        goalsModal.selectOption(option);
    }

    public void clickNextFromGoals(){
        goalsModal.clickNext();
    }

    public void clickGeneralNext(){
        PageFactory.initElements(getDriver(), this);
        generalNext.click();
    }

    public void selectGainWeightOption(int option){
        PageFactory.initElements(getDriver(), this);
        gainWeightModal.selectOption(option);
    }

    public void clickNextFromGainWeight(){
        gainWeightModal.clickNext();
    }

    public void selectActivityLevelOption(int option){
        activityLevelModal.selectOption(option);
    }

    public void clickNextFromActivityLevel(){
        activityLevelModal.clickNext();
    }

    public void selectSex(SEX sex){
        PageFactory.initElements(getDriver(), this);
        demographicModal.selectSex(sex);
    }

    public void chooseBirthday(String date){
        demographicModal.chooseBirthday(date);
    }

    public void selectCountry(String country){
        demographicModal.selectCountry(country);
    }

    public void clickNextFromDemographic(){
        demographicModal.clickNext();
    }

    public void enterHeightFeet(String heightFeet){
        PageFactory.initElements(getDriver(), this);
        demographic2Modal.enterHeightFeet(heightFeet);
    }

    public void enterHeightInches(String heightInches){
        demographic2Modal.enterHeightInches(heightInches);
    }

    public void enterWeight(String weight){
        demographic2Modal.enterWeight(weight);
    }

    public void enterGoalWeight(String goalWeight){
        demographic2Modal.enterGoalWeight(goalWeight);
    }

    public void clickNextFromDemographic2(){
        demographic2Modal.clickNext();
    }

    public void selectWeeklyGoalOption(int option){
        PageFactory.initElements(getDriver(), this);
        weeklyGoalModal.selectOption(option);
    }

    public void clickNextWeeklyGoal(){
        weeklyGoalModal.clickNext();
    }

    public void enterEmail(String email){
        PageFactory.initElements(getDriver(), this);
        createModal.enterEmail(email);
    }

    public void enterPassword(String password){
        createModal.enterPassword(password);
    }

    public void checkTermsAndConditions(){
        createModal.checkTermsAndConditions();
    }

    public void clickContinueFromCreate(){
        createModal.clickContinue();
    }

    public void enterUserName(String userName){
        PageFactory.initElements(getDriver(), this);
        userNameModal.enterUserName(userName);
    }

    public void clickNextFromUserName(){
        userNameModal.clickNext();
    }

    public void acceptConsents(){
        PageFactory.initElements(getDriver(), this);
        consentsModal.acceptConsents();
    }

    public void clickFinish(){
        consentsModal.clickFinish();
    }

    public String getCongratulationsMessage(){
        PageFactory.initElements(getDriver(), this);
        return nutritionGoalModal.getCongratulationsMessage();
    }

    public void clickNewsCheckBox(){
        nutritionGoalModal.clickNewsCheckBox();
    }

    public void clickExploreBtn(){
        nutritionGoalModal.clickExploreBtn();
    }

}
