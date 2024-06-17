package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountsTest extends BaseTest {

    TopMenuPage topMenuPage;
    HomePage homePage;
    CartPage cartPage;
    DesktopPage desktopPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    CheckoutPage checkoutPage;
    MyAccountsPage myAccountsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        topMenuPage = new TopMenuPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        desktopPage = new DesktopPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        checkoutPage = new CheckoutPage();
        myAccountsPage = new MyAccountsPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.selectMyAccountOptions("My Account");      //click on my account
        homePage.selectMyAccountOptions("Register");        //click on register
        Assert.assertEquals(myAccountsPage.getRegAccHeading(), "Register Account");         //verify heading
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.selectMyAccountOptions("My Account");      //click on my account
        homePage.selectMyAccountOptions("Login");        //click on login
        Assert.assertEquals(myAccountsPage.getLoginHeading(), "Returning Customer");         //verify heading
    }

    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {
        homePage.selectMyAccountOptions("My Account");      //click on my account
        homePage.selectMyAccountOptions("Register");        //click on register
        myAccountsPage.fillRegistrationData("Prime", "Testing", "p345@gmail.com", "07833662976", "Prime@123", "Prime@123");
        myAccountsPage.getRegConfirmText();
        myAccountsPage.clickOnContAfterRegButton();         //click on continue button

        homePage.selectMyAccountOptions("My Account");      //click on my account
        homePage.selectMyAccountOptions("Logout");        //click on Logout

        Assert.assertEquals(myAccountsPage.getLogoutConfirmMsg(), "Account Logout");         //verifying logout
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.selectMyAccountOptions("My Account");      //click on my account
        homePage.selectMyAccountOptions("Login");        //click on login
        myAccountsPage.fillLoginData("p345@gmail.com", "Prime@123");
        Assert.assertEquals(myAccountsPage.getAfterLoginHeading(), "My Account");         //verifying login
        homePage.selectMyAccountOptions("My Account");      //click on my account
        homePage.selectMyAccountOptions("Logout");        //click on Logout
        Assert.assertEquals(myAccountsPage.getLogoutConfirmMsg(), "Account Logout");         //verifying logout
        myAccountsPage.clickOnContAfterRegButton();         //click continue button
    }

}
