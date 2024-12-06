package com.zebrunner.carina.demo.gui.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserNameModal extends AbstractUIObject {

    @FindBy(xpath = "//input[@id=\"Create a username\"]")
    ExtendedWebElement userNameInput;

    @FindBy(xpath = "//span[text()=\"Next\"]/..")
    ExtendedWebElement nextBtn;

    public UserNameModal(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public void enterUserName(String userName){
        userNameInput.type(userName);
    }

    public void clickNext(){
        nextBtn.click();
    }

}
