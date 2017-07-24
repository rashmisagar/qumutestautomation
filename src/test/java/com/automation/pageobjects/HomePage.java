package com.automation.pageobjects;

import org.openqa.selenium.WebElement;

/**
 * Created by rashmisagarsen on 20/07/2017.
 */
public interface HomePage {

    public void search(String text);

    public String getFirstSearchResult();
}
