package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class TopMenuPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//li//a")
    List<WebElement> topMenu;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Desktops']")
    WebElement deskTopLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsAndNoteLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Components']")
    WebElement componentsLink;

    @CacheLookup
    @FindBy(xpath = "//h2[text()='Desktops']")
    WebElement deskTopHeading;

    @CacheLookup
    @FindBy(xpath = "//h2[text()='Laptops & Notebooks']")
    WebElement laptopsAndNoteHeading;

    @CacheLookup
    @FindBy(xpath = "//h2[text()='Components']")
    WebElement componentsHeading;


    public void selectMenu(String menu) {
        List<WebElement> topMenuElements = topMenu;
        for (WebElement e : topMenuElements) {
            if (e.getText().equalsIgnoreCase(menu)) {
                e.click();
                break;
            }
        }
    }

    public void mouseHoverOnDesktopAndClick() {
        mouseHoverToElementAndClick(deskTopLink);
        Reporter.log("Click on " + deskTopLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + deskTopLink.toString());
    }

    public String getDesktopHeading() {
        Reporter.log("get " + deskTopHeading.toString());
        CustomListeners.test.log(Status.PASS, "get " + deskTopHeading.toString());
        return getTextFromElement(deskTopHeading);
    }

    public void mouseHoverOnLaptopsAndNotebookAndClick() {
        mouseHoverToElementAndClick(laptopsAndNoteLink);
        Reporter.log("Click on " + laptopsAndNoteLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + laptopsAndNoteLink.toString());
    }

    public String getLaptopANdNotebookHeading() {
        Reporter.log("get " + laptopsAndNoteHeading.toString());
        CustomListeners.test.log(Status.PASS, "get " + laptopsAndNoteHeading.toString());
        return getTextFromElement(laptopsAndNoteHeading);
    }

    public void mouseHoverOnComponentsAndClick() {
        mouseHoverToElementAndClick(componentsLink);
        Reporter.log("Click on " + componentsLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on " + componentsLink.toString());
    }

    public String getComponentsHeading() {
        Reporter.log("get " + componentsHeading.toString());
        CustomListeners.test.log(Status.PASS, "get " + componentsHeading.toString());
        return getTextFromElement(componentsHeading);
    }


}
