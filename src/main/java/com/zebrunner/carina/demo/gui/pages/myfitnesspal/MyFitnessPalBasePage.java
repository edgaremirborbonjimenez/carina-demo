package com.zebrunner.carina.demo.gui.pages.myfitnesspal;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class MyFitnessPalBasePage extends AbstractPage {

    protected final int waiting = 10;

    public MyFitnessPalBasePage(WebDriver driver){
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

}
