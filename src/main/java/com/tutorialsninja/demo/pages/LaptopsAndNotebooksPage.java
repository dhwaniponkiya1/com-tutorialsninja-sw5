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

public class LaptopsAndNotebooksPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//div[1]//div[2]//div[1]//p//span[@class='price-tax']")
    List<WebElement> listOfPrice;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Sony VAIO']")
    WebElement sonyHeading;

    public List<Double> getPriceList() {
        List<WebElement> prices = listOfPrice;
        List<Double> originalPriceList = new ArrayList<>();
        try {
            for (WebElement element : prices) {
                String price = element.getText().replaceAll("[E,x,T,a,x,:,$]", "").replace(",", "");
                Double priceValue = Double.parseDouble(price);
                originalPriceList.add(priceValue);
            }
            System.out.println(originalPriceList);
        } catch (StaleElementReferenceException e) {
        }
        return originalPriceList;
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

    public String getSonyVAIOHeading() {
        return getTextFromElement(sonyHeading);
    }



}
