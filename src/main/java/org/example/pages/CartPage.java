package org.example.pages;

import com.microsoft.playwright.Page;

public class CartPage extends BasePage {

    private final String HEADER_PAGE = "//*[contains(@class, 'page-header') and text()='Shopping Bag']";
    private final String FIRST_PRODUCT_NAME = "//h3[contains(@class, 'cart-item-name')]//a[contains(@class, 'product-link')]";

    public CartPage(Page page) {
        super(page);
    }

    public boolean verifyUserOnCartPage() {
        return page.locator(HEADER_PAGE).isVisible();
    }

    public void scrollToElement() {
        page.locator(FIRST_PRODUCT_NAME).scrollIntoViewIfNeeded();
    }

    public String getFirstProductName() {
        return page.locator(FIRST_PRODUCT_NAME).innerText();
    }
}
