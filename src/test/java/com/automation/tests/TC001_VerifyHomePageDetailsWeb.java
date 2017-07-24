package com.automation.tests;

import com.automation.pageobjects.HomePageWeb;
import com.automation.websupport.WebTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.junit.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TC001_VerifyHomePageDetailsWeb extends BaseTestWeb{

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePageWeb homePageWeb;

    public static String browserType="firefox";
    public static String url="https://www.qumu.com";
    private String searchWord = "qumu";


    @Test
    public void verifyHomePageTitle() {
        //("=========== Starting verifyLoginWithValidCredentials Test=============")

        homePageWeb = PageFactory.initElements(driver, HomePageWeb.class);
        Assert.assertEquals(true, getPageTitle().contains("Qumu"));
        //("=========== Finished verifyLoginWithValidCredentials Test=============")
    }

}
