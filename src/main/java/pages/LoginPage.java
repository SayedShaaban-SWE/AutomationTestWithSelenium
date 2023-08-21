package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private static final By LOGIN_TXT = By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div[2]/div[1]/form/div/div/div/h1");
    private static final By EMAIL_INPUT_FIELD = By.id("ap_email");
    private static final By CONTINUE_BTN = By.id("continue");
    private static final By Error_MSG = By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span");
    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getLoginTxt(){
        return driver.findElement(LOGIN_TXT).getText();
    }

    public void sendEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT_FIELD));
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys(email);
    }
    public HomePage clickOnContinue(){
        driver.findElement(CONTINUE_BTN).click();
        return new HomePage(driver);
    }
    public String getErrorMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Error_MSG));
        return driver.findElement(Error_MSG).getText();
    }
}
