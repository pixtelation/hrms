package Pages.TenentPage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;


public class TenentAdminLogin {


    public TenentAdminLogin(WebDriver driver)
    {
      PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement TenentEmail;

    @FindBy(xpath = "//input[@name='password']")
    WebElement TenentPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement TenentLoginBtn;

    @FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
    WebElement ForgotPassword;

    @FindBy(id = "email")
    WebElement ForgotPasswordEmail;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement ForgotPasswordContinuebtn;

    @FindBy(xpath = "//h2[@id='swal2-title']")
    public WebElement TenentToastMsg;

    @FindBy(xpath = "//h2[normalize-space()='Dashboard']")
    WebElement DashboardAssert;






    public void TenentEmailfnx(String TenEmail)
    {
        TenentEmail.sendKeys(TenEmail);
    }

    public void TenentPasswordfnx(String TenPassword)
    {
        TenentPassword.sendKeys(TenPassword);
    }

    public void TenentLoginbtn()
    {
        TenentLoginBtn.click();
    }


public WebElement waitForToastMessage(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("swal2-title")));
}



    public WebElement TenentLoginAssert(WebDriver driver)
   {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.visibilityOf(DashboardAssert));
  }


}
