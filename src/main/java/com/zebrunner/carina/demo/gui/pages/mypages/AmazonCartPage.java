package com.zebrunner.carina.demo.gui.pages.mypages;

import com.zebrunner.carina.demo.gui.components.mycomponents.CartProduct;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class AmazonCartPage extends AmazonBasePage{

    @FindBy(xpath = "//span[@id=\"sc-subtotal-amount-buybox\"]/span")
    ExtendedWebElement subTotal;

    @FindBy(xpath = "//div[@class=\"sc-list-item-content\"]")
    private List<CartProduct> products;

    public AmazonCartPage(WebDriver driver){
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(this.waitingTime));
        wait.until(ExpectedConditions.visibilityOf(products.get(0)));
    }

    public Double getSubTotal(){
        return Double.parseDouble(subTotal.getText().substring(1,subTotal.getText().length()));
    }

    public List<CartProduct> getCartProducts(){
        return products;
    }

    public void removeProductFromCart(int index){
        this.products.get(index).removeFromCar();
    }
}
