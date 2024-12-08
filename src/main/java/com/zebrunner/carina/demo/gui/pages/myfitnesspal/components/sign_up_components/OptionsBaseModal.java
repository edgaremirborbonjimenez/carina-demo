package com.zebrunner.carina.demo.gui.pages.myfitnesspal.components.sign_up_components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;

public class OptionsBaseModal extends AbstractUIObject {
    @FindBy(xpath = ".//div[@role =\"group\"]/button[%d]")
    ExtendedWebElement options;

    @FindBy(xpath = ".//nav//button")
    ExtendedWebElement nextBtn;

    public OptionsBaseModal(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public void selectOption(LinkedList<Integer> optionsSelected){
        optionsSelected.forEach(opt-> options.format(opt).click());
    }

    public void clickNext(){
        nextBtn.click();
    }
}
