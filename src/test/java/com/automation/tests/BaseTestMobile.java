package com.automation.tests;

import com.automation.appiumsupport.AppiumTestBase;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.HomePageAndroid;
import com.automation.pageobjects.HomePageIOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;



public class BaseTestMobile extends AppiumTestBase{

    protected HomePage homePage;

    @BeforeClass
    public void setUp() throws Exception {
        AppiumTestBase.instance.start();
        switch (AppiumTestBase.executionOS) {
            case ANDROID:
                homePage = new HomePageAndroid(driver());
                break;
            case IOS:
                homePage = new HomePageIOS(driver());
                break;
        }
    }

    @AfterClass
    public void tearDown() {

        AppiumTestBase.instance.stop();
    }
}
