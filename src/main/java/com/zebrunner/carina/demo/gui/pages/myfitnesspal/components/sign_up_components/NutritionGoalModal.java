package com.zebrunner.carina.demo.gui.pages.myfitnesspal.components.sign_up_components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NutritionGoalModal extends AbstractUIObject {

    @FindBy(tagName = "h1")
    ExtendedWebElement congratulationMessage;

    @FindBy(xpath = "//input[@name=\"enewsletter\"]")
    ExtendedWebElement newsCheckBox;

    @FindBy(xpath = "//span[text()=\"Explore MyFitnessPal\"]/..")
    ExtendedWebElement exploreBtn;

    public NutritionGoalModal(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public String getCongratulationsMessage(){
        return congratulationMessage.getText();
    }

    public void clickNewsCheckBox(){
        newsCheckBox.click();
    }

    public void clickExploreBtn(){
        exploreBtn.click();
    }

}
