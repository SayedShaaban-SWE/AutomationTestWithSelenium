package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {
    private static final By PRODUCT_NAME = By.xpath("/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/li[1]/span/a/span[1]/span/span[2]");
    private static final By PRODUCT_PRICE = By.xpath("/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/div/div/div[1]/p/span");
    private static final By PRODUCT_SUBTOTAL = By.xpath("/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[3]/span[2]/span");


    private WebDriver driver;
    private WebDriverWait wait;
    public Cart(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean isProductNameDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_NAME));
        return driver.findElement(PRODUCT_NAME).isDisplayed();
    }
    public boolean isProductPriceDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_PRICE));
        return driver.findElement(PRODUCT_PRICE).isDisplayed();
    }
    public boolean isProductSubtotalDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_SUBTOTAL));
        return driver.findElement(PRODUCT_SUBTOTAL).isDisplayed();
    }


}
