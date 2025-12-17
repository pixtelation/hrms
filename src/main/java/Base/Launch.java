package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;

import Pages.SuperAdminPage.SuperAdminLogin;
import Pages.TenentPage.TenentAdminLogin;
import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch {

    private static WebDriver driver;
    private static boolean isBrowserStarted = false;
    private static boolean isLoggedIn = false;

    static {
        ConfigReader.loadConfig();
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

    /** 🚀 Browser bootstrap */
    @BeforeSuite(alwaysRun = true)
    public void ensureBrowserIsRunning() {

        if (isBrowserStarted) return;

        boolean isCI = System.getenv("CI") != null;
        String DEBUG_PORT = ConfigReader.getProperty("port");

        try {
            ChromeOptions options = new ChromeOptions();

            if (isCI) {
                // 🤖 CI → fresh browser
                System.out.println("🤖 CI detected → starting fresh browser");
            } else {
                // 🧑‍💻 LOCAL → attach to persistent browser
                options.setExperimentalOption(
                    "debuggerAddress", "localhost:" + DEBUG_PORT
                );
                System.out.println("🔗 Local run → attaching to persistent browser on port " + DEBUG_PORT);
            }

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            if (isCI) {
                driver.manage().window().maximize();
            }

            isBrowserStarted = true;

        } catch (Exception e) {
            throw new RuntimeException(
                "❌ Failed to initialize browser. " +
                "If running locally, ensure LaunchSessionBrowser is running.",
                e
            );
        }
    }

    /** 🌍 Navigate to correct domain */
    @BeforeClass(alwaysRun = true)
    public void navigateToCorrectUrl() {

        if (driver == null) {
            ensureBrowserIsRunning();
        }

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
            if (!driver.getCurrentUrl().startsWith(targetUrl)) {
                driver.get(targetUrl);
            }
        } catch (UnreachableBrowserException e) {
            driver.get(targetUrl);
        }

        System.out.println("🌍 Navigated to: " + targetUrl);
    }

    // ---------------- LOGIN HELPERS ----------------

    public static void loginAsSuperAdmin() {
        if (isLoggedIn) return;

        SuperAdminLogin sa = new SuperAdminLogin(driver);
        sa.enterEmail(ConfigReader.getProperty("superadmin_email"));
        sa.enterPassword(ConfigReader.getProperty("superadmin_password"));
        sa.clickLogin();

        isLoggedIn = true;
        System.out.println("🔑 Logged in as SuperAdmin");
    }

    public static void loginAsTenentAdmin() {
        if (isLoggedIn) return;

        TenentAdminLogin ta = new TenentAdminLogin(driver);
        ta.TenentEmailfnx(ConfigReader.getProperty("tenant_email"));
        ta.TenentPasswordfnx(ConfigReader.getProperty("tenant_password"));
        ta.TenentLoginbtn();

        isLoggedIn = true;
        System.out.println("🔑 Logged in as Tenant Admin");
    }
}
