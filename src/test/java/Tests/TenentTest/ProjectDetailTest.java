package Tests.TenentTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Launch;
import Pages.TenentPage.ProjectManagement.AllProjects;
import Pages.TenentPage.ProjectManagement.ProjectDetails;

public class ProjectDetailTest extends Launch {

    ProjectDetails pd;
    AllProjects ap;

    @BeforeClass

    public void prerequisiteLogin() {
        // 1. Check the package name
        String packageName = this.getClass().getPackage().getName();

        // 2. Perform the required login if not already logged in
        if (packageName.contains("TenentTest")) {
            Launch.loginAsTenentAdmin();
        } else if (packageName.contains("SuperAdminTest")) {
            // Unlikely for DashboardTest, but good to show the conditional logic
            Launch.loginAsSuperAdmin();
        }
    }

    @Test
    public void ProjectDetailsFlow() {
        pd = new ProjectDetails(Launch.getDriver());
        ap = new AllProjects(Launch.getDriver());
        ap.clickPMMenuBtn();
        ap.clickNewProjectAlpha();
        pd.clickProjectStatusDropdown();
        pd.clickEditProjectBtn();
        pd.clickProjectDetails();
        // pd.clickViewCommentsBtn();
        // pd.clickTimesheetBtn();
        pd.clickManageAssetsAndInformationBtn();
        pd.clickProjectDetails();
        pd.clickMilestoneBtn();
        pd.clickProjectDetails();
        pd.clickAddMemberBtn();
        // pd.clickEnhancementTaskBtn();
        // pd.clickCostBreakdownBtn();
        // pd.clickRequestAdditionalHourBtn();
        // pd.clickViewAllActivitiesLink();

    }

}
