package com.automation.websupport;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class WebTestBase {

    public static WebDriver driver;

    public WebDriver getDriver() {

        return driver;
    }


    public WebTestBase(){

        this.driver = driver;
    }

    /**
     * This method initializes browser object
     *
     * @param browser
     * @return browser driver
     */
    public static WebDriver startBrowser(String browser) {
        if (null=="firefox" || browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.firefox.marionette","/Users/rashmisagarsen/IdeaProjects/jars_n_execs/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            return driver;
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.out.println("chrome browser");
            System.setProperty("webdriver.chrome.driver", "/Users/rashmisagarsen/IdeaProjects/jars_n_execs/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }
        return driver;
    }

    public static void getUrl(String url){
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

