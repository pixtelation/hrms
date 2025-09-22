package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import org.testng.annotations.*;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        ConfigReader.loadConfig();

         String SaUrl = ConfigReader.getProperty("SuperAdminURL");
         String TaUrl = ConfigReader.getProperty("TenentAdminURL");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:64453");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // driver.manage().window().maximize();
        driver.get(SaUrl);             ///////////////////SuperAdmin
        // driver.get(TaUrl);           //////////////////Tenent(hrms is name of tenent in url)
    }

    // @AfterClass
    // public void teardown() {
    //     driver.quit();
    // }
    
}
