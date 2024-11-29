package com.zebrunner.carina.demo.gui.pages.mypages;

import com.zebrunner.carina.demo.gui.components.mycomponents.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AmazonBasePage extends AbstractPage {

    protected final Long waitingTime = 10L;

    @FindBy(id = "navbar-main")
    Header header;

    @FindBy(xpath = "//div[@id=\"nav-tools\"]")
    protected ExtendedWebElement navTool;

    @FindBy(xpath = "//div[@id=\"nav-al-your-account\"]/a/span[text()='%s']")
    protected ExtendedWebElement yourAccountOption;

    public AmazonBasePage(WebDriver driver){
        super(driver);
    }

    public AmazonProductsFoundPage searchProduct(String productName){
        this.header.searchProduct(productName);
        return new AmazonProductsFoundPage(getDriver());
    }

    @Override
    public void open() {
        super.open();
    }
}
