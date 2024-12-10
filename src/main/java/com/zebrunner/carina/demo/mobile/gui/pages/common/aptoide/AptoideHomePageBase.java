package com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide;

import org.openqa.selenium.WebDriver;

public abstract class AptoideHomePageBase extends AptoidePageBase{

    public AptoideHomePageBase(WebDriver driver){
        super(driver);
    };

    public abstract void checkGamesCheckBox();

    public abstract void checkAppsCheckBox();

    public abstract boolean gamesCheckBoxIsChecked();

    public abstract boolean appsCheckBoxIsChecked();

    public abstract boolean topGamesListShowed();

    public abstract boolean topAppsListShowed();

    public abstract AptoideSeeMorePageBase goToSeeMore();

    }
