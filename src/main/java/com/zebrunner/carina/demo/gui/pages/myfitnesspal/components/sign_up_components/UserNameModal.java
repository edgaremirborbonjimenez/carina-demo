package com.zebrunner.carina.demo.gui.pages.myfitnesspal.components.sign_up_components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class UserNameModal extends AbstractUIObject {

    private final int waiting = 10;

    @FindBy(xpath = ".//input[@id=\"Create a username\"]")
    ExtendedWebElement userNameInput;

    @FindBy(xpath = ".//span[text()=\"Finish\"]/..")
    ExtendedWebElement nextBtn;

    public UserNameModal(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public void enterUserName(String userName){
        userNameInput.getElement().sendKeys(Keys.CONTROL + "a");
        userNameInput.getElement().sendKeys(Keys.BACK_SPACE);
        userNameInput.type(userName);
    }

    public void clickNext(){
        nextBtn.click();
    }

}
