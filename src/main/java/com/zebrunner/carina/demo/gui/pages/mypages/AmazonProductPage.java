package com.zebrunner.carina.demo.gui.pages.mypages;

import com.zebrunner.carina.demo.gui.components.mycomponents.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonProductPage extends AmazonBasePage{

    @FindBy(tagName = "header")
    Header header;

    @FindBy(xpath = "//span[@id=\"productTitle\"]")
    ExtendedWebElement title;

    @Context(dependsOn = "addToCartForm")
    @FindBy(xpath = "//span[@class='a-price aok-align-center']//span[@class='a-price-whole']")
    ExtendedWebElement price;

    @Context(dependsOn = "addToCartForm")
    @FindBy(xpath = "//span[@class='a-price aok-align-center']//span[@class='a-price-fraction']")
    ExtendedWebElement cents;

    @FindBy(xpath = "//form[@id=\"addToCart\"]")
    ExtendedWebElement addToCartForm;

    @Context(dependsOn = "addToCartForm")
    @FindBy(xpath = ".//input[@id=\"add-to-cart-button\"]")
    ExtendedWebElement addToCart;


    public AmazonProductPage(WebDriver driver){
        super(driver);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(this.waitingTime));
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public String getProductTitle(){
        return this.title.getText();
    }

    public String getProductPrice(){
        return this.price.getText().concat("."+cents.getText());
    }

    public AmazonPageWithSession addToCart(){
        addToCart.click();
        return new AmazonPageWithSession(getDriver());
    }

}
