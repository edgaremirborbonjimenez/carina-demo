package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyHomePage extends AbstractPage {

    @FindBy(css = "#topsearch>input")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//a[text()='%s']")
    private ExtendedWebElement phoneOptionFinder;

    public MyHomePage(WebDriver driver){
        super(driver);
    }

    public void openPage(){
        this.getDriver().navigate().to("https://www.gsmarena.com");
    }

    public void searchInput(String input){
        searchInput.type(input);
        searchInput.sendKeys(Keys.ENTER);
//        this.getDriver().findElement(By.cssSelector("#topsearch>input")).sendKeys("Huawei");
//        this.getDriver().findElement(By.cssSelector("#topsearch>input")).sendKeys(Keys.ENTER);
    }

    public void goToPhoneFinderOption(String option){
        phoneOptionFinder.format(option).click();
//        this.getDriver().findElement(By.xpath("//a[text()=\""+option+"\"]")).click();
    }
}
