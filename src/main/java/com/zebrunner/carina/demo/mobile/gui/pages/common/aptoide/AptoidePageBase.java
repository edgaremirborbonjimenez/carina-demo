package com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide;

import com.zebrunner.carina.demo.utils.apium.NavigationOptions;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AptoidePageBase extends AbstractPage {

    @FindBy(id = "skip_button")
    protected ExtendedWebElement welcomeSkipBtn;

    @FindBy(id = "bottom_navigation")
    protected ExtendedWebElement bottomNavigation;

    @Context(dependsOn = "bottomNavigation")
    @FindBy(id = "%s")
    protected ExtendedWebElement navOption;

    public AptoidePageBase(WebDriver driver){
        super(driver);
    }

    public void skipWelcome(){
        welcomeSkipBtn.clickIfPresent();
    }

    public AptoideHomePageBase navigateToHome(){
        navOption.format(NavigationOptions.HOME.getId()).click();
        return initPage(getDriver(), AptoideHomePageBase.class);
    }

    public AptoideEditorialPageBase navigateToEditorial(){
        navOption.format(NavigationOptions.EDITORIAL.getId()).click();
        return initPage(getDriver(),AptoideEditorialPageBase.class);
    }

    public AptoideSearchPageBase navigateToSearch(){
        navOption.format(NavigationOptions.SEARCH.getId()).click();
        return initPage(getDriver(),AptoideSearchPageBase.class);
    }

    public AptoideStorePageBase navigateToStore(){
        navOption.format(NavigationOptions.STORE.getId()).click();
        return initPage(getDriver(),AptoideStorePageBase.class);
    }

}
