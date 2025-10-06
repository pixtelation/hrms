package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import Utils.ConfigReader; 

public class Launch {

    // IMPORTANT: This static ThreadLocal provides the *thread-safe* storage 
    // for the WebDriver instance. This is the crucial element for parallel execution.
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private static final String DEBUG_PORT = "53478"; 

    /**
     * Public access method to retrieve the WebDriver instance.
     * Your test classes will use this to interact with the browser.
     * * @return The WebDriver instance for the current thread.
     */
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    @BeforeSuite(alwaysRun = true)
    public void setupSuite() {
        ConfigReader.loadConfig();
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=" + DEBUG_PORT);

        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        // Store the newly created driver in the ThreadLocal
        tlDriver.set(driver);
        System.out.println("✅ Browser launched and configured with remote debugging port: " + DEBUG_PORT);
    }

    @BeforeClass(alwaysRun = true)
    public void navigateToUrl() {
        // We use the public getter method here and in all subsequent interactions
        WebDriver driver = getDriver(); 
        
        String packageName = this.getClass().getPackage().getName();
        String targetUrl;

        if (packageName.contains("SuperAdminTest")) {
            targetUrl = ConfigReader.getProperty("SuperAdminURL");
        } else if (packageName.contains("TenentTest")) {
            targetUrl = ConfigReader.getProperty("TenentAdminURL");
        } else {
            throw new RuntimeException("No URL configured for: " + packageName);
        }

        try {
            if (!driver.getCurrentUrl().startsWith(targetUrl)) {
                driver.get(targetUrl);
            }
        } catch (Exception e) {
            driver.get(targetUrl);
        }
    }

    // @AfterSuite(alwaysRun = true)
    // public void teardownSuite() {
    //     WebDriver driver = tlDriver.get();
    //     if (driver != null) {
    //         driver.quit();
    //         tlDriver.remove();
    //         System.out.println("❌ Browser closed after suite execution.");
    //     }
    // }
}