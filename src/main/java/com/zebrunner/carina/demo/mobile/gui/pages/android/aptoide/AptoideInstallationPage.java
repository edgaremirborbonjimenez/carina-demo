package com.zebrunner.carina.demo.mobile.gui.pages.android.aptoide;

import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideInstallationPageBase;
import com.zebrunner.carina.demo.utils.apium.App;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = AptoideInstallationPageBase.class)
public class AptoideInstallationPage extends AptoideInstallationPageBase {

    @FindBy(id = "app_name")
    ExtendedWebElement appTitle;

    public AptoideInstallationPage(WebDriver driver){
        super(driver);
        appTitle.isElementPresent();
    }

    @Override
    public App getAppInfo() {
        App app = new App();
        app.setName(appTitle.getText());
        return app;
    }

    @Override
    public boolean isPageOpened() {
        return appTitle.isElementPresent();
    }
}
