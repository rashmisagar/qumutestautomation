package com.automation.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;

import static org.junit.Assert.*;


public class DemoAppiumTest {

    public DemoAppiumTest(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    //Create instance for Appium Driver
    AppiumDriver driver;
    URL url;

    @FindBy(xpath = "//*[@id='logo-container-mobile']/div[2]/div")
    public MobileElement navElement;

    @FindBy(xpath = "//*[@id='masthead']/div/div/div/div[2]/div/div/div[2]/ul/li")
    public MobileElement searchElement;

    @FindBy(xpath = "/html/body/div[4]/div[2]/form/div/input")
    public MobileElement searchInputField;

    @FindBy(xpath = "//*[@id='index-191444']/div/div/div[1]/div/div/div/div/h3/a")
    public MobileElement firstSearchResult;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        /*capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.1.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, "https://www.qumu.com/en/");*/
        //capabilities.setCapability("avd", "Test");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");


        try {
            //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new IOSDriver(url, capabilities);
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }

    };

    @Test
    public void SimpleTest() throws InterruptedException {
        //Assert.assertNotNull(driver.getContext());
        // Navigate to the page and interact with the elements on the guinea-pig page using id.
        driver.get("https://www.qumu.com/en");
        //WebElement div = driver.findElement(By.id("i_am_an_id"));
        Assert.assertEquals(true, driver.getTitle().contains("Qumu")); //check the text retrieved matches expected value
        //driver.findElement(By.id("comments")).sendKeys("My comment"); //populate the comments field by id.
        //driver.get("http://saucelabs.com/test/guinea-pig");
        //Thread.sleep(1000);
        //WebElement navElement = driver.findElement(By.className("mobile-menu-button mobile-menu-button-dark lines-button x2"));
        //navElement.click();
        //Thread.sleep(1000);
        //WebElement searchElement = driver.findElement(By.className("fa fa-search3"));
        //searchElement.click();
        //Thread.sleep(1000);
        //assertNotNull(idElement);
        //assertEquals("I am a div", idElement.getText());
        //WebElement searchInputElement = driver.findElement(By.id("comments"));
        //searchInputElement.sendKeys("qumu");
        //searchInputElement.click();
        //Thread.sleep(1000);
        //assertNotNull(commentElement);
        //commentElement.sendKeys("This is an awesome comment");
        /*WebElement submitElement = driver.findElement(By.id("submit"));
        assertNotNull(submitElement);
        submitElement.click();
        Thread.sleep(7000);
        WebElement yourCommentsElement = driver.findElement(By.id("your_comments"));
        assertNotNull(yourCommentsElement);
        assertTrue(driver.findElement(By.id("your_comments")).getText().contains("This is an awesome comment"));*/

        //System.out.println(driver.getCurrentUrl());
    }


}



