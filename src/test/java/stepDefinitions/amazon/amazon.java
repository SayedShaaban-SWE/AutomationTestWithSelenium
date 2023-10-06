package stepDefinitions.amazon;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import com.applitools.eyes.selenium.fluent.Target;

import static org.junit.jupiter.api.Assertions.*;
import static stepDefinitions.Hooks.driver;
import static stepDefinitions.Hooks.eyes;
public class amazon {
    public HomePage homePage = new HomePage(driver);
    public LoginPage loginPage = new LoginPage(driver);
    public TodayDeals todayDeals = new TodayDeals(driver);
    public Cart cart = new Cart(driver);
    public Lists lists = new Lists(driver);

    @When("I click on sign in button at the top right corner")
    public void clickOnSignIn() throws InterruptedException {
        homePage.clickOnSignIn();
    }

    @Then("I should navigated to the Sign in screen")
    public void iShouldNavigatedToTheSignInScreen() {
        assertTrue(loginPage.getLoginTxt().contains("Sign in"));
        eyes.check(Target.window());
    }

    @When("I enter valid email but not registered like {string}")
    public void iEnterValidEmailButNotRegisteredLike(String email) {
        loginPage.sendEmail(email);
    }

    @And("I click on continue button")
    public void iClickOn() {
        loginPage.clickOnContinue();
    }

    @Then("I should see error message as {string}")
    public void iShouldSeeErrorMessageAs(String errorMsg) {
        assertTrue(loginPage.getErrorMsg().contains(errorMsg));
    }

    @Given("I select english from languages list")
    public void iSelectEnglishFromLanguagesList(){
        homePage.selectEnLanguage();

    }

    @When("I click on All tab icon")
    public void iClickOnAllTabIcon() throws InterruptedException {
        homePage.clickOnAllTapsIcon();
    }

    @And("I select \"Today's Deals\"")
    public void iSelect() {
        homePage.selectTodayDealsFromAllTaps();
    }

    @Then("I should be navigated to {string} page")
    public void iShouldBeNavigatedToPage(String todayDealsTitle) {
        assertEquals(todayDealsTitle,todayDeals.getTodayDealsTitle());
    }

    @When("I click on 2nd category from categories list")
    public void iClickOnNdCategoryFromCategoriesList() throws InterruptedException {
        todayDeals.selectAutomotiveCategory();
    }

    @And("I click on 1st product in this category")
    public void iClickOnStProductInThisCategory() {
        todayDeals.selectFirstProduct();
    }

    @And("I click on 2nd item in this product")
    public void iClickOnNdItemInThisProduct() {
        todayDeals.selectSecondItem();
    }

    @And("I add it to cart with Qty = 2")
    public void iAddItToCartWithQty() {
        todayDeals.select2FromQtyList();
    }

    @And("I do all the necessary actions to add the item to the cart")
    public void iDoAllTheNecessaryActionsToAddTheItemToTheCart() {
        todayDeals.clickOnAddToCartBtn();
    }

    @And("I go to the cart")
    public void iGoToTheCart() {
        homePage.clickOnCartIcon();
    }

    @Then("I should see items are added to the cart with details name, price, qty and subtotal is correct")
    public void iShouldSeeItemsAreAddedToTheCartWithDetailsNamePriceQtyAndSubtotalIsCorrect() {
        assertTrue(cart.isProductNameDisplayed());
        assertTrue(cart.isProductPriceDisplayed());
        assertTrue(cart.isProductSubtotalDisplayed());
        assertEquals("2",todayDeals.getQtyValue());
    }

    @When("I click on “Hello, sign in Account & Lists” at the top right corner")
    public void iClickOnHelloSignInAccountListsAtTheTopRightCorner() throws InterruptedException {
        homePage.makeHoverOnSignInLink();
    }

    @And("I select “Your orders”")
    public void iSelectYourOrders() {
        homePage.clickOnYourOrders();
    }

    @When("I click on back arrow")
    public void iClickOnBackArrow() {
        homePage.goBack();
    }

    @And("I select “Your Addresses”")
    public void iSelectYourAddresses() {
        homePage.clickOnYourAddresses();
    }

    @And("I select “Your Lists”")
    public void iSelectYourLists() {
        homePage.clickOnYourLists();
    }

    @Then("I should navigated to lists page")
    public void iShouldNavigatedToListsPage() {
        assertTrue(lists.getListsPageTitle().contains("Lists"));
    }
}
