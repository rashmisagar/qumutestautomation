package com.automation.pageobjects;

import com.automation.websupport.WebTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageWeb extends WebTestBase{


    public HomePageWeb(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Actions action;
    private WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(xpath = "//*[@id='masthead']/div/div/div/div[2]/div/div/div[2]/ul/li/a/i[1]")
    public WebElement searchElement;

    @FindBy(name = "s")
    public WebElement searchInputField;

    @FindBy(xpath = "//*[@id='index-191444']/div/div/div[1]/div/div/div/div/h3/a")
    public WebElement firstSearchResultName;


    public void searchText(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='masthead']/div/div/div/div[2]/div/div/div[2]/ul/li/a/i[1]")));
        searchElement.click();
        searchInputField.sendKeys(text);
        searchInputField.click();
    }

    public WebElement getFirstSearchResult() {
        return firstSearchResultName;
    }
}
