package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static final By LANGUAGES_LIST = By.xpath("//*[@id=\"icp-nav-flyout\"]/span");
    private static final By EN_LANG = By.xpath("//*[@id=\"icp-language-settings\"]/div[3]/div/label/i");
    private static final By SAVE_CHANGES_BTN = By.xpath("//*[@id=\"icp-save-button\"]/span/input");
    private static final By LOGIN_LINK = By.id("nav-link-accountList");
    private static final By YOUR_ORDERS = By.id("nav_prefetch_yourorders");
    private static final By YOUR_ADDRESSES = By.id("nav_prefetch_youraddresses");
    private static final By YOUR_LISTS = By.xpath("//*[@id=\"nav-al-your-account\"]/a[4]");//*[@id="wishlist-page"]/div[1]/div[1]/div/span[1]
    private static final By ALL_TAPS = By.id("nav-hamburger-menu");
    private static final By TODAY_DEALS = By.xpath("/html/body/div[3]/div[2]/div/ul[1]/li[17]/a");
    private static final By CART_ICON = By.id("nav-cart-count-container");
    private WebDriver driver;
    private WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void selectEnLanguage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LANGUAGES_LIST));
        driver.findElement(LANGUAGES_LIST).click();
        driver.findElement(EN_LANG).click();
        driver.findElement(SAVE_CHANGES_BTN).click();
    }

    public void makeHoverOnSignInLink() throws InterruptedException {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_LINK));
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(LOGIN_LINK)).perform();
    }

    public LoginPage clickOnSignIn() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_LINK));
        Thread.sleep(3000);
        driver.findElement(LOGIN_LINK).click();
        return new LoginPage(driver);
    }
    public void clickOnAllTapsIcon() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALL_TAPS));
        Thread.sleep(3000);
        driver.findElement(ALL_TAPS).click();
    }
    public TodayDeals selectTodayDealsFromAllTaps(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TODAY_DEALS));
        driver.findElement(TODAY_DEALS).click();
        return new TodayDeals(driver);
    }
    public Cart clickOnCartIcon(){
        driver.findElement(CART_ICON).click();
        return new Cart(driver);
    }

    public LoginPage clickOnYourOrders(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(YOUR_ORDERS));
        driver.findElement(YOUR_ORDERS).click();
        return new LoginPage(driver);
    }
    public LoginPage clickOnYourAddresses(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(YOUR_ADDRESSES));
        driver.findElement(YOUR_ADDRESSES).click();
        return new LoginPage(driver);
    }
    public Lists clickOnYourLists(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(YOUR_LISTS));
        driver.findElement(YOUR_LISTS).click();
        return new Lists(driver);
    }
    public void goBack(){
        driver.navigate().back();
    }


}
