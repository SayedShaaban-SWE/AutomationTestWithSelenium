package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class TodayDeals {
    private static final By TODAY_DEALS = By.xpath("//*[@id=\"slot-2\"]/div/h1");
    private static final By AUTOMOTIVE_CATEGORY = By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[2]/label/input");
    private static final By FIRST_PRODUCT = By.xpath("//*[@id=\"grid-main-container\"]/div[3]/div/div[1]/div/div/a/div");
    private static final By SECOND_ITEM = By.xpath("//*[@id=\"octopus-dlp-asin-stream\"]/ul/li[2]/span/div/div[1]/a/div");
    private static final By QTY_LIST = By.id("quantity");
    private static final By ADD_TO_CART_BTN = By.id("add-to-cart-button");

    private WebDriver driver;
    private WebDriverWait wait;
    public TodayDeals(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getTodayDealsTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TODAY_DEALS));
        return driver.findElement(TODAY_DEALS).getText();
    }

    public void selectAutomotiveCategory() throws InterruptedException {
        Thread.sleep(3000);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AUTOMOTIVE_CATEGORY);
        driver.findElement(AUTOMOTIVE_CATEGORY).click();
    }
    public void selectFirstProduct(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_PRODUCT));
        driver.findElement(FIRST_PRODUCT).click();
    }
    public void selectSecondItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SECOND_ITEM));
        driver.findElement(SECOND_ITEM).click();
    }
    public void select2FromQtyList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(QTY_LIST));
        driver.findElement(QTY_LIST).click();
        new Select(driver.findElement(QTY_LIST)).selectByVisibleText("2 ");
    }
    public String getQtyValue(){
        return new Select(driver.findElement(QTY_LIST)).getFirstSelectedOption().getText();
    }
    public HomePage clickOnAddToCartBtn(){
        driver.findElement(ADD_TO_CART_BTN).click();
        return new HomePage(driver);
    }
}
