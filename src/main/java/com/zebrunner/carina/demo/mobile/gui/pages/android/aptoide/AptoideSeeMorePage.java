package com.zebrunner.carina.demo.mobile.gui.pages.android.aptoide;

import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideHomePageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideSeeMorePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AptoideSeeMorePageBase.class)
public class AptoideSeeMorePage extends AptoideSeeMorePageBase {

    @FindBy(id = "apps_list")
    ExtendedWebElement appsList;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    ExtendedWebElement backBtn;

    public AptoideSeeMorePage(WebDriver driver){
        super(driver);
    }

    @Override
    public AptoideHomePageBase goBackToHomePage() {
        backBtn.click();
        return initPage(getDriver(),AptoideHomePageBase.class);
    }


    @Override
    public boolean isPageOpened() {
        return appsList.isElementPresent();
    }
}
