package Base;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Pages.SuperAdminPage.SuperAdminLogin;
import Pages.TenentPage.TenentAdminLogin;
import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch {

    private static WebDriver driver;
    private static boolean isBrowserStarted = false;

    // -------------------------------------------------
    // STATIC INITIALIZATION
    // -------------------------------------------------
    static {
        ConfigReader.loadConfig();

        if (System.getProperty("webdriver.chrome.driver") == null) {
            WebDriverManager.chromedriver().setup();
        }
    }

    // -------------------------------------------------
    // GETTER
    // -------------------------------------------------
    public static WebDriver getDriver() {
        return driver;
    }

    // -------------------------------------------------
    // BROWSER INITIALIZATION (LOCAL + CI)
    // -------------------------------------------------
    @BeforeSuite(alwaysRun = true)
    public void ensureBrowserIsRunning() {

        if (isBrowserStarted) return;

        boolean isCI = System.getenv("CI") != null;

        try {
            ChromeOptions options = new ChromeOptions();

            if (isCI) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                System.out.println("CI detected → starting headless Chrome");
            } else {
                String DEBUG_PORT = ConfigReader.getProperty("port");
                options.setExperimentalOption(
                        "debuggerAddress", "localhost:" + DEBUG_PORT
                );
                System.out.println("Local run → attaching to Chrome on port " + DEBUG_PORT);
            }

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            isBrowserStarted = true;

        } catch (Exception e) {
            throw new RuntimeException(
                    "Browser initialization failed. " +
                            (isCI
                                    ? "Headless Chrome failed in CI."
                                    : "Ensure persistent Chrome is running locally."
                            ),
                    e
            );
        }
    }

    // -------------------------------------------------
    // URL NAVIGATION BASED ON PACKAGE
    // -------------------------------------------------
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
            throw new RuntimeException("No URL configured for package: " + pkg);
        }

        try {
            if (!driver.getCurrentUrl().startsWith(targetUrl)) {
                driver.get(targetUrl);
            }
        } catch (UnreachableBrowserException e) {
            driver.get(targetUrl);
        }

        System.out.println("Navigated to: " + targetUrl);
    }

    // -------------------------------------------------
    // LOGIN STATE VALIDATION (BROWSER-DRIVEN)
    // -------------------------------------------------

    private static boolean hasValidSessionCookie() {
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies.stream().anyMatch(c ->
                c.getName().equalsIgnoreCase("JSESSIONID")
                        || c.getName().toLowerCase().contains("session")
        );
    }

    private static boolean isWelcomeBackVisible() {
        try {
            return driver.findElement(By.xpath("//*[normalize-space(.)='Welcome Back,']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isAlreadyLoggedIn() {
        return hasValidSessionCookie() || isWelcomeBackVisible();
    }

    // -------------------------------------------------
    // LOGIN HELPERS
    // -------------------------------------------------
    public static void loginAsSuperAdmin() {

        if (isAlreadyLoggedIn()) {
            System.out.println("SuperAdmin already logged in — skipping login");
            return;
        }

        SuperAdminLogin sa = new SuperAdminLogin(driver);
        sa.enterEmail(ConfigReader.getProperty("superadmin_email"));
        sa.enterPassword(ConfigReader.getProperty("superadmin_password"));
        sa.clickLogin();

        System.out.println("Logged in as SuperAdmin");
    }

    public static void loginAsTenentAdmin() {

        if (isAlreadyLoggedIn()) {
            System.out.println("Tenant Admin already logged in — skipping login");
            return;
        }

        TenentAdminLogin ta = new TenentAdminLogin(driver);
        ta.TenentEmailfnx(ConfigReader.getProperty("tenant_email"));
        ta.TenentPasswordfnx(ConfigReader.getProperty("tenant_password"));
        ta.TenentLoginbtn();

        System.out.println("Logged in as Tenant Admin");
    }

    // -------------------------------------------------
    // NO TEARDOWN (LOCAL SESSION PERSISTS)
    // -------------------------------------------------
    /*
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    */
}
