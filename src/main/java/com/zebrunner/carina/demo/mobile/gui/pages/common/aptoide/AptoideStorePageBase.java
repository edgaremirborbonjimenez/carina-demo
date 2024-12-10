package com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide;

import com.zebrunner.carina.demo.utils.apium.Store;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AptoideStorePageBase extends AptoidePageBase{

    public AptoideStorePageBase(WebDriver driver){
        super(driver);
    }

    public abstract List<Store> getFollowedStores();

    public abstract List<Store> getRecommendedStores();

    public abstract AptoideStoreProfilePageBase goToFirstFollowedStore();

    public abstract AptoideStoreProfilePageBase goToFirstRecommendedStore();

}
