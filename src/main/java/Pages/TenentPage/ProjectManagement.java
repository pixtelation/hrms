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

    @FindBy(xpath = "//A[normalize-space(.)='Project Management']")
    WebElement ProjectManagementMenuBtn;

    @FindBy(xpath = "//A[normalize-space(.)='Add New']")
    WebElement AddNewProjectBtn;

    @FindBy(xpath = "//*[@placeholder='Project Name*']")
    WebElement projectNameTextField;

    @FindBy(xpath = "//input[@placeholder='Start Date*']")
    WebElement startDateTextField;

    @FindBy(xpath = "//*[@placeholder='Project Cost*']")
    WebElement projectCostTextField;

    @FindBy(xpath = "//A[normalize-space(.)='Edit']")
    WebElement editLink;

    @FindBy(xpath = "//*[@placeholder='Client’s Email*']")
    WebElement clientEmailTextField;

    @FindBy(xpath = "//*[contains(@class,'form-control my-phone-input') and normalize-space(@placeholder)=\"Client's phone number*\"]")
    WebElement clientPhoneTextField;

    @FindBy(xpath = "//*[contains(@class,'form-control my-phone-input') and normalize-space(@placeholder)=\"Client's whatsapp number*\"]")
    WebElement clientWhatsappTextField;

    @FindBy(xpath = "//*[@placeholder='Client’s Teams ID (If any)']")
    WebElement clientTeamsIdTextField;

    @FindBy(xpath = "//*[@placeholder='Client’s Slack ID (If any)']")
    WebElement clientSlackIdTextField;

    @FindBy(xpath = "//*[normalize-space(.)='Create']")
    WebElement createButton;

    public void clickPMMenuBtn()
    {
        ProjectManagementMenuBtn.click();
    }

    public void clickAddNewProjectBtn()
    {
        AddNewProjectBtn.click();
    }

    public void enterProjectName(String name) {
        projectNameTextField.sendKeys(name);
    }

    public void enterProjectCost(String cost) {
        projectCostTextField.sendKeys(cost);
    }

    public void enterStartDate(String date) {
        startDateTextField.sendKeys(date);
    }

    public void clickEdit() {
        editLink.click();
    }

    public void enterClientEmail(String email) {
        clientEmailTextField.sendKeys(email);
    }

    public void enterClientPhone(String phone) {
        clientPhoneTextField.sendKeys(phone);
    }

    public void enterClientWhatsapp(String whatsapp) {
        clientWhatsappTextField.sendKeys(whatsapp);
    }

    public void enterClientTeamsId(String teamsId) {
        clientTeamsIdTextField.sendKeys(teamsId);
    }

    public void enterClientSlackId(String slackId) {
        clientSlackIdTextField.sendKeys(slackId);
    }

    public void clickCreateBtn() {
        createButton.click();
    }
}
