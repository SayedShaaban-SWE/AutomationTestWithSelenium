package stepDefinitions;

import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.selenium.Eyes;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Hooks {
    public static WebDriver driver;
    public static Eyes eyes;
    public static Properties prop;

    @Before
    public void setUpDriver(){
//        String driverPath=System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver",driverPath);
//        driver=new ChromeDriver();
        /**Set up Appli tools eyes for visual testing**/
        eyes= new Eyes();
        eyes.setLogHandler(new StdoutLogHandler());

        // to Get values from the properties file
        prop = new Properties();
        FileInputStream input = null;
        try {
//             Load the properties file
            input = new FileInputStream("src/main/resources/config.properties");
            prop.load(input);
            String appliToolsApiKey = prop.getProperty("APPLITOOLS_API_KEY");
            eyes.setApiKey(appliToolsApiKey);
            if (prop.getProperty("browserName").equals("chrome")){
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
            }else if (prop.getProperty("browserName").equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
            }else if (prop.getProperty("browserName").equals("edge")){
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
            }

            eyes.open(driver,
                    "My first Test",
                    "Amazon test"
            );
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        driver.navigate().to("https://www.amazon.eg/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        eyes.closeAsync();
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
