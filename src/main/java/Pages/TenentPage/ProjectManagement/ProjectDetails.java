package Pages.TenentPage.ProjectManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectDetails {

    private WebDriver driver;

    public ProjectDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Project Status Dropdown
    @FindBy(tagName = "SELECT")
    WebElement projectStatusDropdown;

    // Edit Project Button
    @FindBy(xpath = "//*[normalize-space(.)='Edit Project']")
    WebElement editProjectBtn;

    // View Comments Button
    @FindBy(xpath = "//*[normalize-space(.)='View Comments']")
    WebElement viewCommentsBtn;

    // Timesheet Button
    @FindBy(xpath = "//BUTTON[normalize-space(.)='Timesheet']")
    WebElement timesheetBtn;

    // Manage Assets & Information Button
    @FindBy(xpath = "//*[normalize-space(.)='Manage Assets & Information']")
    WebElement manageAssetsAndInformationBtn;

    // Milestone Button
    @FindBy(xpath = "//*[normalize-space(.)='Milestone']")
    WebElement milestoneBtn;

    // Add Member Button
    @FindBy(xpath = "//*[contains(@class,'member-avatar add-member cursor-pointer')]")
    WebElement addMemberBtn;

    // Enhancement Task Button
    @FindBy(xpath = "//*[normalize-space(.)='+ Enhancement Task']")
    WebElement enhancementTaskBtn;

    // Cost Breakdown Button
    @FindBy(xpath = "//*[normalize-space(.)='Cost Breakdown']")
    WebElement costBreakdownBtn;

    // Request Additional Hour Button
    @FindBy(xpath = "//*[normalize-space(.)='Request Additional Hour']")
    WebElement requestAdditionalHourBtn;

    // View All Activities Link
    @FindBy(xpath = "//A[normalize-space(.)='View All Activities']")
    WebElement viewAllActivitiesLink;
    @FindBy(xpath = "//A[normalize-space(.)='Project Details']")
    WebElement ProjectDetails;

    // ==================== Click Methods ====================

    public void clickProjectStatusDropdown() {
        projectStatusDropdown.click();
    }

    public void clickEditProjectBtn() {
        editProjectBtn.click();
    }

    public void clickViewCommentsBtn() {
        viewCommentsBtn.click();
    }

    public void clickTimesheetBtn() {
        timesheetBtn.click();
    }

    public void clickManageAssetsAndInformationBtn() {
        manageAssetsAndInformationBtn.click();
    }

    public void clickMilestoneBtn() {
        milestoneBtn.click();
    }

    public void clickAddMemberBtn() {
        addMemberBtn.click();
    }

    public void clickEnhancementTaskBtn() {
        enhancementTaskBtn.click();
    }

    public void clickCostBreakdownBtn() {
        costBreakdownBtn.click();
    }

    public void clickRequestAdditionalHourBtn() {
        requestAdditionalHourBtn.click();
    }

    public void clickViewAllActivitiesLink() {
        viewAllActivitiesLink.click();
    }

    public void clickProjectDetails() {
        ProjectDetails.click();
    }

}
