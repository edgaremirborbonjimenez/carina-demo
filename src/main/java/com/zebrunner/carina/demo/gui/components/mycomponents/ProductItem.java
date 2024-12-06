package com.zebrunner.carina.demo.gui.components.mycomponents;

import com.zebrunner.carina.demo.gui.pages.mypages.AmazonProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject {

    @FindBy(xpath = ".//div[@data-cy=\"title-recipe\"]/h2//span")
    private ExtendedWebElement titleRecipe;

    @FindBy(xpath = ".//div[@data-cy=\"price-recipe\"]//a/span/span[2]")
    private ExtendedWebElement priceRecipe;

    @FindBy(xpath = ".//h2")
    private ExtendedWebElement goToPageButton;


    public ProductItem(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public String getTitleRecipe(){
        String title = titleRecipe.getText();
       return title;
    }

    public String getPriceRecipe(){
        String price =  priceRecipe.getText().replace("\n", ".");
        price = price.replace("$","");
        return price;
    }

    public void goToProductPage(){
        this.goToPageButton.click();
    }

}
