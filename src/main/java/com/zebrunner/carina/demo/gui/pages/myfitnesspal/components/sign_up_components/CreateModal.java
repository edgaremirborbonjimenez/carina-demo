package com.zebrunner.carina.demo.gui.pages.myfitnesspal.components.sign_up_components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateModal extends AbstractUIObject {

    @FindBy(xpath = "//input[@id=\"Email address\"]")
    ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@id=\"Create a password\"]")
    ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    ExtendedWebElement termsConditionsCheck;

    @FindBy(xpath = "//span[text()=\"Continue\"]/..")
    ExtendedWebElement continueBtn;

    public CreateModal(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public void enterEmail(String email){
        emailInput.type(email);
    }

    public void enterPassword(String password){
        passwordInput.type(password);
    }

    public void checkTermsAndConditions(){
        termsConditionsCheck.click();
    }

    public void clickContinue(){
        continueBtn.click();
    }


}
