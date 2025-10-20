package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;
// import org.testng.annotations.AfterSuite;   // keep commented so browser stays open

import Pages.SuperAdminPage.SuperAdminLogin;
import Pages.TenentPage.TenentAdminLogin;
import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch {

    private static WebDriver driver;
    private static boolean isBrowserStarted = false;
    private static boolean isLoggedIn = false;
    private static final String DEBUG_PORT = "53478";    // fixed debug port

    static {
        // load config properties once
        ConfigReader.loadConfig();

        // ⚡ for faster launch, set local ChromeDriver path if you have it
        // System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");

        // fallback: still use WebDriverManager if no local path set
        if (System.getProperty("webdriver.chrome.driver") == null) {
            WebDriverManager.chromedriver().setup();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    public static void setLoggedIn(boolean value) {
        isLoggedIn = value;
    }

    /** 🚀 ONLY ATTACH: Attempts to attach to an already running Chrome instance. */
    @BeforeSuite(alwaysRun = true)
    public void ensureBrowserIsRunning() {
        if (isBrowserStarted) return;

        try {
            // ONLY try to attach to existing Chrome
            ChromeOptions attach = new ChromeOptions();
            attach.setExperimentalOption("debuggerAddress", "localhost:" + DEBUG_PORT);
            driver = new ChromeDriver(attach);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            // The previous conflicting maximize command is intentionally removed here
            // because the browser is already launched maximized by LaunchOnly.java.
            
            isBrowserStarted = true;
            System.out.println("🔗 Attached to existing persistent Chrome on port " + DEBUG_PORT);
        } catch (Exception e) {
            // Fail fast and inform the CI/CD user that the persistent browser is missing
            System.err.println("❌ CRITICAL ERROR: Failed to attach to Chrome on port " + DEBUG_PORT);
            System.err.println("The persistent browser session must be launched externally (e.g., using LaunchOnly.java) BEFORE running tests.");
            throw new RuntimeException("Persistent browser session required but not found or reachable.", e);
        }
    }

    /** 🌍 Navigate to correct URL before each test class */
    @BeforeClass(alwaysRun = true)
    public void navigateToCorrectUrl() {
        if (driver == null) {
            // Safe guard to ensure the driver is initialized
            ensureBrowserIsRunning();
        }

        // decide URL based on package name
        String pkg = this.getClass().getPackage().getName();
        String targetUrl;
        if (pkg.contains("SuperAdminTest")) {
            targetUrl = ConfigReader.getProperty("SuperAdminURL");
        } else if (pkg.contains("TenentTest")) {
            targetUrl = ConfigReader.getProperty("TenentAdminURL");
        } else {
            throw new RuntimeException("No URL configured for: " + pkg);
        }

        try {
            // Check current URL to avoid unnecessary navigation
            if (!driver.getCurrentUrl().startsWith(targetUrl)) {
                driver.get(targetUrl);
            }
        } catch (UnreachableBrowserException e) {
            // If the browser lost connection, try getting the URL again.
            driver.get(targetUrl);
        }

        System.out.println("🌍 Navigated to: " + targetUrl);
    }

    // -----------------------------------------------------------------
    // 👤 LOGIN HELPERS
    // -----------------------------------------------------------------
    public static void loginAsSuperAdmin() {
        if (isLoggedIn) return;

        SuperAdminLogin sa = new SuperAdminLogin(getDriver());
        sa.enterEmail(ConfigReader.getProperty("superadmin_email"));
        sa.enterPassword(ConfigReader.getProperty("superadmin_password"));
        sa.clickLogin();

        setLoggedIn(true);
        System.out.println("🔑 Logged in as SuperAdmin.");
    }

    public static void loginAsTenentAdmin() {
        if (isLoggedIn) return;

        TenentAdminLogin ta = new TenentAdminLogin(getDriver());
        ta.TenentEmailfnx(ConfigReader.getProperty("tenant_email"));
        ta.TenentPasswordfnx(ConfigReader.getProperty("tenant_password"));
        ta.TenentLoginbtn();

        setLoggedIn(true);
        System.out.println("🔑 Logged in as Tenant Admin.");
    }

    // -----------------------------------------------------------------
    // ❌ Leave browser open (no teardown)
    // -----------------------------------------------------------------
    /*
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("❌ Browser closed after suite.");
        }
    }
    */
}