package Tests.TenentTest;

import Base.Launch;
import Pages.TenentPage.ProjectManagement;
import org.testng.annotations.Test;

public class ProjectManagementTest extends Launch {
    ProjectManagement pm;
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
