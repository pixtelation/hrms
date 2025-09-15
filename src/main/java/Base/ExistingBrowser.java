package Base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Map;


public class ExistingBrowser {
   public static void main(String[] args) {
     WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Capabilities cap = driver.getCapabilities();
        Map<String, Object> mycap = cap.asMap();
        System.out.println(mycap);
   }

}