package Base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

// This class is run separately to launch the persistent browser
public class LaunchSessionBrowser {

    private static final String DEBUG_PORT = "53478";

    public static void main(String[] args) {
        System.out.println("Starting persistent Chrome session on port " + DEBUG_PORT);
        
        // Ensure ChromeDriver is set up
        if (System.getProperty("webdriver.chrome.driver") == null) {
            WebDriverManager.chromedriver().setup();
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=" + DEBUG_PORT);
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");

        try {
            // Launch the browser and keep the process alive
            // The process that runs this main method will hold the session
            ChromeDriver driver = new ChromeDriver(options);
            System.out.println("Persistent Chrome launched successfully.");
            
            // Wait indefinitely so the browser stays open and debuggable
            // The user must manually close the browser when testing is complete.
            while (true) {
                Thread.sleep(10000); // Sleep for 10 seconds and repeat
            }
            
        } catch (Exception e) {
            System.err.println("Failed to launch persistent browser. Is port " + DEBUG_PORT + " already in use?");
            e.printStackTrace();
        }
    }
}