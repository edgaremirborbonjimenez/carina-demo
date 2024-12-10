package com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide;

import com.zebrunner.carina.demo.utils.apium.App;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class AptoideEditorialPageBase extends AptoidePageBase{


    public AptoideEditorialPageBase(WebDriver driver){
        super(driver);
    }

    public abstract AptoideGameInfoPageBase goToFirstGameInfo();

    public abstract List<App> getResults();


}
