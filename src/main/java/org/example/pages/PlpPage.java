package org.example.pages;

import com.microsoft.playwright.Page;

public class PlpPage extends BasePage {

    private final String PRODUCT_NAME = "//*[contains(@class, 'product-name')]";
    private final String FIRST_PRODUCT_ON_PAGE = "//*[@data-product-id]";

    public PlpPage(Page page) {
        super(page);
    }

    public String getTextProductName() {
        return page.locator(PRODUCT_NAME).textContent().trim();
    }

    public void clickOnFirstProduct(){
        page.click(FIRST_PRODUCT_ON_PAGE);
    }

}
