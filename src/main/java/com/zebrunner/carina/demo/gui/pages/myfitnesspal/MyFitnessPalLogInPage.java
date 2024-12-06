package com.zebrunner.carina.demo.gui.pages.myfitnesspal;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyFitnessPalLogInPage extends MyFitnessPalBasePage {

    @FindBy(xpath = "//a/p[text()=\"Sign Up\"]")
    ExtendedWebElement signUpBtn;

    @FindBy(xpath = "//div[@id=\"RGIpp2\"]//input")
    ExtendedWebElement humanValidationCheckBox;

    public MyFitnessPalLogInPage(WebDriver driver){
        super(driver);
        humanValidationCheckBox.clickIfPresent(waiting);
    }

    public MyFitnessPalSignUpPage goToSignUp(){
        signUpBtn.click();
        return new MyFitnessPalSignUpPage(getDriver());
    }

}
