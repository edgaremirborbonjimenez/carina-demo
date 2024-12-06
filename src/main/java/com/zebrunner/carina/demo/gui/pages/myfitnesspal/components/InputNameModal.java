package com.zebrunner.carina.demo.gui.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InputNameModal extends AbstractUIObject {

    @FindBy(xpath = "//input")
    ExtendedWebElement nameInput;

    @FindBy(xpath = "//button")
    ExtendedWebElement nextBtn;

    public InputNameModal(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public void enterName(String name){
        nameInput.type(name);
    }

    public void clickNext(){
        nextBtn.click();
    }
}
