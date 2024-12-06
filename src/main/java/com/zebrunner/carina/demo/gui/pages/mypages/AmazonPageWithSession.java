package com.zebrunner.carina.demo.gui.pages.mypages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AmazonPageWithSession extends AmazonBasePage {

    @Context(dependsOn = "navTool")
    @FindBy(xpath = ".//a[4]")
    private ExtendedWebElement cartOption;

    public AmazonPageWithSession(WebDriver driver){
        super(driver);
    }

    public String getWelcomeMessageWithUserName(){
        return this.header.getWelcomeMessage();
    }

    public void showAccountOptions(){
        this.header.hoverNavToolsOption("nav-link-accountList");
    }

    public AmazonSignInPage signOut(){
        header.selectYourAccountOption("Sign Out");
        return  new AmazonSignInPage(getDriver());
    }

    public String getSignOutText(){
        return this.yourAccountOption.format("Sign Out").getText();
    }

    @Override
    public boolean isPageOpened() {
        return getDriver().getCurrentUrl().contains("signin");
    }

    public AmazonCartPage goToCart(){
        cartOption.click();
        return new AmazonCartPage(getDriver());
    }

}
