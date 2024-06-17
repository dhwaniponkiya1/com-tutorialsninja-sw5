package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.CartPage;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.Collections;
import java.util.List;

public class DesktopsTest extends BaseTest {

    DesktopPage desktopPage;
    TopMenuPage topMenuPage;
    HomePage homePage;
    CartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        desktopPage = new DesktopPage();
        topMenuPage = new TopMenuPage();
        homePage = new HomePage();
        cartPage = new CartPage();
    }


    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        topMenuPage.mouseHoverOnDesktopAndClick();      //CLick on desktop
        topMenuPage.selectMenu("Show AllDesktops");        //click on show all desktop
        List<String> beforeSorting = desktopPage.getListOfProducts();
        desktopPage.selectFromSortByDropdown("Name (Z - A)");       //select filter from sort by
        Collections.sort(beforeSorting, Collections.reverseOrder(String::compareToIgnoreCase));

        List<String> afterSorting = desktopPage.getListOfProducts();
        System.out.println(afterSorting);
        Assert.assertEquals(afterSorting, beforeSorting);

    }


    @Test(groups = {"smoke", "regression"}, dataProvider = "desktopData", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty,
                                                             String successMessage, String productName, String model, String total) throws InterruptedException {

        homePage.clickOnCurrency();      //click on currency dropdown
//        desktopPage.selectPoundCurrency();      //select pound currency
        topMenuPage.mouseHoverOnDesktopAndClick();      //CLick on desktop
        topMenuPage.selectMenu("Show AllDesktops");        //click on show all desktop
        desktopPage.selectFromSortByDropdown("Name (A - Z)");       //select filter from sort by
        desktopPage.clickOnProduct(product);        //click on product
        desktopPage.enterQuantity(qty);         // update qty
        desktopPage.clickOnAddToCartButton();       //click on add to cart
        Thread.sleep(2000);


        String expString = desktopPage.getSuccessAlertMsg();
        String expString2 = expString.split("!")[0];
        Assert.assertEquals(expString, "Success: You have added " + product + " to your shopping cart!\n"+"×");
        desktopPage.clickOnCartLinkInMsgButton();
        Assert.assertEquals(cartPage.getShoppingCartHeading().substring(0,13), "Shopping Cart");     //verifying shopping cart headding
        Assert.assertEquals(cartPage.getProductName(), product);     //verifying product name headding
        Assert.assertEquals(cartPage.getModelName(), model);     //verifying model name headding
        Assert.assertEquals(cartPage.getTotalPrice(), total);     //verifying total price headding
    }


}
