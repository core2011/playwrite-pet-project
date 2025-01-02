package org.example.pages;

import com.microsoft.playwright.Page;
import lombok.Data;
import org.example.utils.ScreenshotHook;


@Data
public abstract class BasePage {

    protected Page page;
    protected ScreenshotHook screenshotHook;

    public BasePage() {
    }

    public BasePage(Page page) {
        this.page = page;
    }

    protected final String FIND_BUTN = "//*[@name='search-cta']//*[contains(@class, 'aeo-icon-search')]";
    protected final String FIND_BUTN_SIDE = "//*[@name='submit']//*[contains(@class, 'aeo-icon-search')]";

    public void clickFindBtn() {
        page.click(FIND_BUTN);
    }

    public void clickFindBtnSite() {
        page.click(FIND_BUTN_SIDE);
    }

    public void takeScreenshot(String scenarioName) {
        ScreenshotHook.takeScreenshot(this.page, scenarioName);
    }
}
