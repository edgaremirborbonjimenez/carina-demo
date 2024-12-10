package com.zebrunner.carina.demo.mobile.gui.pages.android.aptoide;

import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideStorePageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideStoreProfilePageBase;
import com.zebrunner.carina.demo.utils.apium.Store;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

@DeviceType(pageType = Type.ANDROID_PHONE,parentClass = AptoideStorePageBase.class)
public class AptoideStorePage extends AptoideStorePageBase {

    @FindBy(id = "swipe_container")
    ExtendedWebElement content;

    @FindBy(id = "store_name_row")
    List<ExtendedWebElement> followedStores;

    @FindBy(id = "recommended_store_name")
    List<ExtendedWebElement> recommendedStores;

    public AptoideStorePage(WebDriver driver){
        super(driver);
    }

    @Override
    public List<Store> getFollowedStores() {
        List<Store> storesList = new LinkedList<>();
        followedStores.forEach(s->{
            Store store = new Store();
            store.setName(s.getText());
            storesList.add(store);
        });
        return storesList;
    }

    @Override
    public List<Store> getRecommendedStores() {
        List<Store> storesList = new LinkedList<>();
        recommendedStores.forEach(s->{
            Store store = new Store();
            store.setName(s.getText());
            storesList.add(store);
        });
        return storesList;
    }

    @Override
    public AptoideStoreProfilePageBase goToFirstFollowedStore() {
        followedStores.get(0).click();
        return initPage(getDriver(),AptoideStoreProfilePageBase.class);
    }

    @Override
    public AptoideStoreProfilePageBase goToFirstRecommendedStore() {
        recommendedStores.get(0).click();
        return initPage(getDriver(),AptoideStoreProfilePageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return content.isElementPresent();
    }
}
