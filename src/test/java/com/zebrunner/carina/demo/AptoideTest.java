package com.zebrunner.carina.demo;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.mobile.gui.pages.android.aptoide.AptoideStoreProfilePage;
import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.*;
import com.zebrunner.carina.demo.utils.apium.App;
import com.zebrunner.carina.demo.utils.apium.Store;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AptoideTest implements IAbstractTest, IMobileUtils {

    @Test(description = "Checking the Bottom Navigation Bar")
    @TestLabel(name = "feature", value = {"mobile", "regression","aptoide"})
    public void bottomNavigationBarTest(){
        AptoideHomePageBase homePage = initPage(getDriver(), AptoideHomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not open");

         AptoideEditorialPageBase editorialPage = homePage.navigateToEditorial();
         Assert.assertTrue(editorialPage.isPageOpened(),"Editorial page is not open");

        AptoideSearchPageBase searchPage = editorialPage.navigateToSearch();
        Assert.assertTrue(searchPage.isPageOpened(),"Search page is not open");

        AptoideStorePageBase storePage = searchPage.navigateToStore();
        Assert.assertTrue(storePage.isPageOpened(),"Store page is not open");

        homePage = storePage.navigateToHome();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not open");

    }

    @Test(description = "Search for an application and validate results")
    @TestLabel(name = "feature", value = {"mobile", "regression","aptoide"})
    public void searchAnAppTest(){

        AptoideHomePageBase homePage = initPage(getDriver(), AptoideHomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not open");

        AptoideSearchPageBase searchPage = homePage.navigateToSearch();

        String query = "PUBG";
        AptoideResultsPageBase resultsPage = searchPage.searchAnApp(query);
        List<App> results = resultsPage.getApps();

        boolean anyMatch = results.stream().anyMatch(app->app.getName().contains(query));

        Assert.assertTrue(anyMatch,"There is no any result which match with app searched");

        AptoideInstallationPageBase installationPage = resultsPage.goToInstallFirstSuggestion();

        Assert.assertTrue(installationPage.isPageOpened(),"Installation page is not open");

        Assert.assertTrue(installationPage.getAppInfo().getName().contains(query),"App name does not contain the search query used");


    }


    @Test(description = "Check all elements from home page")
    @TestLabel(name = "feature", value = {"mobile", "regression","aptoide"})
    public void checkHomePageElements(){
        AptoideHomePageBase homePage = initPage(getDriver(),AptoideHomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not open");

        homePage.checkGamesCheckBox();

        Assert.assertTrue(homePage.gamesCheckBoxIsChecked(),"Game checkbox is not selected");
        Assert.assertTrue(homePage.topGamesListShowed(),"Top Games list was not showed");

        homePage.checkAppsCheckBox();

        Assert.assertTrue(homePage.appsCheckBoxIsChecked(),"Apps checkbox is not selected");
        Assert.assertTrue(homePage.topAppsListShowed(),"Top Apps list was not showed");
        Assert.assertFalse(homePage.gamesCheckBoxIsChecked(),"Game checkbox is still selected");

        homePage.checkAppsCheckBox();
        Assert.assertFalse(homePage.appsCheckBoxIsChecked(),"Apps checkbox is still selected");

        AptoideSeeMorePageBase seeMorePage = homePage.goToSeeMore();

        Assert.assertTrue(seeMorePage.isPageOpened(),"See More Page is not open");

        homePage = seeMorePage.goBackToHomePage();

        Assert.assertTrue(homePage.isPageOpened(),"Home page is not open");

    }

    @Test(description = "Check all elements from editorial page")
    @TestLabel(name = "feature", value = {"mobile", "regression","aptoide"})
    public void checkEditorialPageElements(){
        AptoideHomePageBase homePage = initPage(getDriver(),AptoideHomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not open");

        AptoideEditorialPageBase editorialPage = homePage.navigateToEditorial();
        Assert.assertTrue(editorialPage.isPageOpened(),"Editorial page is not open");

        App firstAppResult = editorialPage.getResults().get(0);

        AptoideGameInfoPageBase gameInfoPage = editorialPage.goToFirstGameInfo();
        Assert.assertTrue(gameInfoPage.isPageOpened(),"Editorial app Info page is not open");

        Assert.assertEquals(gameInfoPage.getAppInfo().getName(),firstAppResult.getName(),"App names are not equals");

        editorialPage = gameInfoPage.goBack();
        Assert.assertTrue(editorialPage.isPageOpened(),"Editorial page is not open");
    }

    @Test(description = "Check all elements from Store page")
    @TestLabel(name = "feature", value = {"mobile", "regression","aptoide"})
    public void checkStorePageElements(){

        AptoideHomePageBase homePage = initPage(getDriver(),AptoideHomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not open");

        AptoideStorePageBase storePage = homePage.navigateToStore();
        Assert.assertTrue(storePage.isPageOpened(),"Store page is not open");

        Store firstFollowedStores = storePage.getFollowedStores().get(0);

        AptoideStoreProfilePageBase storeFollowedProfilePage = storePage.goToFirstFollowedStore();
        Assert.assertTrue(storeFollowedProfilePage.isPageOpened(),"Store followed profile is not open");
        Assert.assertTrue(storeFollowedProfilePage.isFollowing(),"Store followed is not followed");

        Assert.assertEquals(storeFollowedProfilePage.getStoreProfileInfo().getName(),firstFollowedStores.getName(),"First store followed selected name is not the same in Store Profile");

        storeFollowedProfilePage.clickFollowButton();
        Assert.assertFalse(storeFollowedProfilePage.isFollowing(),"Store unfollowed is followed");

        storePage = storeFollowedProfilePage.goBackToStoresPage();
        Assert.assertTrue(storePage.isPageOpened(),"Store page is not open");

        storePage.getFollowedStores().forEach(store -> {
            Assert.assertNotEquals(store.getName(),firstFollowedStores.getName(),"Store unfollowed is still followed");
        });

        Store firstRecommendedStores = storePage.getRecommendedStores().get(0);

        AptoideStoreProfilePageBase storeRecommendedProfilePage = storePage.goToFirstRecommendedStore();
        Assert.assertTrue(storeRecommendedProfilePage.isPageOpened(),"Store Recommended Profile is not open");
        Assert.assertFalse(storeRecommendedProfilePage.isFollowing(),"Store recommended to follow is followed");

        Assert.assertEquals(storeRecommendedProfilePage.getStoreProfileInfo().getName(),firstRecommendedStores.getName(),"First store recommended selected name is not the same in Store Profile");

        storeRecommendedProfilePage.clickFollowButton();
        Assert.assertTrue(storeRecommendedProfilePage.isFollowing(),"Store followed is still unfollowed");

        storePage = storeRecommendedProfilePage.goBackToStoresPage();

        Assert.assertTrue(storePage.isPageOpened(),"Store page is not open");

        storePage.getFollowedStores().forEach(store -> {
            if(store.getName().equals(firstRecommendedStores.getName())){
                Assert.assertEquals(store.getName(),firstRecommendedStores.getName(),"Store followed is still unfollowed");
            }
        });

        boolean storeRecommendedIsInFollow = storePage.getFollowedStores().stream().anyMatch(store -> store.getName().equals(firstRecommendedStores.getName()));

        Assert.assertTrue(storeRecommendedIsInFollow,"Store recommended to follow who was followed si not in followed stores");


    }
}
