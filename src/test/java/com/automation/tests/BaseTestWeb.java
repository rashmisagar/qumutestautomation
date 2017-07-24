package com.automation.tests;

import com.automation.pageobjects.HomePageWeb;
import com.automation.websupport.WebTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTestWeb extends WebTestBase{

    protected WebDriver driver;
    protected WebDriverWait wait;


    public static String browserType="firefox";
    public static String url="https://www.qumu.com/en/";
    private String searchWord = "qumu";



    @BeforeClass
    public void setUp() throws IOException {
        driver = getDriver();
        driver = startBrowser(browserType);
        getUrl(url);
        //driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15, 50);
        //clearSessionAndCookies();

    }

    @AfterClass
    public void endTest(){
        driver.close();
    }
}

