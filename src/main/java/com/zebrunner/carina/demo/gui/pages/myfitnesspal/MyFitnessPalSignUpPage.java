package com.zebrunner.carina.demo.gui.pages.myfitnesspal;

import com.zebrunner.carina.demo.gui.pages.myfitnesspal.components.sign_up_components.*;
import com.zebrunner.carina.demo.gui.pages.myfitnesspal.components.sign_up_components.goals.*;
import com.zebrunner.carina.demo.utils.my_fitness_pal_utils.*;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MyFitnessPalSignUpPage extends MyFitnessPalBasePage {

    @FindBy(xpath = "//button")
    ExtendedWebElement continueBtn;

    @FindBy(xpath = "//button")
    ExtendedWebElement bigStepNext;

    @FindBy(xpath = "//form")
    ExtendedWebElement form;

//    @Context(dependsOn = "form")
//    @FindBy(xpath = "./div")
    @FindBy(xpath = "//form")
    InputNameModal nameModal;

    //@Context(dependsOn = "form")
    @FindBy(xpath = "//form")
    GoalsModal goalsModal;

    @FindBy(xpath = "//form")
    LooseWeightModal looseWeightModal;

    @FindBy(xpath = "//form")
    MaintainWeightModal maintainWeightModal;

    //@Context(dependsOn = "form")
    @FindBy(xpath = "//form")
    GainWeightModal gainWeightModal;

    @FindBy(xpath = "//form")
    GainMuscleModal gainMuscleModal;

    @FindBy(xpath = "//form")
    ModifyMyDietModal modifyMyDietModal;

    @FindBy(xpath = "//form")
    ManageStressModal manageStressModal;

    @FindBy(xpath = "//form")
    IncreaseStepCountModal increaseStepCountModal;

    @FindBy(xpath = "//button")
    ExtendedWebElement generalNext;

    //@Context(dependsOn = "form")
    @FindBy(xpath = "//form")
    ActivityLevelModal activityLevelModal;

    //@Context(dependsOn = "form")
    @FindBy(xpath = "//form")
    DemographicModal demographicModal;

    //@Context(dependsOn = "form")
    @FindBy(xpath = "//form")
    Demographic2Modal demographic2Modal;

    //@Context(dependsOn = "form")
    @FindBy(xpath = "//form")
    WeeklyGoalModal weeklyGoalModal;

    //@Context(dependsOn = "form")
    @FindBy(xpath = "//form")
    CreateModal createModal;

    //@Context(dependsOn = "form")
    @FindBy(xpath = "//form")
    UserNameModal userNameModal;

    //@Context(dependsOn = "form")
    @FindBy(xpath = "//form")
    ConsentsModal consentsModal;

    //@Context(dependsOn = "form")
    @FindBy(xpath = "//form")
    NutritionGoalModal nutritionGoalModal;

    public MyFitnessPalSignUpPage(WebDriver driver){
        super(driver);
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waiting));
//        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waiting));
        wait.until(ExpectedConditions.urlContains("create"));
    }

    public void clickContinue(){
        continueBtn.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waiting));
        wait.until(ExpectedConditions.urlContains("input-name"));
    }

    public void clickNextBigStep(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waiting));
        wait.until(ExpectedConditions.urlContains("big-step"));
        bigStepNext.click();
    }

    public void enterName(String name){
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(nameModal.getElement()));
            nameModal.enterName(name);
    }

    public void clickNextFromName(){
        nameModal.clickNext();
    }

    public void selectGoalOption(Goals[] goals){
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(goalsModal.getElement()));
        Arrays.sort(goals, Comparator.comparingInt(Goals::getOption));
        LinkedList<Integer> optionsSelected = new LinkedList<>();
        Arrays.stream(goals).forEach(g-> optionsSelected.add(g.getOption()));
        goalsModal.selectOption(optionsSelected);
    }

    public void clickNextFromGoals(){
        goalsModal.clickNext();
    }

    public void clickGeneralNext(){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waiting));
        wait.until(ExpectedConditions.urlContains("affirmation"));
        generalNext.click();
    }

    public void selectLoseWeightOption(LooseWeight[] options){
        LinkedList<Integer> optionsSelected = new LinkedList<>();
        Arrays.stream(options).forEach(g-> optionsSelected.add(g.getOption()));
        looseWeightModal.selectOption(optionsSelected);
    }

    public void selectNextFromLoseWeight(){
        looseWeightModal.clickNext();
    }

    public void selectMaintainWeightOption(MaintainWeight[] options){
        LinkedList<Integer> optionsSelected = new LinkedList<>();
        Arrays.stream(options).forEach(g-> optionsSelected.add(g.getOption()));
        looseWeightModal.selectOption(optionsSelected);
    }

    public void selectNextFromMaintainWeight(){
        looseWeightModal.clickNext();
    }

    public void selectGainWeightOptionOption(GainWeight[] options){
        LinkedList<Integer> optionsSelected = new LinkedList<>();
        Arrays.stream(options).forEach(g-> optionsSelected.add(g.getOption()));
        gainWeightModal.selectOption(optionsSelected);
    }

    public void clickNextFromGainWeight(){
        gainWeightModal.clickNext();
    }

    public void selectGainMuscleOption(GainMuscle[] options){
        LinkedList<Integer> optionsSelected = new LinkedList<>();
        Arrays.stream(options).forEach(g-> optionsSelected.add(g.getOption()));
        gainMuscleModal.selectOption(optionsSelected);
    }

    public void selectNextFromGainMuscle(){
        gainMuscleModal.clickNext();
    }

    public void selectModifyDietOption(ModifyDiet[] options){
        LinkedList<Integer> optionsSelected = new LinkedList<>();
        Arrays.stream(options).forEach(g-> optionsSelected.add(g.getOption()));
        modifyMyDietModal.selectOption(optionsSelected);
    }

    public void selectNextFromModifyDiet(){
        modifyMyDietModal.clickNext();
    }

    public void selectManageStressOptions(ManageStress[] options){
        LinkedList<Integer> optionsSelected = new LinkedList<>();
        Arrays.stream(options).forEach(g-> optionsSelected.add(g.getOption()));
        manageStressModal.selectOption(optionsSelected);
    }

    public void selectNextFromManageStress(){
        manageStressModal.clickNext();
    }

    public void selectIncreaseStepCountOptions(IncreaseSteps[] options){
        LinkedList<Integer> optionsSelected = new LinkedList<>();
        Arrays.stream(options).forEach(g-> optionsSelected.add(g.getOption()));
        increaseStepCountModal.selectOption(optionsSelected);
    }

    public void selectNextFromIncreaseStepCount(){
        manageStressModal.clickNext();
    }

    public void selectActivityLevelOption(ActivityLevel options){
        LinkedList<Integer> optionsSelected = new LinkedList<>();
        optionsSelected.add(options.getOption());
        activityLevelModal.selectOption(optionsSelected);
    }

    public void clickNextFromActivityLevel(){
        activityLevelModal.clickNext();
    }

    public void selectSex(Sex sex){
        demographicModal.selectSex(sex);
    }

    public void chooseBirthday(String date){
        demographicModal.chooseBirthday(date);
    }

    public String getBirthday(){
        return demographicModal.getBirthday();
    }

    public void selectCountry(Country country){
        demographicModal.selectCountry(country.getOption());
    }

    public void enterZipCode(String zipcode){
        demographicModal.enterZipCode(zipcode);
    }

    public void clickNextFromDemographic(){
        demographicModal.clickNext();
    }

    public void enterHeightFeet(String heightFeet){
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

    public void selectWeeklyGoalOption(WeeklyGoal option){
        LinkedList<Integer> optionsSelected = new LinkedList<>();
        optionsSelected.add(option.getOption());
        weeklyGoalModal.selectOption(optionsSelected);
    }

    public void clickNextWeeklyGoal(){
        weeklyGoalModal.clickNext();
    }

    public void enterEmail(String email){
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
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waiting));
        wait.until(ExpectedConditions.urlContains("username"));
        userNameModal.enterUserName(userName);
    }

    public void clickNextFromUserName(){
        userNameModal.clickNext();
    }

    public void acceptConsents(){
        consentsModal.acceptConsents();
    }

    public void clickFinish(){
        consentsModal.clickFinish();
    }

    public String getCongratulationsMessage(){
        return nutritionGoalModal.getCongratulationsMessage();
    }

    public void clickNewsCheckBox(){
        nutritionGoalModal.clickNewsCheckBox();
    }

    public MyFitnessPalHomePageWithSession goToMyFitnessPal(){
        nutritionGoalModal.clickExploreBtn();
        return new MyFitnessPalHomePageWithSession(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return getDriver().getCurrentUrl().contains("account/create");
    }
}
