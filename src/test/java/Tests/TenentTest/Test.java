package Tests.TenentTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://hrms.weaversweb.co.in/");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys("admin.hrms@weavers-web.com");
        driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Web@2050");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("(//li[@class='sidebar-item'])[3]")).click();
        driver.findElement(By.xpath("//ul[@class='sidebar-submenu']/li/a")).click();

        driver.findElement(By.xpath("//button[@class='btn btn-gradient']")).click();


        driver.findElement(By.xpath("//input[@placeholder='Employee Name*']")).sendKeys("Name");
        driver.findElement(By.xpath("//input[@placeholder='Employee ID*']")).sendKeys("ID");
        driver.findElement(By.xpath("//input[@placeholder='Employee’s Email*']")).sendKeys("EMAIL");

        //Thread.sleep(2000);
        //WebElement dropdown =
        //driver.findElement(By.xpath("//div[@class='react-select__control css-13cymwt-control']"));


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='react-select-7-placeholder'])[1]")));
//        dropdown.click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//        // Target the dropdown inside the modal
//        WebElement employeeRoleDropdown = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        By.xpath("//h5[contains(text(),'Add A New Employee')]/ancestor::div[contains(@class,'modal-content')]//div[contains(@class,'react-select__control')]")
//
//                )
//        );
//
//        // Use JS to ensure click works even if overlay blocks it
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", employeeRoleDropdown);
//        js.executeScript("arguments[0].click();", employeeRoleDropdown);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click dropdown
        WebElement roleDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//DIV[contains(@class,'custom-modal-body')]/FORM/DIV/DIV[4]/DIV/DIV/DIV[.='Employee’s Role*']")));
        roleDropdown.click();

        WebElement option = driver.findElement(By.xpath(
                "//DIV[normalize-space(.)='ADMIN']"));
        option.click();

    }

}