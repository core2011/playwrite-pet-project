package org.example.pages;

import com.microsoft.playwright.Page;

public class PdpPage extends BasePage{

    private final String FIRST_NO_OOS_SIZE = "(//*[@role='menuitem' and not(./*[@class='text-muted'])])[1]";
    private final String CHOOSE_SIZE = "//*[contains(@class, 'qa-select-size')]";
    private final String BTN_ADD_TO_BAG = "//button[@data-test-btn='addToBag']";
    private final String BTN_VIEW_BAG = "//*[@data-test-btn='viewBag']";

    public PdpPage(Page page) {
        super(page);
    }

    public void clickOnMegaMenuSize(){
        page.click(CHOOSE_SIZE);
    }

    public void choseFirstSize(){
        page.click(FIRST_NO_OOS_SIZE);
    }

    public boolean verifyBtnPresent(){
        return page.locator(BTN_ADD_TO_BAG).isVisible();
    }

    public void clickOnAddToBagBtn(){
        page.click(BTN_ADD_TO_BAG);
    }

    public void clickOnViewBagBtn(){
        page.click(BTN_VIEW_BAG);
    }

}
