package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckoutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustHeading;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestRadio;

    @CacheLookup
    @FindBy(id = "button-account")
    WebElement checkoutOptContButton;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement fNameField;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lNameField;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement mobileField;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address1Field;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement cityField;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postcodeField;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryField;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement stateField;

    @CacheLookup
    @FindBy(id = "button-guest")
    WebElement billingDetailsContButton;

    @CacheLookup
    @FindBy(id = "button-shipping-method")
    WebElement delMethodContButton;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agreeTermsCheckbox;

    @CacheLookup
    @FindBy(id = "button-payment-method")
    WebElement paymentMethodContButton;


    public String getNewCustHeading() {
        Reporter.log("Get " + newCustHeading.toString());
        CustomListeners.test.log(Status.PASS, "Get " + newCustHeading);
        return getTextFromElement(newCustHeading);
    }

    public void clickOnGuestRadio() {
        Reporter.log("click on " + guestRadio.toString());
        CustomListeners.test.log(Status.PASS, "click on " + guestRadio);
        clickOnElement(guestRadio);
    }

    public void clickOnCheckoutOptContButton() {
        Reporter.log("click on " + checkoutOptContButton.toString());
        CustomListeners.test.log(Status.PASS, "click on " + checkoutOptContButton);
        clickOnElement(checkoutOptContButton);
    }

    public void fillBillingFormDetails(String fName, String lName, String email, String mobile
            , String add1, String city, String postCode, String country, String state) {
        sendTextToElement(fNameField, fName);
        sendTextToElement(lNameField, lName);
        sendTextToElement(emailField, email);
        sendTextToElement(mobileField, mobile);
        sendTextToElement(address1Field, add1);
        sendTextToElement(cityField, city);
        sendTextToElement(postcodeField, postCode);
        selectByVisibleTextFromDropDown(countryField, country);
        selectByVisibleTextFromDropDown(stateField, state);
        clickOnElement(billingDetailsContButton);
    }

    public void clickOnDelMethodContButton() {
        Reporter.log("click on " + delMethodContButton.toString());
        CustomListeners.test.log(Status.PASS, "click on " + delMethodContButton);
        clickOnElement(delMethodContButton);
    }

    public void clickOnAgreeTermsCheckbox() {
        Reporter.log("click on " + agreeTermsCheckbox.toString());
        CustomListeners.test.log(Status.PASS, "click on " + agreeTermsCheckbox);
        clickOnElement(agreeTermsCheckbox);
    }

    public void clickOnPaymentMethodCont() {
        Reporter.log("click on " + paymentMethodContButton.toString());
        CustomListeners.test.log(Status.PASS, "click on " + paymentMethodContButton);
        clickOnElement(paymentMethodContButton);
    }


}
