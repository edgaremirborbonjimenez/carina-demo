package com.zebrunner.carina.demo.gui.pages.myfitnesspal.components.sign_up_components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ConsentsModal extends AbstractUIObject {

    @FindBy(xpath = "//input[@aria-label=\"Accept All\"]")
    ExtendedWebElement checkAllBox;

    @FindBy(xpath = "//span[text()=\"Finish\"]/..")
    ExtendedWebElement finishBtn;

    public ConsentsModal(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public void acceptConsents(){
        checkAllBox.click();
    }

    public void clickFinish(){
        finishBtn.click();
    }

}
