package com.zebrunner.carina.demo.mobile.gui.pages.android.aptoide;

import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideResultsPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideSearchPageBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;

import java.net.URL;

@DeviceType(pageType = Type.ANDROID_PHONE,parentClass = AptoideSearchPageBase.class)
public class AptoideSearchPage extends AptoideSearchPageBase implements IAndroidUtils {

    @FindBy(id = "search_src_text")
    ExtendedWebElement searchBar;

    @FindBy(id = "trending_list")
    ExtendedWebElement trendingList;

    public AptoideSearchPage(WebDriver driver){
        super(driver);
    }


    @Override
    public AptoideResultsPageBase searchAnApp(String appName) {
        searchBar.type(appName);
        pressKeyboardKey(AndroidKey.ENTER);
        return initPage(getDriver(),AptoideResultsPageBase.class);
    }


    @Override
    public boolean isPageOpened() {
        return trendingList.isElementPresent();
    }
}
