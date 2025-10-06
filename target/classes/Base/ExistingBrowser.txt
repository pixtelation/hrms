package Base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Map;


public class ExistingBrowser {
   public static void main(String[] args) {
     WebDriverManager.chromedriver().setup();
        // Start Chrome with remote debugging enabled
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=53478"); // pick any free port

        // Launch the browser
        ChromeDriver driver = new ChromeDriver(options);
   }

}