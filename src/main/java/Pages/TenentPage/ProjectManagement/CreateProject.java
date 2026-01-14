package Pages.TenentPage.ProjectManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProject {

    public CreateProject(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@class,\"sidebar-link\") and normalize-space(@href)=\"/project-management\"]")
    WebElement ProjectMenuBtn;

    @FindBy(xpath = "//A[normalize-space(.)='Add New']")
    WebElement AddNewProjectBtn;

    @FindBy(xpath = "//INPUT[@placeholder=\"Project Name*\"]")
    WebElement projectNameTextField;

    @FindBy(xpath = "//FORM[contains(@class,'project-form-wraper')]/DIV[1]/DIV[2]/DIV[1]/DIV[2]/DIV/DIV[.='Project Type*']")
    WebElement projectTypeDropdown;

    @FindBy(xpath = "//FORM[contains(@class,'project-form-wraper')]/DIV[1]/DIV[2]/DIV[1]/DIV[2]/DIV/DIV[1]/DIV[2]/DIV[2]/*[local-name()='svg']")
    WebElement projectTypeDropdown2;

    @FindBy(xpath = "//*[normalize-space(.)='Web Application']")
    WebElement webApplicationOption;
    @FindBy(xpath = "//*[normalize-space(.)='Mobile Application']")
    WebElement mobileApplicationOption;
    @FindBy(xpath = "//*[normalize-space(.)='Desktop Application']")
    WebElement desktopApplicationOption;
    @FindBy(xpath = "//*[normalize-space(.)='Digital Marketing']")
    WebElement digitalMarketingOption;

    @FindBy(xpath = "//FORM[contains(@class,'project-form-wraper')]/DIV[1]/DIV[2]/DIV[1]/DIV[3]/DIV/DIV[.='Project Cost Type*']")
    WebElement projectCostTypeDropdown;
    @FindBy(xpath = "//*[normalize-space(.)='Fixed']")
    WebElement fixedOption;
    @FindBy(xpath = "//*[normalize-space(.)='Hourly']")
    WebElement hourlyOption;
    @FindBy(xpath = "//*[normalize-space(.)='Monthly']")
    WebElement monthlyOption;
    @FindBy(xpath = "//*[normalize-space(.)='Retainer Hourly']")
    WebElement retainerHourlyOption;

    @FindBy(xpath = "//*[contains(@class,'form-control react-datepicker-ignore-onclickoutside')]")
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
        ProjectMenuBtn.click();
    }

    public void clickAddNewProjectBtn()
    {
        AddNewProjectBtn.click();
    }

    public void enterProjectName(String name) {
        projectNameTextField.sendKeys(name);
    }
    public void selectProjectTypeDropdown()
    {
        projectTypeDropdown.click();
    }
    public void selectProjectTypeDropdown2()
    {
        projectTypeDropdown2.click();
    }
    public void selectWebApplicationOption()
    {
        webApplicationOption.click();
    }
    public void selectMobileApplicationOption()
    {
        mobileApplicationOption.click();
    }
    public void selectDesktopApplicationOption()
    {
        desktopApplicationOption.click();
    }
    public void selectDigitalMarketingOption()
    {
        digitalMarketingOption.click();
    }
    public void selectProjectCostTypeDropdown()
    {
        projectCostTypeDropdown.click();
    }
    public void selectFixedOption()
    {
        fixedOption.click();
    }
    public void selectHourlyOption()
    {
        hourlyOption.click();
    }
    public void selectMonthlyOption()
    {
        monthlyOption.click();
    }
    public void selectRetainerHourlyOption()
    {
        retainerHourlyOption.click();
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
