package org.example.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.utils.Config;

import java.util.Arrays;

public class Steps {

    private HomePage homePage;
    private Config config;

    @Given("guest user on the home page")
    public void givenGuestUserOnHomePage() {
        this.config = new Config();
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(Arrays.asList("--no-sandbox", "--disable-gpu")));
        Page page = browser.newPage();
        homePage = new HomePage(page);
        page.navigate(config.getSiteUrl("site.url"));
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    @When("user accept cookies")
    public void whenUserAcceptCookies() {
        homePage.acceptCookieButtonId();
    }


    @Then("user find {string}")
    public void userFindItem(String item) {
        homePage.clickFindBtn();

        homePage.clickFindBtn();
    }
}
