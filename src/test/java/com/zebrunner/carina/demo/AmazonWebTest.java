package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.components.mycomponents.CartProduct;
import com.zebrunner.carina.demo.gui.components.mycomponents.ProductItem;
import com.zebrunner.carina.demo.gui.pages.mypages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AmazonWebTest implements IAbstractTest {

    @Test(description = "Validating Sign in")
    @MethodOwner(owner = "emir")
    public void validSignInTest(){
        SoftAssert softAssert = new SoftAssert();

        AmazonPageWithoutSession homePage = new AmazonPageWithoutSession(getDriver());

        //Open Home Page
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened");

        //Open Sign In Page
        AmazonSignInPage signInPage = homePage.goToSignPage();

        softAssert.assertEquals(signInPage.getTitle(),"Sign in","Sign In Page Title is not correct");

        //Enter account info to sign in and sign in
        AmazonPageWithSession homePageWithSession = signInPage.signIn("eeborbonjimenez@laba.solvd.com","eeborbonjimenez@laba.solvd.com");

        Assert.assertTrue(homePageWithSession.isPageOpened(),"Home Page with session is not opened");
        softAssert.assertEquals(homePageWithSession.getWelcomeMessageWithUserName(),"Hello, Solvd","Welcome to user failed");

        softAssert.assertAll();
    }

    @Test(description = "Validating Sign out")
    @MethodOwner(owner = "emir")
    public void validSignOutTest(){
        //Sign In
        AmazonSignInPage signInPage = new AmazonSignInPage(getDriver());
        signInPage.open();
        AmazonPageWithSession homePageWithSession = signInPage.signIn("eeborbonjimenez@laba.solvd.com","eeborbonjimenez@laba.solvd.com");

        SoftAssert softAssert = new SoftAssert();

        //Show Account Options
        homePageWithSession.showAccountOptions();

        softAssert.assertEquals(homePageWithSession.getSignOutText(),"Sign Out","Sign Out option has wrong text");

        //Select SignOut option
        AmazonSignInPage signInPageRedirected = homePageWithSession.signOut();

        Assert.assertTrue(signInPageRedirected.isPageOpened(),"Sign out redirection is wrong");

        softAssert.assertAll();
    }

    @Test(description = "Validating Sing In with incorrect data")
    @MethodOwner(owner = "emir")
    public void validSignInInDataTest(){
        SoftAssert softAssert = new SoftAssert();

        AmazonSignInPage signInPage = new AmazonSignInPage(getDriver());
        signInPage.open();

        softAssert.assertEquals(signInPage.getTitle(),"Sign in","Sign In Page Title is not correct");

        //SignIn with nonexistent email
        signInPage.enterEmailOrPhoneNumber("ee@laba.solvd.com");

        String invalidEmailMessage = signInPage.getAuthErrorMessage();

        Assert.assertEquals(invalidEmailMessage,"We cannot find an account with that email address","Error message does not match with invalid Email error");

        //SignIn with invalid password
        signInPage.enterEmailOrPhoneNumber("eeborbonjimenez@laba.solvd.com");
        signInPage.enterPassword("123");

        //Get Page Title should be "Authentication required" page
        String pageTitle = signInPage.getPageTitle();


        //IDK why it does not find the h1 :(, I tried to make an assert with it
//        System.out.println("URL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        System.out.println(getDriver().getCurrentUrl());
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));
//        System.out.println(getDriver().findElement(By.tagName("h1")).getText());

        Assert.assertEquals(pageTitle,"Authentication required","Did not redirect to Authentication Page");


    }

    @Test(description = "Validating Product data with Product data page")
    @MethodOwner(owner = "emir")
    public void validProductDataCardWithProductDataPage(){
        WebDriver driver = getDriver();

        AmazonPageWithoutSession pageWithoutSession = new AmazonPageWithoutSession(driver);
        pageWithoutSession.open();

        String product = "juegos";
        AmazonProductsFoundPage productsFoundPage = pageWithoutSession.searchProduct(product);

        int productIndex = 1;

        String cardPrice = productsFoundPage.getProductPrice(productIndex);
        String cardName = productsFoundPage.getProductName(productIndex);
        AmazonProductPage productPage = productsFoundPage.goToProductPage(productIndex);

        Assert.assertEquals(cardPrice,productPage.getProductPrice(),"Product Price is not equals in Card and Page");
        Assert.assertEquals(cardName,productPage.getProductTitle(),"Product Name is not equals in Card and Page");

    }

    @Test(description = "Validating Add Products to the cart and validate total amount")
    @MethodOwner(owner = "emir")
    public void validAddingProductsToCart(){
        WebDriver driver = getDriver();
        AmazonSignInPage signInPage = new AmazonSignInPage(driver);
        signInPage.open();
        AmazonPageWithSession homePageWithSession = signInPage.signIn("eeborbonjimenez@laba.solvd.com","eeborbonjimenez@laba.solvd.com");

        homePageWithSession.open();

        String product1 = "juegos";
        int productToSelect = 1;
        AmazonProductsFoundPage productsFoundPage = homePageWithSession.searchProduct(product1);
        AmazonProductPage productPage = productsFoundPage.goToProductPage(productToSelect);
        String price1 = productPage.getProductPrice();

        AmazonPageWithSession pageWithSession2 = productPage.addToCart();

        String product2 = "juegos";
        AmazonProductsFoundPage productsFoundPage2 = pageWithSession2.searchProduct(product2);
        AmazonProductPage productPage2 = productsFoundPage2.goToProductPage(productToSelect+1);
        String price2 = productPage2.getProductPrice();
        AmazonPageWithSession home = productPage2.addToCart();

        Double total = Double.parseDouble(price1)+ Double.parseDouble(price2);

        AmazonCartPage cartPage = home.goToCart();

        Assert.assertEquals(total,cartPage.getSubTotal(),"Products total amount is not equals");

    }

    @Test(description = "Validating Remove Products from the cart and validate total amount")
    @MethodOwner(owner = "emir")
    public void validateRemoveProductFromCartTest(){
        WebDriver driver = getDriver();
        AmazonSignInPage signInPage = new AmazonSignInPage(driver);
        signInPage.open();
        AmazonPageWithSession homePageWithSession = signInPage.signIn("eeborbonjimenez@laba.solvd.com","eeborbonjimenez@laba.solvd.com");

        AmazonCartPage cartPage = homePageWithSession.goToCart();

        String productName1 = cartPage.getCartProducts().get(0).getProductName();
        Double productPrice1 = cartPage.getCartProducts().get(0).getProductPrice();
        String productName2 = cartPage.getCartProducts().get(1).getProductName();
        Double productPrice2 = cartPage.getCartProducts().get(1).getProductPrice();

        Double firstSubTotal = cartPage.getSubTotal();
        Double expectedNextSubtotal = firstSubTotal-productPrice1-productPrice2;
        expectedNextSubtotal = Double.parseDouble(String.format("%.2f", expectedNextSubtotal));

        cartPage.removeProductFromCart(0);
        cartPage.removeProductFromCart(1);

        Double newSubTotal = cartPage.getSubTotal();

        List<CartProduct> products = cartPage.getCartProducts();

        for(CartProduct p: products){
            Assert.assertNotEquals(p.getProductName(),productName1,"Product was not deleted");
            Assert.assertNotEquals(p.getProductName(),productName2,"Product was not deleted");
        }

        Assert.assertNotEquals(firstSubTotal,newSubTotal,"SubTotal did not chance");
        Assert.assertEquals(newSubTotal,expectedNextSubtotal,"New SubTotal expected is wrong");

    }

}
