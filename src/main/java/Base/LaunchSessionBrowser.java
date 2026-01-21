package Base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class launches a persistent Chrome browser session
 * for LOCAL execution only.
 *
 * It MUST NOT run in CI.
 */
public class LaunchSessionBrowser {

    public static void main(String[] args) {

        // 🚫 Do NOT allow persistent browser in CI
        if (System.getenv("CI") != null) {
            System.out.println("CI environment detected. Persistent browser will not be launched.");
            return;
        }

        // ✅ Load config before reading properties
        ConfigReader.loadConfig();

        String DEBUG_PORT = ConfigReader.getProperty("chrome.debug.port");

        if (DEBUG_PORT == null || DEBUG_PORT.trim().isEmpty()) {
            throw new RuntimeException(
                    "DEBUG PORT is not configured. Please set 'port' in config.properties");
        }

        System.out.println("Starting persistent Chrome session on port " + DEBUG_PORT);

        // Ensure ChromeDriver is available
        if (System.getProperty("webdriver.chrome.driver") == null) {
            WebDriverManager.chromedriver().setup();
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=" + DEBUG_PORT);
        // options.addArguments("--user-data-dir=C:/chrome-session-hrms");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");

        try {
            // Launch Chrome
            new ChromeDriver(options);

            System.out.println("✅ Persistent Chrome launched successfully.");
            System.out.println("👉 Do NOT close this terminal while running tests.");
            System.out.println("👉 Close the browser manually when done.");

            // Keep JVM alive so Chrome remains debuggable
            while (true) {
                Thread.sleep(10_000);
            }

        } catch (Exception e) {
            System.err.println(
                    "❌ Failed to launch persistent browser. Is port " + DEBUG_PORT + " already in use?");
            e.printStackTrace();
        }
    }
}
