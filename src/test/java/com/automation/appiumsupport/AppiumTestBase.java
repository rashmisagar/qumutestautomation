package com.automation.appiumsupport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;


public class AppiumTestBase {

    public static OS executionOS = OS.IOS;
    URL url;

    public enum OS {
        ANDROID,
        IOS
    }
    public static AppiumTestBase instance = new AppiumTestBase();
    public AppiumDriver driver;

    protected AppiumDriver driver() {

        return AppiumTestBase.instance.driver;
    }

    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        switch(executionOS){
            case ANDROID:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.1.0");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                //capabilities.setCapability("avd", "Test");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                try {
                    url = new URL("http://127.0.0.1:4723/wd/hub");
                    driver = new AndroidDriver(url, capabilities);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case IOS:
                capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.1.0");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
                try {
                    url = new URL("http://127.0.0.1:4723/wd/hub");
                    driver = new IOSDriver(url, capabilities);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        goToPageURL("https://www.qumu.com/en/");
    }


    public void goToPageURL(String pageURL) {

        driver.get(pageURL);
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void goToSearchResultsPage(String text) {

        driver.get("https://www.qumu.com/en/?s=" + text);
    }

    protected boolean isTextPresent(String text){
        try{
            boolean b = driver.getPageSource().contains(text);
            return b;
        }
        catch(Exception e){
            return false;
        }
    }

    public String getFirstSearchResult() {

        String firstSearchResult = driver.findElement(By.xpath("//*[@id='index-191444']/div/div/div[1]/div/div/div/div")).getText();
        return firstSearchResult;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

