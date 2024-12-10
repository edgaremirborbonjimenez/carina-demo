package com.zebrunner.carina.demo.mobile.gui.pages.android.aptoide;

import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideEditorialPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.aptoide.AptoideGameInfoPageBase;
import com.zebrunner.carina.demo.utils.apium.App;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

@DeviceType(pageType = Type.ANDROID_PHONE,parentClass = AptoideEditorialPageBase.class)
public class AptoideEditorialPage extends AptoideEditorialPageBase {

    @FindBy(id = "editorial_list")
    ExtendedWebElement editorialList;

    @Context(dependsOn = "editorialList")
    @FindBy(id = "editorial_title")
    List<ExtendedWebElement> results;

    public AptoideEditorialPage(WebDriver driver){
        super(driver);
    }

    @Override
    public AptoideGameInfoPageBase goToFirstGameInfo() {
        results.get(0).click();
        return initPage(getDriver(), AptoideGameInfoPageBase.class);
    }

    @Override
    public List<App> getResults() {
        List<App> appList = new LinkedList<>();
        results.forEach(a->{
            App app = new App();
            app.setName(a.getText());
            appList.add(app);
        });
        return appList;
    }

    @Override
    public boolean isPageOpened() {
        return editorialList.isElementPresent();
    }
}
