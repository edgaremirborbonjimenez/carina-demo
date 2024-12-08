package com.zebrunner.carina.demo.gui.pages.myfitnesspal;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyFitnessPalLogInPage extends MyFitnessPalBasePage {

    @FindBy(xpath = "//a/p[text()=\"Sign Up\"]")
    ExtendedWebElement signUpBtn;

    @FindBy(id = "email")
    ExtendedWebElement emailInput;

    @FindBy(id = "password")
    ExtendedWebElement passwordInput;

    @FindBy(xpath = "//span[text()=\"Log in\"]/..")
    ExtendedWebElement logInBtn;


    public MyFitnessPalLogInPage(WebDriver driver){
        super(driver);
    }

    public MyFitnessPalSignUpPage goToSignUp(){
        signUpBtn.click();
        return new MyFitnessPalSignUpPage(getDriver());
    }

    public MyFitnessPalHomePageWithSession logIn(String email, String password){
        emailInput.type(email);
        passwordInput.type(password);
//        pause(waiting);
//        logInBtn.click();
        return new MyFitnessPalHomePageWithSession(getDriver());
    }

    @Override
    public void open() {
        getDriver().navigate().to(R.CONFIG.get("url_login"));
        if(iframe.isElementPresent()){
            getDriver().switchTo().frame(iframe.getElement());
            acceptCookies.clickIfPresent(waiting);
            getDriver().switchTo().defaultContent();
        }
    }
}
