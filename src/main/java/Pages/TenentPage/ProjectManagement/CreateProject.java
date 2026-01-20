package Pages.TenentPage.ProjectManagement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProject {

    private WebDriver driver;

    public CreateProject(WebDriver driver) {
        this.driver = driver;
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

    @FindBy(xpath = "//INPUT[@placeholder=\"Project Cost*\"]")
    WebElement fixedProjectCostTextField;

    @FindBy(xpath = "//INPUT[@placeholder=\"Estimated Time (hours)*\"]")
    WebElement projectEstimatedTimeTextField;

    @FindBy(xpath = "//DIV[normalize-space(.)='Angular']")
    WebElement angularTechnologyOption;

    @FindBy(xpath = "//FORM[contains(@class,'project-form-wraper')]/DIV[1]/DIV[2]/DIV[2]/DIV/DIV/DIV[3]/DIV/DIV/DIV[1]/DIV[2]/DIV/*[local-name()='svg']")
    WebElement fixedProjectTechnologiesDropdown;

    @FindBy(xpath = "//INPUT[@placeholder=\"Rate*\"]")
    WebElement monthlyProjectRateTextField;

    @FindBy(xpath = "//DIV[contains(@class,'project-form-border')]/DIV/DIV[2]/DIV/DIV/DIV[1]/DIV[2]/DIV")
    WebElement monthlyProjectUtilizationDropdown;

    @FindBy(xpath = "//*[normalize-space(.)='Half']")
    WebElement monthlyProjectUtilizationHalfOption;

    @FindBy(xpath = "//*[normalize-space(.)='Full']")
    WebElement monthlyProjectUtilizationFullOption;

    // Team Details Dropdowns
    @FindBy(xpath = "//FORM[contains(@class,'project-form-wraper')]/DIV[3]/DIV[2]/DIV[1]/DIV/DIV/DIV[1]/DIV[2]/DIV/*[local-name()='svg']")
    WebElement bdmDropdown;

    @FindBy(xpath = "//FORM[contains(@class,'project-form-wraper')]/DIV[3]/DIV[2]/DIV[2]/DIV/DIV/DIV[1]/DIV[2]/DIV/*[local-name()='svg']")
    WebElement projectManagerDropdown;

    @FindBy(xpath = "//FORM[contains(@class,'project-form-wraper')]/DIV[3]/DIV[2]/DIV[3]/DIV/DIV/DIV[1]/DIV[2]/DIV/*[local-name()='svg']")
    WebElement coOrdinatorDropdown;

    @FindBy(xpath = "//FORM[contains(@class,'project-form-wraper')]/DIV[3]/DIV[2]/DIV[4]/DIV/DIV/DIV[1]/DIV[2]/DIV/*[local-name()='svg']")
    WebElement teamLeadDropdown;

    @FindBy(xpath = "//FORM[contains(@class,'project-form-wraper')]/DIV[3]/DIV[2]/DIV[5]/DIV/DIV/DIV[1]/DIV[2]/DIV/*[local-name()='svg']")
    WebElement acquisitionLeadsDropdown;

    @FindBy(xpath = "//FORM[contains(@class,'project-form-wraper')]/DIV[3]/DIV[2]/DIV[6]/DIV/DIV/DIV/DIV[2]/DIV/*[local-name()='svg']/*[local-name()='path']")
    WebElement teamMembersDropdown;

    // Team Details Dropdown Options
    @FindBy(xpath = "//DIV[normalize-space(.)='Steve paul']")
    WebElement bdmOption;

    @FindBy(xpath = "//DIV[normalize-space(.)='Krisanu Nandi']")
    WebElement projectManagerOption;

    @FindBy(xpath = "//DIV[normalize-space(.)='Ritwik Bose']")
    WebElement coOrdinatorOption;

    @FindBy(xpath = "//DIV[normalize-space(.)='Sourav Kamilya']")
    WebElement teamLeadOption;

    @FindBy(xpath = "//DIV[normalize-space(.)='Subrata Paul']")
    WebElement acquisitionLeadsOption;

    @FindBy(xpath = "//*[normalize-space(.)='Abhishek Mehta']")
    WebElement teamMembersOption;

    // Client Section
    @FindBy(xpath = "//FORM[contains(@class,'project-form-wraper')]/DIV[2]/DIV[2]/DIV[1]/DIV/DIV/DIV/DIV[2]/DIV/*[local-name()='svg']")
    WebElement selectClientDropdown;

    @FindBy(xpath = "//DIV[normalize-space(.)='George Shermazanashvili (George)']")
    WebElement clientOption;

    // Utility method to scroll to element
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    // General scroll down method - scrolls the form container
    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // First try to scroll the form container, if not found scroll the window
        js.executeScript(
                "var container = document.querySelector('.project-form-wraper');" +
                        "if(container) { container.scrollTop += " + pixels + "; }" +
                        "else { window.scrollBy(0, " + pixels + "); }");
    }

    public void clickPMMenuBtn() {
        ProjectMenuBtn.click();
    }

    public void clickAddNewProjectBtn() {
        AddNewProjectBtn.click();
    }

    public void enterProjectName(String name) {
        projectNameTextField.sendKeys(name);
    }

    public void selectProjectTypeDropdown() {
        projectTypeDropdown.click();
    }

    public void selectProjectTypeDropdown2() {
        projectTypeDropdown2.click();
    }

    public void selectWebApplicationOption() {
        webApplicationOption.click();
    }

    public void selectMobileApplicationOption() {
        mobileApplicationOption.click();
    }

    public void selectDesktopApplicationOption() {
        desktopApplicationOption.click();
    }

    public void selectDigitalMarketingOption() {
        digitalMarketingOption.click();
    }

    public void selectProjectCostTypeDropdown() {
        projectCostTypeDropdown.click();
    }

    public void selectFixedOption() {
        fixedOption.click();
    }

    public void selectHourlyOption() {
        hourlyOption.click();
    }

    public void selectMonthlyOption() {
        monthlyOption.click();
    }

    public void selectRetainerHourlyOption() {
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

    public void enterFixedProjectCost(String cost) {
        fixedProjectCostTextField.sendKeys(cost);
    }

    public void enterProjectEstimatedTime(String time) {
        projectEstimatedTimeTextField.sendKeys(time);
    }

    public void selectAngularTechnologyOption() {
        angularTechnologyOption.click();
    }

    public void clickFixedProjectTechnologiesDropdown() {
        fixedProjectTechnologiesDropdown.click();
    }

    public void enterMonthlyProjectRate(String rate) {
        monthlyProjectRateTextField.sendKeys(rate);
    }

    public void clickMonthlyProjectUtilizationDropdown() {
        monthlyProjectUtilizationDropdown.click();
    }

    public void selectMonthlyProjectHalfOption() {
        monthlyProjectUtilizationHalfOption.click();
    }

    public void selectMonthlyProjectFullOption() {
        monthlyProjectUtilizationFullOption.click();
    }

    // Team Details Dropdown Methods
    public void clickBdmDropdown() {
        bdmDropdown.click();
    }

    public void clickProjectManagerDropdown() {
        projectManagerDropdown.click();
    }

    public void clickCoOrdinatorDropdown() {
        coOrdinatorDropdown.click();
    }

    public void clickTeamLeadDropdown() {
        teamLeadDropdown.click();
    }

    public void clickAcquisitionLeadsDropdown() {
        scrollToElement(acquisitionLeadsDropdown);
        acquisitionLeadsDropdown.click();
    }

    public void clickTeamMembersDropdown() {
        teamMembersDropdown.click();
    }

    // Team Details Dropdown Option Methods
    public void selectBdmOption() {
        bdmOption.click();
    }

    public void selectProjectManagerOption() {
        projectManagerOption.click();
    }

    public void selectCoOrdinatorOption() {
        coOrdinatorOption.click();
    }

    public void selectTeamLeadOption() {
        teamLeadOption.click();
    }

    public void selectAcquisitionLeadsOption() {
        acquisitionLeadsOption.click();
    }

    public void selectTeamMembersOption() {
        teamMembersOption.click();
    }

    // Client Section Methods
    public void clickClientDropdown() {
        scrollToElement(selectClientDropdown);
        selectClientDropdown.click();
    }

    public void selectClientOption() {
        scrollToElement(clientOption);
        clientOption.click();
    }
}
