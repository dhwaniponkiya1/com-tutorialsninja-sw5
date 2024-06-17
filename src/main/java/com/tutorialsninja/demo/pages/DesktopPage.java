package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByDropdown;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts;

    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement quantityTextBox;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successAlertMsg;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement cartLinkInMsg;

    public void selectFromSortByDropdown(String value) {
        selectByVisibleTextFromDropDown(sortByDropdown, value);
    }

    public List<String> getListOfProducts() {
        List<WebElement> products = listOfProducts;
        List<String> originalProductList = new ArrayList<>();
        try {
            for (WebElement list : products) {
                System.out.println(list.getText());
                originalProductList.add(list.getText());
            }
        } catch (StaleElementReferenceException e) {
        }
        return originalProductList;
    }

    public void clickOnProduct(String product) {
        List<WebElement> products = listOfProducts;
        List<String> productList = new ArrayList<>();
        for (WebElement e : products) {
            if (e.getText().equalsIgnoreCase(product)) {
                e.click();
                break;
            }
        }

        Reporter.log("Click on " + product);
        CustomListeners.test.log(Status.PASS, "Click on " + product);
    }

    public void enterQuantity(String qty) {
        quantityTextBox.clear();
        sendTextToElement(quantityTextBox, qty);
        Reporter.log("update " + qty);
        CustomListeners.test.log(Status.PASS, "update " + qty);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
        Reporter.log("Click on " + addToCartButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + addToCartButton);
    }

    public String getSuccessAlertMsg() {
        Reporter.log("Get " + successAlertMsg.toString());
        CustomListeners.test.log(Status.PASS, "Get " + successAlertMsg);
        return getTextFromElement(successAlertMsg);
    }

    public void clickOnCartLinkInMsgButton() {
        clickOnElement(cartLinkInMsg);
        Reporter.log("Click on " + cartLinkInMsg.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + cartLinkInMsg.toString());
    }

}
