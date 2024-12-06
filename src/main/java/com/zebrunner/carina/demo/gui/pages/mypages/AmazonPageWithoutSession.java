package com.zebrunner.carina.demo.gui.pages.mypages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AmazonPageWithoutSession extends AmazonBasePage {

    @Context(dependsOn = "navTool")
    @FindBy(xpath = ".//a[2]")
    private ExtendedWebElement signInOption;


    public AmazonPageWithoutSession(WebDriver driver){
        super(driver);
    }

    public AmazonSignInPage goToSignPage(){
        signInOption.click();
        return new AmazonSignInPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return getDriver().getCurrentUrl().contains("https://www.amazon.com/");
    }
}
