package com.automation.tests;

import com.automation.appiumsupport.AppiumTestBase;
import com.automation.pageobjects.HomePage;
import org.junit.Assert;
import org.testng.annotations.Test;


public class TC002_VerifyHomePageDetailsMobile extends BaseTestMobile {

    protected HomePage homePage;
    String pageURL = "https://www.qumu.com/en/";


    @Test
    public void verifyHomePageTitle() {
        //("=========== Starting verifyHomePageTitle Test=============")

        //Verify that correct page is displayed
        //check the text retrieved matches expected value

        Assert.assertEquals(true, AppiumTestBase.instance.getPageURL().equals(pageURL));
        Assert.assertEquals(true, AppiumTestBase.instance.getPageTitle().contains("Qumu"));


        //("=========== Finished verifyHomePageTitle Test=============")
    }

}

