package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;


public class SuperAdminLogin {


    public SuperAdminLogin(WebDriver driver) {
      
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginbtn;

    @FindBy(xpath = "(//p[@class='text-danger fs-6'])[1]")
    public WebElement emailerrormsg;

    @FindBy(xpath = "(//p[@class='text-danger fs-6'])[2]")
    public WebElement passworderrormsg;

    @FindBy(xpath = "//h2[@id='swal2-title']")
    public WebElement ToastMsg;    

    public void enterEmail(String usremail) {
        email.sendKeys(usremail);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
        loginbtn.sendKeys(Keys.ENTER);
    }   

    public String EmailErrorMSg()
    {
        return emailerrormsg.getText();
    }

    public String PasswordErrorMsg()
    {
        return passworderrormsg.getText();
    }

    public String ToastFailedMessage()
    {
        return ToastMsg.getText();
    }

    
}
