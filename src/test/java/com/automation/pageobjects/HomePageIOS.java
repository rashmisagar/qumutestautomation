package com.automation.pageobjects;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertNotNull;

public class HomePageIOS implements HomePage{

    public HomePageIOS(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIASearchButton[1]")
    public MobileElement navElement;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIASearchButton[1]/UIASearchBar[1]")
    public MobileElement searchElement;

    @FindBy(className = "search-field no-livesearch")
    public MobileElement searchInputField;

    @FindBy(xpath = "//*[@id='index-191444']/div/div/div[1]/div/div/div/div")
    public MobileElement firstSearchResult;

    //@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
    //public MobileElement firstSearchResultName;


    public void search(String text) {
        getNavElement().click();
        getSearchElement().click();
        getSearchInputField().sendKeys(text);
        getSearchInputField().sendKeys(Keys.ENTER);
    }

    public MobileElement getNavElement(){
        assertNotNull(navElement);
        return navElement;
    }

    public MobileElement getSearchElement(){
        assertNotNull(searchElement);
        return searchElement;
    }

    public MobileElement getSearchInputField(){
        assertNotNull(searchInputField);
        return navElement;
    }

    public String getFirstSearchResult() {

        assertNotNull(firstSearchResult);
        return firstSearchResult.getText();
    }


}
