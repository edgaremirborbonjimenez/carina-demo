package com.zebrunner.carina.demo.gui.components.mycomponents;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header extends AbstractUIObject {

    private final Long waitingTime = 10L;

    @FindBy(xpath = "//header//div[@id=\"nav-tools\"]")
    private ExtendedWebElement navTools;

    @Context(dependsOn = "navTools")
    @FindBy(xpath = "./a[@id='%s']")
    private ExtendedWebElement navToolsOptions;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private ExtendedWebElement welcomeMessage;

    @FindBy(xpath = "//div[@id=\"nav-al-your-account\"]/a/span[text()='%s']")
    private ExtendedWebElement yourAccountOption;

    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    private ExtendedWebElement searchTextBox;

    public Header(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public void selectYourAccountOption(String option){
        this.yourAccountOption = this.yourAccountOption.format(option);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.visibilityOf(this.yourAccountOption));
        this.yourAccountOption.click();
    }

    public void hoverNavToolsOption(String navToolOption){
        this.navToolsOptions.format(navToolOption).hover();
    }

    public String getWelcomeMessage(){
        return welcomeMessage.getText();
    }

    public void searchProduct(String productName){
        searchTextBox.type(productName);
        searchTextBox.sendKeys(Keys.ENTER);
    }

}
