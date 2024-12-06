package com.zebrunner.carina.demo.gui.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoalsModal extends OptionsBaseModal {

//    @FindBy(xpath = "//div[@role =\"group\"]/button['%d']")
//    ExtendedWebElement goalOptions;
//
//    @FindBy(xpath = "//nav//button")
//    ExtendedWebElement nextBtn;

    public GoalsModal(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

//    public void selectOption(int option){
//        goalOptions.format(option).click();
//    }
//
//    public void clickNext(){
//        nextBtn.click();
//    }

}
