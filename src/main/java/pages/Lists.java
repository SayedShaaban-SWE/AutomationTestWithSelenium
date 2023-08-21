package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lists {
    private static final By LISTS_PAGE_TITLE = By.xpath("//*[@id=\"wishlist-page\"]/div[1]/div[1]/div/span[1]");
    private WebDriver driver;
    private WebDriverWait wait;
    public Lists(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getListsPageTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LISTS_PAGE_TITLE));
        return driver.findElement(LISTS_PAGE_TITLE).getText();
    }
}
