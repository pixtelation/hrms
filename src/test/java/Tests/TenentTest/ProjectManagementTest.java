package Tests.TenentTest;

import Base.Launch;
import Pages.TenentPage.ProjectManagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectManagementTest extends Launch {
    ProjectManagement pm;


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
    public void ProjectManagementFlow() {
        pm= new ProjectManagement(Launch.getDriver());
        pm.clickPMMenuBtn();
        pm.clickAddNewProjectBtn();
        pm.enterProjectName("New Project Alpha");
        pm.enterStartDate("10/07/2025");
        pm.enterProjectCost("15000");
        pm.clickCreateBtn();
    }

}
