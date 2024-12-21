package org.example.pages;

import com.microsoft.playwright.Page;

public class BasePage {

    public void fillText(Page page, String locator, String text){
        page.fill(locator, text);
    }

}
