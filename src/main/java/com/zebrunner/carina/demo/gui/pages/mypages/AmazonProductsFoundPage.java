package com.zebrunner.carina.demo.gui.pages.mypages;

import com.zebrunner.carina.demo.gui.components.mycomponents.ProductItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class AmazonProductsFoundPage extends AmazonBasePage{
    @FindBy(xpath = "//div[@data-component-type=\"s-search-result\"]/div")
    private List<ProductItem> products;

    public AmazonProductsFoundPage(WebDriver driver){
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(this.waitingTime));
        wait.until(ExpectedConditions.visibilityOf(this.products.get(0)));
    }

    public AmazonProductPage goToProductPage(int index){
        this.products.get(index).goToProductPage();
        return new AmazonProductPage(getDriver());
    }

    public List<ProductItem> getProductResults(){
        return this.products;
    }

    public String getProductName(int index){
        return this.products.get(index).getTitleRecipe();
    }

    public String getProductPrice(int index){
        return this.products.get(index).getPriceRecipe();
    }

}
