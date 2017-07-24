package com.automation.tests;


import com.automation.appiumsupport.AppiumTestBase;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.HomePageAndroid;
import com.automation.pageobjects.HomePageIOS;
import org.testng.annotations.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.Test;


public class TC003_SearchHomePageTestMobile extends BaseTestMobile {


    protected String searchWord = "Qumu";


    @Test
    public void searchText(){

        //Search for text
        AppiumTestBase.instance.goToSearchResultsPage(searchWord);

        //Verify result
        String firstSearchResult = AppiumTestBase.instance.getFirstSearchResult();
        Assert.assertEquals(true, firstSearchResult.contains(searchWord));

    }

}
