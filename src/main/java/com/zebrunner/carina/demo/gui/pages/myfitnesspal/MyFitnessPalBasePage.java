package com.zebrunner.carina.demo.gui.pages.myfitnesspal;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyFitnessPalBasePage extends AbstractPage {

    protected final int waiting = 10;

    @FindBy(xpath = "//iframe[@id=\"sp_message_iframe_1164399\"]")
    ExtendedWebElement iframe;

    @FindBy(xpath = "//button[text()=\"OK\"]")
    ExtendedWebElement acceptCookies;

    public MyFitnessPalBasePage(WebDriver driver){
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

}
