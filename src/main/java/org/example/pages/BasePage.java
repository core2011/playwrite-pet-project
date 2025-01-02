package org.example.pages;

import com.microsoft.playwright.Page;
import lombok.Data;


@Data
public abstract class BasePage {

    protected Page page;

    public BasePage() {
    }

    public BasePage(Page page) {
        this.page = page;
    }

    protected final String FIND_BUTN = "//*[@name='search-cta']//*[contains(@class, 'aeo-icon-search')]";
    protected final String FIND_BUTN_SIDE = "//*[@name='submit']//*[contains(@class, 'aeo-icon-search')]";

    public void clickFindBtn(){
        page.click(FIND_BUTN);
    }

    public void clickFindBtnSite(){
        page.click(FIND_BUTN_SIDE);
    }
}
