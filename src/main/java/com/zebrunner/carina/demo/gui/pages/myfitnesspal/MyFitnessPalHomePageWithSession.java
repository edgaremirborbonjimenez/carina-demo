package com.zebrunner.carina.demo.gui.pages.myfitnesspal;

import com.zebrunner.carina.demo.gui.pages.myfitnesspal.components.MyFitnessPalHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyFitnessPalHomePageWithSession extends MyFitnessPalBasePage{

    @FindBy(tagName = "header")
    MyFitnessPalHeader header;

    public MyFitnessPalHomePageWithSession(WebDriver driver){
        super(driver);
        setUiLoadedMarker(header);
    }

    public String getUserName(){
        return header.getUserName();
    }

}
