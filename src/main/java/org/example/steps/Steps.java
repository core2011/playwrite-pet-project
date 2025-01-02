package org.example.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.PdpPage;
import org.example.pages.PlpPage;
import org.example.utils.Config;
import org.example.utils.ScenarioContext;
import org.example.utils.ScreenshotHook;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class Steps {

    private Page page;
    private HomePage homePage;
    private PlpPage plpPage;
    private PdpPage pdpPage;
    private CartPage cartPage;
    private ScenarioContext context;

    public Steps() {
        context = new ScenarioContext();
    }

    @BeforeAll
    public static void beforeAll() {
        ScreenshotHook.cleanScreenshotsFolder();
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotHook.takeScreenshot(this.page, scenario.getName());
        }
    }

    @Given("guest user on the home page")
    public void givenGuestUserOnHomePage() {
        Config config = new Config();
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(Arrays.asList("--no-sandbox", "--disable-gpu")));
        page = browser.newPage();
        homePage = new HomePage(page);
        page.navigate(config.getSiteUrl("site.url"));
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    @When("user accept cookies")
    public void whenUserAcceptCookies() {
        homePage = new HomePage(page);
        homePage.acceptCookieButtonId();
    }

    @Then("user find {string}")
    public void userFindItem(String item) {
        homePage.clickFindBtn();
        homePage.fillTextInFindField(item);
        homePage.clickFindBtnSite();
    }

    @Then("verify product name {string}")
    public void verifyProductName(String expectTextNameItem) {
        context.setContext("itemName", expectTextNameItem);
        plpPage = new PlpPage(page);
        String actualTextProductName = plpPage.getTextProductName();
        Assertions.assertEquals(expectTextNameItem, actualTextProductName);
    }

    @Then("click on the item and verify user on PDP page")
    public void clickOnTheItemAndVerifyUserOnPDPPage() {
        pdpPage = new PdpPage(page);
        plpPage.clickOnFirstProduct();
        pdpPage.verifyBtnPresent();
    }

    @Then("choose first not OOS size")
    public void chooseFirstNotOOSSize() {
        pdpPage.clickOnMegaMenuSize();
        pdpPage.choseFirstSize();
    }

    @And("click on Add to bag button")
    public void clickOnButton() {
        pdpPage.clickOnAddToBagBtn();
    }

    @Then("verify user on the cart page")
    public void verifyUserOnTheCartPage() throws InterruptedException {
        cartPage = new CartPage(page);
        Thread.sleep(5000);
        boolean userOnCartPage = cartPage.verifyUserOnCartPage();
        Assertions.assertTrue(userOnCartPage);
    }

    @When("scroll to the item on cart page")
    public void scrollToTheItemOnCartPage() {
        cartPage.scrollToElement();
    }

    @And("click on View Bag button")
    public void clickOnViewBagButton() {
        pdpPage.clickOnViewBagBtn();
    }

    @When("compare the selected item name with the cart item name")
    public void compareTheSelectedItemNameWithTheCartItemName() {
        String itemNameFromContext = context.getContext("itemName").toString();
        String itemNameFromPage = cartPage.getFirstProductName();
        Assertions.assertEquals(itemNameFromContext, itemNameFromPage );
    }

    @And("take screenshot cart")
    public void takeScreenshotCart() {
        ScreenshotHook.takeScreenshot(this.page,  "take screenshot cart step");
    }
}
