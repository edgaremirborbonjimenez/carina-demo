package com.zebrunner.carina.demo.mobile.gui.pages.android.aptoide;

import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideEditorialPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideGameInfoPageBase;
import com.zebrunner.carina.demo.utils.apium.App;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = AptoideGameInfoPageBase.class)
public class AptoideGameInfoPage extends AptoideGameInfoPageBase {

    @FindBy(id = "card_info_layout")
    ExtendedWebElement info;

    @FindBy(id = "toolbar_title")
    ExtendedWebElement pageTitle;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    ExtendedWebElement backBtn;

    public AptoideGameInfoPage(WebDriver driver){
        super(driver);
    }

    public App getAppInfo(){
        App app = new App();
        app.setName(pageTitle.getText());
        return app;
    }

    @Override
    public AptoideEditorialPageBase goBack() {
        backBtn.click();
        return initPage(getDriver(), AptoideEditorialPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return info.isElementPresent();
    }
}
