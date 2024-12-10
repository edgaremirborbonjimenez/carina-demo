package com.zebrunner.carina.demo.mobile.gui.pages.android.aptoide;

import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideInstallationPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideResultsPageBase;
import com.zebrunner.carina.demo.utils.apium.App;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = AptoideResultsPageBase.class)
public class AptoideResultsPage extends AptoideResultsPageBase {

    public static final int waiting = 10;

    @FindBy(id = "fragment_search_result_all_stores_app_list")
    ExtendedWebElement allResults;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"cm.aptoide.pt:id/app_name\"]")
    List<ExtendedWebElement> results;

    public AptoideResultsPage(WebDriver driver){
        super(driver);
    }

    public List<App> getApps(){
        List<App> appsList = new LinkedList<>();
        allResults.isElementPresent();
        results.forEach(item->{
            App app = new App();
            app.setName(item.getText());
            appsList.add(app);
        });
        return  appsList;
    }

    @Override
    public AptoideInstallationPageBase goToInstallFirstSuggestion() {
        results.get(0).click();
        return initPage(getDriver(),AptoideInstallationPageBase.class);
    }
}
