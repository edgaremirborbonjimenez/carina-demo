package com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide;

import com.zebrunner.carina.demo.utils.apium.Store;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AptoideStoreProfilePageBase extends AbstractPage {

    public AptoideStoreProfilePageBase(WebDriver driver){
        super(driver);
    }

    public abstract void clickFollowButton();

    public abstract Store getStoreProfileInfo();

    public abstract AptoideStorePageBase goBackToStoresPage();

    public abstract boolean isFollowing();

}
