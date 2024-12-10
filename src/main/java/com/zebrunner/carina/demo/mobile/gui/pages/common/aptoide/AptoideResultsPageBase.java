package com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide;

import com.zebrunner.carina.demo.utils.apium.App;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AptoideResultsPageBase extends AptoidePageBase{

    public AptoideResultsPageBase(WebDriver driver){
        super(driver);
    }

    public abstract List<App> getApps();

    public abstract AptoideInstallationPageBase goToInstallFirstSuggestion();
    }
