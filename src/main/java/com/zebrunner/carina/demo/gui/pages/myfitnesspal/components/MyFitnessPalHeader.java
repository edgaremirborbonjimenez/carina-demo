package com.zebrunner.carina.demo.gui.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyFitnessPalHeader extends AbstractUIObject {

    @FindBy(xpath = "//p[text()=\"Hi, \"]/a")
    ExtendedWebElement userName;

    public MyFitnessPalHeader(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public String getUserName(){
        return userName.getText();
    }

}
