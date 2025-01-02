package org.example.pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    private static final String ACCEPT_COOKIE_BUTTON_ID = "#onetrust-accept-btn-handler";
    private static final String FIND_TEXT_FIELD = ".form-input-search";

    public HomePage(Page page) {
        super(page);
    }

    public void acceptCookieButtonId() {
        page.click(ACCEPT_COOKIE_BUTTON_ID);
    }

    public void fillTextInFindField(String item) {
        page.fill(FIND_TEXT_FIELD, item);
    }


}
