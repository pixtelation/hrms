package Pages.SuperAdminPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class TenentCreation {

    public TenentCreation(WebDriver driver)
    {
     PageFactory.initElements(driver, this);
    }

   @FindBy (xpath= "//a[@class=' sidebar-link d-block ']")
   WebElement TenentManage;

   @FindBy (xpath= "(//button[normalize-space()='Add New'])[1]")
   WebElement AddNewTenentButton;

   @FindBy(xpath = "//input[@id='name']")
   WebElement TenentCompanyName;

   @FindBy(xpath = "//input[@id='domainAdd']")
   WebElement TenentDomainName;

   @FindBy(xpath = "//input[@id='tenantName']")
   WebElement TenentAdminName;
   
   @FindBy(xpath = "//input[@id='tenantEmail']")
   WebElement TenentEmail;

   //button[normalize-space()='Add Tenant']
    @FindBy(xpath = "//button[normalize-space()='Add Tenant']")
   WebElement AddTenentFormbtn;



   public void CLickTenentManageMenuFunction()
   {
    TenentManage.click();
   }

   public void ClickAddNewFunction()
   {
    AddNewTenentButton.click();
   }

    public void EnterCompanyNameFunction()
   {
    TenentCompanyName.sendKeys("");
   }

    public void EnterDomainNameFunction()
   {
    TenentDomainName.sendKeys("");
   }

    public void EnterAdminNameFunction()
   {
    TenentAdminName.sendKeys("");
   }

    public void EnterTenentEmailFunction()
   {
    TenentEmail.sendKeys("");
   }

     public void ClickAddTenentFormFunction()
   {
    AddNewTenentButton.click();
   }




}
