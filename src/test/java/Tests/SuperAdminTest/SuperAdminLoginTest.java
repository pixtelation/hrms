package Tests.SuperAdminTest;
import Base.Launch;
import Pages.SuperAdminPage.SuperAdminLogin;
import Utils.ConfigReader;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SuperAdminLoginTest extends Launch {
    SuperAdminLogin login;

      String SAemail = ConfigReader.getProperty("superadmin_email");
        String SApassword = ConfigReader.getProperty("superadmin_password");


@Test /// Blank Login Flow
    public void BlankloginTest() {
        driver.navigate().refresh();
        login = new SuperAdminLogin(driver);
        login.clickLogin();

         String emailerror = login.emailerrormsg.getText();
         String passerror = login.passworderrormsg.getText();
        

         Assert.assertEquals(emailerror, "The Email field is required");
         Assert.assertEquals(passerror, "The Password field is required");
    }



    @Test //// Invalid Login Flow
    public void InvalidLoginTest(){
        
        String uemail = "admin1@weavers-web.com";
        String upass = "Admin1@2050";
       
        login = new SuperAdminLogin(driver);
        login.enterEmail(uemail);
        login.enterPassword(upass);
        login.clickLogin();

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    
    try {
       
        WebElement toast = wait.until(ExpectedConditions.visibilityOf(login.ToastMsg));
    System.out.println("Toast Error: " + toast.getText());
} catch (TimeoutException e) {
    System.out.println("Toast message not found within 5 seconds.");
}  

}



    @Test // Positive Login flow 
    public void loginTest() {
        driver.navigate().refresh();
        login = new SuperAdminLogin(driver);
        login.enterEmail(SAemail);
        login.enterPassword(SApassword);
        login.clickLogin();
    }







}
