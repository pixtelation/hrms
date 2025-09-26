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
        options.setExperimentalOption("debuggerAddress", "localhost:53478");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         try {
        // If getting window size works, the session probably already has a state
        driver.manage().window().getSize();
        System.out.println("🔹 Browser already running, skip maximize()");
    } catch (Exception e) {
        // If getSize() fails, it's likely a new session
        driver.manage().window().maximize();
        System.out.println("✅ Browser launched fresh, maximized window");
    }


         // ✅ Detect package and pick URL
        String packageName = this.getClass().getPackage().getName();

        String targetUrl;
        if (packageName.contains("SuperAdminTest")) {
            targetUrl = ConfigReader.getProperty("SuperAdminURL");
        } else if (packageName.contains("TenentTest")) {
            targetUrl = ConfigReader.getProperty("TenentAdminURL");
        } else {
            throw new RuntimeException("No URL configured for: " + packageName);
        }

        // ✅ Navigate or refresh
        String currentUrl = "";
        try {
            currentUrl = driver.getCurrentUrl();
        } catch (Exception ignored) {}

        if (!currentUrl.startsWith(targetUrl)) {
            driver.get(targetUrl);
        } else {
            driver.navigate().refresh();
        }
    }
        // // driver.get(SaUrl);             ///////////////////SuperAdmin
        //  driver.get(TaUrl);           //////////////////Tenent(hrms is name of tenent in url)
    }

    // @AfterClass
    // public void teardown() {
    //     driver.quit();
    // }
    

