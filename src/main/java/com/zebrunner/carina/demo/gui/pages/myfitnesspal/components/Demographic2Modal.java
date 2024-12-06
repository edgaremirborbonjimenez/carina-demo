package com.zebrunner.carina.demo.gui.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Demographic2Modal extends AbstractUIObject {

    @FindBy(xpath = "//input[@id=\"Height (feet)\"]")
    ExtendedWebElement enterHeightFeet;

    @FindBy(xpath = "//input[@id=\"Height (inches)\"]")
    ExtendedWebElement enterHeightInches;

    @FindBy(xpath = "//input[@id=\"Current weight\"]")
    ExtendedWebElement enterWeight;

    @FindBy(xpath = "//input[@id=\"Goal weight\"]")
    ExtendedWebElement enterGoalWeight;

    @FindBy(xpath = "//*[text()=\"Next\"]/..")
    ExtendedWebElement nextBtn;

    public Demographic2Modal(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public void enterHeightFeet(String heightFeet){
        enterHeightFeet.type(heightFeet);
    }

    public void enterHeightInches(String heightInches){
        enterHeightInches.type(heightInches);
    }

    public void enterWeight(String weight){
        enterWeight.type(weight);
    }

    public void enterGoalWeight(String goalWeight){
        enterGoalWeight.type(goalWeight);
    }

    public void clickNext(){
        nextBtn.click();
    }

}
