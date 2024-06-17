package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Currency']")
    WebElement currencyLink;

    @CacheLookup
    @FindBy(xpath = "//button[@class='currency-select btn btn-link btn-block'][2]")
    WebElement poundLink;

    public void clickOnCurrency() {
        clickOnElement(currencyLink);
        clickOnElement(By.xpath("(//button[@class='currency-select btn btn-link btn-block'])[2]"));
        Reporter.log("Click on " + currencyLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + currencyLink.toString());
    }

    public void selectPoundCurrency() {
        clickOnElement(currencyLink);
        clickOnElement(poundLink);
        Reporter.log("Click on " + poundLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + poundLink.toString());
    }

    public void selectMyAccountOptions(String option){
        clickOnElement(By.xpath("//a[normalize-space()='" + option + "']"));
    }


}
