package com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AptoideSeeMorePageBase extends AbstractPage {
    public AptoideSeeMorePageBase(WebDriver driver){
        super(driver);
    }

    public abstract AptoideHomePageBase goBackToHomePage();

}
