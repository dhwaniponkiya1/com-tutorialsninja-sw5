package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    TopMenuPage topMenuPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        topMenuPage = new TopMenuPage();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        topMenuPage.mouseHoverOnDesktopAndClick();        //mouse hover and click on desktop

        Thread.sleep(2000);
        topMenuPage.selectMenu("Show AllDesktops");        //click on show all desktop
        Assert.assertEquals(topMenuPage.getDesktopHeading(), "Desktops");       //Verifying heading
    }

    @Test(groups = { "smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        topMenuPage.mouseHoverOnLaptopsAndNotebookAndClick();        //mouse hover and click on laptop and notebook
        topMenuPage.selectMenu("Show AllLaptops & Notebooks");      //click on Show All Laptops & Notebooks
        Assert.assertEquals(topMenuPage.getLaptopANdNotebookHeading(), "Laptops & Notebooks");       //Verifying heading
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        topMenuPage.mouseHoverOnComponentsAndClick();        //mouse hover and click on Components
        topMenuPage.selectMenu("Show AllComponents");      //click on Show AllComponents
        Assert.assertEquals(topMenuPage.getComponentsHeading(), "Components");       //Verifying heading
    }




}
