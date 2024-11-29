package com.zebrunner.carina.demo.gui.pages.mypages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AmazonSignInPage extends AbstractPage {

    private static String signInUrl = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fcss%2Fhomepage.html%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";

    @FindBy(xpath = "//input[@id=\"ap_email\"]")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@id=\"ap_password\"]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@id=\"continue\"]")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//input[@id=\"signInSubmit\"]")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//div[@id=\"auth-error-message-box\"]")
    private ExtendedWebElement authErrorMessageBox;

    @Context(dependsOn = "authErrorMessageBox")
    @FindBy(xpath = ".//span")
    private ExtendedWebElement authErrorMessageText;


    public AmazonSignInPage(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return getDriver().findElement(By.tagName("h1")).getText();
    }

    public AmazonPageWithSession signIn(String emailOrPhone, String password){
        enterEmailOrPhoneNumber(emailOrPhone);
        enterPassword(password);
        return new AmazonPageWithSession(getDriver());
    }

        public void enterEmailOrPhoneNumber(String value){
        emailInput.type(value);
        continueButton.click();
    }

    public void enterPassword(String password){
        passwordInput.type(password);
        signInButton.click();
    }

    public String getAuthErrorMessage(){
        return authErrorMessageText.getText();
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }


    @Override
    public void open() {
        getDriver().get(signInUrl);
    }

    @Override
    public boolean isPageOpened() {
        return getDriver().getCurrentUrl().contains("signin");
    }
}
