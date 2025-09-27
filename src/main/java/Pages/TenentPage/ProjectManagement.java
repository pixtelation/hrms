package Pages.TenentPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectManagement {



    public ProjectManagement(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//li[@class='sidebar-item'])[2]")
    WebElement ProjectManagementMenuBtn;

    @FindBy(xpath = "(//a[normalize-space()='Add New'])[1]")
    WebElement AddNewProjectBtn;

    



    public void clickPMMenuBtn()
    {
         ProjectManagementMenuBtn.click();
    }

    public void clickAddNewProjectbtn()
    {
        AddNewProjectBtn.click();
    }





}
