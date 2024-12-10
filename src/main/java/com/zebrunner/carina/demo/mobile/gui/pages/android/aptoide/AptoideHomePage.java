package com.zebrunner.carina.demo.mobile.gui.pages.android.aptoide;

import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideHomePageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideSeeMorePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = AptoideHomePageBase.class)
public class AptoideHomePage extends AptoideHomePageBase implements IMobileUtils {

    @FindBy(id = "main_home_container_content")
    ExtendedWebElement homePageContent;

    @FindBy(id = "games_chip")
    ExtendedWebElement gameCheckBox;

    @FindBy(id = "apps_chip")
    ExtendedWebElement appCheckBox;

    @FindBy(id = "top_list")
    ExtendedWebElement topList;

    @FindBy(xpath = "//android.widget.TextView[@text='Top Games']")
    ExtendedWebElement topGamesTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Top Apps']")
    ExtendedWebElement topAppsTitle;

    @FindBy(id = "see_more_btn")
    ExtendedWebElement seeMoreBtn;

    public AptoideHomePage(WebDriver driver){
        super(driver);
        this.skipWelcome();
    }

    @Override
    public boolean isPageOpened() {
        return homePageContent.isElementPresent();
    }

    public void checkGamesCheckBox(){
        gameCheckBox.click();
    }

    public void checkAppsCheckBox(){
        appCheckBox.click();
    }

    public boolean gamesCheckBoxIsChecked(){
        return Boolean.parseBoolean(gameCheckBox.getAttribute("checked"));
    }

    public boolean appsCheckBoxIsChecked(){
        return Boolean.parseBoolean(appCheckBox.getAttribute("checked"));
    }

    public boolean topGamesListShowed(){
        return topGamesTitle.isElementPresent();
    }

    public boolean topAppsListShowed(){
        return topAppsTitle.isElementPresent();
    }

    public AptoideSeeMorePageBase goToSeeMore(){
        swipe(seeMoreBtn);
        seeMoreBtn.click();
        return initPage(getDriver(),AptoideSeeMorePageBase.class);
    }

}
