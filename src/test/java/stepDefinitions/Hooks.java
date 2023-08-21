package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUpDriver(){
        String driverPath=System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver=new ChromeDriver();
        driver.navigate().to("https://www.amazon.eg/");
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            try {
                Files.write(Path.of("screenshots/"+"FailedScreenshot "+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".png"), screenshot);
                Allure.addAttachment("FailedScenarioScreenshot",new ByteArrayInputStream(screenshot));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
