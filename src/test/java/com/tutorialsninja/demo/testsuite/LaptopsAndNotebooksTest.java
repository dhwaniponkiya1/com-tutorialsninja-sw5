package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends BaseTest {

    TopMenuPage topMenuPage;
    HomePage homePage;
    CartPage cartPage;
    DesktopPage desktopPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    CheckoutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        topMenuPage = new TopMenuPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        desktopPage = new DesktopPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        checkoutPage = new CheckoutPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        topMenuPage.mouseHoverOnLaptopsAndNotebookAndClick();       //mouse hover and click on laptops and notebooks
        topMenuPage.selectMenu("Show AllLaptops & Notebooks");      //mouse hover and click on laptops and notebooks

        List<Double> beforeSorting = laptopsAndNotebooksPage.getPriceList();
        desktopPage.selectFromSortByDropdown("Price (High > Low)");         //select by price filter
        Collections.sort(beforeSorting, Collections.reverseOrder());

        List<Double> afterSorting = laptopsAndNotebooksPage.getPriceList();
        System.out.println(afterSorting);
        Assert.assertEquals(afterSorting, beforeSorting);
    }

    @Test(groups = { "smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        topMenuPage.mouseHoverOnLaptopsAndNotebookAndClick();
        topMenuPage.selectMenu("Show AllLaptops & Notebooks");
        desktopPage.selectFromSortByDropdown("Price (High > Low)");
        laptopsAndNotebooksPage.clickOnProduct("Sony VAIO");
        Assert.assertEquals(laptopsAndNotebooksPage.getSonyVAIOHeading(), "Sony VAIO");
        desktopPage.clickOnAddToCartButton();

        String expString = desktopPage.getSuccessAlertMsg();
        String expString2 = expString.split("!")[0];
        Assert.assertEquals(expString, "Success: You have added Sony VAIO to your shopping cart!\n"+"×");
        desktopPage.clickOnCartLinkInMsgButton();
        Assert.assertEquals(cartPage.getShoppingCartHeading().substring(0,13), "Shopping Cart");     //verifying shopping cart headding
        Assert.assertEquals(cartPage.getProductName(), "Sony VAIO");     //verifying product name heading
        cartPage.sendQty("2");        //change qty to 2
        cartPage.clickOnUpdateQty();        //click on update qty
        Assert.assertEquals(cartPage.getSuccessCartUpdateMsg(), "Success: You have modified your shopping cart!\n"+"×");      //verify message
        Assert.assertEquals(cartPage.getTotalPrice(),"$2,404.00");      //verify total price
        cartPage.clickOnCheckOut();         //click on checkout
        Thread.sleep(2000);
        Assert.assertEquals(checkoutPage.getNewCustHeading(), "New Customer");      //verify heading

        checkoutPage.clickOnGuestRadio();           //click on guest radio
        checkoutPage.clickOnCheckoutOptContButton();        //click on continue button
        checkoutPage.fillBillingFormDetails("Prime","Testing","p123@gmail.com","07833662976"
        ,"44, Region street", "London", "B44JUH", "United Kingdom","Kent");     //fill details and submit
        checkoutPage.clickOnDelMethodContButton();          // click on delivery method continue button
        checkoutPage.clickOnAgreeTermsCheckbox();           // click on agree terms checkbox
        checkoutPage.clickOnPaymentMethodCont();            // click on continue

    }


}
