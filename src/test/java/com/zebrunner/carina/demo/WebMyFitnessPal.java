package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.myfitnesspal.MyFitnessPalHomePage;
import com.zebrunner.carina.demo.gui.pages.myfitnesspal.MyFitnessPalLogInPage;
import com.zebrunner.carina.demo.gui.pages.myfitnesspal.MyFitnessPalSignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WebMyFitnessPal implements IAbstractTest {

    @Test(description = "Validate Sign Up, create account")
    @MethodOwner(owner = "emir")
    public void vlaidateSignUp(){
        WebDriver driver = getDriver();

        MyFitnessPalHomePage homePage = new MyFitnessPalHomePage(driver);
        homePage.open();

        MyFitnessPalLogInPage logInPage = homePage.goToLoginPage();

        MyFitnessPalSignUpPage signUpPage = logInPage.goToSignUp();



    }

}
