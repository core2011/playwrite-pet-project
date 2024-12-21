package org.example.pages;

import com.microsoft.playwright.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.utils.Config;

@Data
@AllArgsConstructor
public class HomePage extends BasePage {

    private static final String ACCEPT_COOKIE_BUTTON_ID = "#onetrust-accept-btn-handler";
    private static final String FIND_BTN = ".aeo-icon-search";
    private static final String FIND_TEXT_FIELD = ".form-input-search";

    private Page page;

    public void acceptCookieButtonId(){
        page.click(ACCEPT_COOKIE_BUTTON_ID);
    }

    public void clickFindBtn(){
        page.click(FIND_BTN);
    }





}
