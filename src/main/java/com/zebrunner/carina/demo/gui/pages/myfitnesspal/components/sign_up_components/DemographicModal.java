package com.zebrunner.carina.demo.gui.pages.myfitnesspal.components.sign_up_components;

import com.zebrunner.carina.demo.utils.my_fitness_pal_utils.Sex;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DemographicModal extends AbstractUIObject {

    @FindBy(xpath = "//input[@value='%s']")
    ExtendedWebElement sexCheckBox;

    @FindBy(xpath = "//input[@id=\"birthday\"]")
    ExtendedWebElement birthday;

    @FindBy(xpath = "//*[@id='country-selector-label']/..")
    ExtendedWebElement selectCountry;

    @FindBy(xpath = "//li[text()='%s']")
    ExtendedWebElement countryOption;

    @FindBy(id = "zipcode")
    ExtendedWebElement zipCodeInput;

    @FindBy(xpath = "//*[text()=\"Next\"]/..")
    ExtendedWebElement nextBtn;

    public DemographicModal(WebDriver driver, SearchContext searchContext){
        super(driver,searchContext);
    }

    public void selectSex(Sex sex){
        sexCheckBox.format(sex.getSex()).click();
    }

    public void chooseBirthday(String date){
        birthday.type(date);
    }

    public String getBirthday(){
        return birthday.getText();
    }

    public void selectCountry(String country){
        selectCountry.click();
        countryOption.format(country).click();
    }

    public void enterZipCode(String zipCode){
        zipCodeInput.type(zipCode);
    }

    public void clickNext(){
        nextBtn.click();
    }
}
