package com.automation.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertNotNull;


public class HomePageAndroid implements HomePage {

    public HomePageAndroid(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//*[@id='logo-container-mobile']/div[2]/div")
    public MobileElement navElement;

    @FindBy(xpath = "//*[@id='masthead']/div/div/div/div[2]/div/div/div[2]/ul/li")
    public MobileElement searchElement;

    @FindBy(xpath = "/html/body/div[4]/div[2]/form/div/input")
    public MobileElement searchInputField;

    @FindBy(xpath = "//*[@id='index-191444']/div/div/div[1]/div/div/div/div/h3/a")
    public MobileElement firstSearchResult;

    //@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
    //public MobileElement firstSearchResultName;


    public void search(String text) {
        assertNotNull(navElement);
        getNavElement().click();
        assertNotNull(searchElement);
        getSearchElement().click();
        assertNotNull(searchInputField);
        getSearchInputField().sendKeys(text);
        getSearchInputField().sendKeys(Keys.ENTER);
    }

    public MobileElement getNavElement() {
        return navElement;
    }

    public MobileElement getSearchElement() {
        return searchElement;
    }

    public MobileElement getSearchInputField() {
        return navElement;
    }

    public String getFirstSearchResult() {

        assertNotNull(firstSearchResult);
        return firstSearchResult.getText();
    }
}