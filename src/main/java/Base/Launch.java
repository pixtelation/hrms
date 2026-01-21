package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
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
    // BROWSER INITIALIZATION (LOCAL / CI / REMOTE)
    // -------------------------------------------------
    @BeforeSuite(alwaysRun = true)
    public void ensureBrowserIsRunning() {

        if (isBrowserStarted)
            return;

        boolean isCI = System.getenv("CI") != null;
        boolean isRemote = Boolean.parseBoolean(
                ConfigReader.getProperty("remote.enabled"));

        try {
            ChromeOptions options = new ChromeOptions();

            if (isRemote) {
                // -------- REMOTE EXECUTION --------
                String remoteUrl = ConfigReader.getProperty("remote.hub.url");
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");

                driver = new RemoteWebDriver(new URL(remoteUrl), options);
                System.out.println("Remote run → Chrome on " + remoteUrl);

            } else if (isCI) {
                // -------- CI / HEADLESS --------
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");

                driver = new ChromeDriver(options);
                System.out.println("CI detected → headless Chrome started");

            } else {
                // -------- LOCAL EXECUTION --------
                boolean attach = Boolean.parseBoolean(
                        ConfigReader.getProperty("local.attach"));

                if (attach) {
                    String DEBUG_PORT = ConfigReader.getProperty("chrome.debug.port");
                    options.setExperimentalOption(
                            "debuggerAddress", "localhost:" + DEBUG_PORT);
                    driver = new ChromeDriver(options);
                    System.out.println(
                            "Local run → attached to Chrome on port " + DEBUG_PORT);
                } else {
                    options.addArguments("--start-maximized");
                    driver = new ChromeDriver(options);
                    System.out.println(
                            "Local run → new Chrome browser started");
                }
            }

            driver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

            isBrowserStarted = true;

        } catch (MalformedURLException e) {
            throw new RuntimeException(
                    "Invalid remote hub URL: "
                            + ConfigReader.getProperty("remote.hub.url"),
                    e);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Browser initialization failed. "
                            + (isCI
                                    ? "Headless Chrome failed in CI."
                                    : isRemote
                                            ? "Ensure Selenium Grid is running."
                                            : "Ensure Chrome is available locally."),
                    e);
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
            throw new RuntimeException(
                    "No URL configured for package: " + pkg);
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
    // LOGIN STATE VALIDATION
    // -------------------------------------------------
    private static boolean hasValidSessionCookie() {
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies.stream().anyMatch(c -> c.getName().equalsIgnoreCase("JSESSIONID")
                || c.getName().toLowerCase().contains("session"));
    }

    private static boolean isWelcomeBackVisible() {
        try {
            return driver.findElement(
                    By.xpath("//*[normalize-space(.)='Welcome Back,']"))
                    .isDisplayed();
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
            System.out.println(
                    "SuperAdmin already logged in — skipping login");
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
            System.out.println(
                    "Tenant Admin already logged in — skipping login");
            return;
        }

        TenentAdminLogin ta = new TenentAdminLogin(driver);
        ta.TenentEmailfnx(
                ConfigReader.getProperty("tenant_email"));
        ta.TenentPasswordfnx(
                ConfigReader.getProperty("tenant_password"));
        ta.TenentLoginbtn();

        System.out.println("Logged in as Tenant Admin");
    }

    // -------------------------------------------------
    // OPTIONAL TEARDOWN
    // -------------------------------------------------
    /*
     * @AfterSuite(alwaysRun = true)
     * public void tearDown() {
     * if (driver != null) {
     * driver.quit();
     * driver = null;
     * isBrowserStarted = false;
     * }
     * }
     */
}
