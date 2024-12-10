package com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide;

import com.zebrunner.carina.demo.utils.apium.App;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AptoideInstallationPageBase extends AbstractPage {

    public AptoideInstallationPageBase(WebDriver driver){
        super(driver);
    }

    public abstract App getAppInfo();

}
