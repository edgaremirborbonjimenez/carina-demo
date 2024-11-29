package com.zebrunner.carina.demo.gui.components.mycomponents;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartProduct extends AbstractUIObject {

    @FindBy(xpath = ".//span[contains(@class,\"sc-product-price\")]/span[2]")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//h4/span/span[2]")
    private ExtendedWebElement name;

    @FindBy(xpath = ".//button[1]")
    private ExtendedWebElement removeButton;

    public CartProduct(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public Double getProductPrice(){
        return Double.parseDouble(price.getText().substring(1,price.getText().length()));
    }

    public String getProductName(){
         String nambre = name.getText();
        return nambre;
    }

    public void removeFromCar(){
        removeButton.click();
    }
}
