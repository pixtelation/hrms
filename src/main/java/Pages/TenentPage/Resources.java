package Pages.TenentPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resources {

    public  Resources(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[normalize-space()='Resources']")
    WebElement ReourcesParent;

    @FindBy(xpath = "(//a[normalize-space()='Resource List'])[1]")
    WebElement ResourceList;

    @FindBy(xpath = "(//a[normalize-space()='Departments'])[1]")
    WebElement Departments;

    @FindBy(xpath = "(//a[normalize-space()='Techstack'])[1]")
    WebElement Techstack;
    
    @FindBy(xpath = "//button[normalize-space()='Add New'])[1]")
    WebElement ReourcesAddNew;

    @FindBy(xpath = "//input[@placeholder='Employee Name*']")
    WebElement EmployeeName;

    @FindBy(xpath = "//input[@placeholder='Employee ID*']")
    WebElement EmployeeId;

    @FindBy(xpath = "//input[@placeholder='Employee's Email*']")
    WebElement EmployeeEmail;

    @FindBy(xpath = "//DIV[contains(@class,'custom-modal-body')]/FORM/DIV/DIV[4]/DIV/DIV/DIV[.='Employee's Role*']")
    WebElement EmployeeRole;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement AddResourceSubmit;
    

 


    

   




    



}
