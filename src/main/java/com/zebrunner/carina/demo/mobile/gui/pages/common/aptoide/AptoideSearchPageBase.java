package com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public abstract class AptoideSearchPageBase extends AptoidePageBase{

    public AptoideSearchPageBase(WebDriver driver){
        super(driver);
    }

    public abstract AptoideResultsPageBase searchAnApp(String appName);
}
