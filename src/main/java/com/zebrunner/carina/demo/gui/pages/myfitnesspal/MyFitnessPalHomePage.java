package com.zebrunner.carina.demo.gui.pages.myfitnesspal;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyFitnessPalHomePage extends MyFitnessPalBasePage {


    @FindBy(xpath = "//section[1]//a")
    ExtendedWebElement accountBtn;

    public MyFitnessPalHomePage(WebDriver driver){
        super(driver);
        setUiLoadedMarker(accountBtn);
  }

    public MyFitnessPalLogInPage goToLoginPage(){
        accountBtn.click();
        return new MyFitnessPalLogInPage(getDriver());
    }

    @Override
    public void open() {
        super.open();
        if(iframe.isElementPresent()){
            getDriver().switchTo().frame(iframe.getElement());
            acceptCookies.clickIfPresent(waiting);
            getDriver().switchTo().defaultContent();
        }
    }
}
