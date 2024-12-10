package com.zebrunner.carina.demo.mobile.gui.pages.android.aptoide;

import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideStorePageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideStoreProfilePageBase;
import com.zebrunner.carina.demo.utils.apium.Store;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = AptoideStoreProfilePageBase.class)
public class AptoideStoreProfilePage extends AptoideStoreProfilePageBase {

    @FindBy(id = "follow_store_button")
    ExtendedWebElement followBtn;

    @FindBy(id = "main_name")
    ExtendedWebElement storeName;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    ExtendedWebElement backBtn;

    public AptoideStoreProfilePage(WebDriver driver){
        super(driver);
    }

    @Override
    public void clickFollowButton() {
        followBtn.click();
    }

    @Override
    public Store getStoreProfileInfo() {
        Store store = new Store();
        store.setName(storeName.getText());
        return store;
    }

    @Override
    public AptoideStorePageBase goBackToStoresPage() {
        backBtn.click();
        return initPage(getDriver(),AptoideStorePageBase.class);
    }

    @Override
    public boolean isFollowing() {
        return !followBtn.getText().equals("FOLLOW");
    }

    @Override
    public boolean isPageOpened() {
        return followBtn.isElementPresent();
    }
}
