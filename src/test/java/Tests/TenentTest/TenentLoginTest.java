package Tests.TenentTest;

import Base.Launch;
import Pages.TenentPage.TenentAdminLogin;
import Utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TenentLoginTest extends Launch {

    TenentAdminLogin ta;

    // Read from config or use hardcoded test data
    String TenentEmail = ConfigReader.getProperty("tenant_email");
    String TenentPassword = ConfigReader.getProperty("tenant_password");

    @Test
    public void TenentLoginFlow() {
        ta = new TenentAdminLogin(Launch.getDriver());

        // Step 1: Enter credentials and click login
        ta.TenentEmailfnx(TenentEmail);
        ta.TenentPasswordfnx(TenentPassword);
        ta.TenentLoginbtn();

        // Step 2: Try to wait for dashboard (success)
        try {
            WebElement dashboard = ta.TenentLoginAssert(Launch.getDriver()); // Waits 10s max
            String dashboardText = dashboard.getText();
            System.out.println("Login successfull....Dashboard text: " + dashboardText);
            Assert.assertTrue(dashboardText.contains("Dashboard"), "Dashboard not displayed as expected.");

        } catch (TimeoutException e) {
            // Dashboard didn't load → check for toast (failure)
            try {
                  WebElement toast = ta.waitForToastMessage(Launch.getDriver());

            // Use JavaScript to get text content (more reliable)
             JavascriptExecutor js = (JavascriptExecutor) Launch.getDriver();
            String toastText = (String) js.executeScript("return document.getElementById('swal2-title')?.textContent;");

            System.out.println("Login failed. Toast Message: " + toastText);

            Assert.fail("Login failed. Toast message: " + toastText);

            } catch (TimeoutException te) {
                // Neither dashboard nor toast appeared
                Assert.fail("❌ Login failed: Neither Dashboard nor Toast appeared. Possible UI bug or wrong locators.");
            }
        } catch (Exception e) {
            // Any other unexpected exception
            e.printStackTrace();
            Assert.fail("❌ Exception during login test: " + e.getMessage());
        }
    }
}
