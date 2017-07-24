package com.automation.tests;

import com.automation.pageobjects.HomePageWeb;
import com.automation.websupport.WebTestBase;
import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TC004_SearchHomePageTestWeb extends BaseTestWeb{


    private String searchWord = "Qumu";


    @Test
    public void searchHomePage() throws InterruptedException{
        wait = new WebDriverWait(driver, 30);
        WebElement searchElement = driver.findElement(By.xpath("//*[@id='masthead']/div/div/div/div[2]/div/div/div[2]/ul/li"));
        assertNotNull(searchElement);
        searchElement.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[2]/form/div/input")));
        WebElement searchInput = driver.findElement(By.xpath("/html/body/div[4]/div[2]/form/div/input"));
        assertNotNull(searchInput);
        searchInput.sendKeys(searchWord);
        searchInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='index-191444']/div/div/div[1]/div/div/div/div/h3/a")));
        WebElement searchResult = driver.findElement(By.xpath("//*[@id='index-191444']/div/div/div[1]/div/div/div/div/h3/a"));
        assertNotNull(searchResult);
        Assert.assertEquals(true, searchResult.getText().contains(searchWord));
    }


}
