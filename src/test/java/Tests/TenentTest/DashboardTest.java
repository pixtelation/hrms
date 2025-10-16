package Tests.TenentTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Launch;
import Pages.TenentPage.Dashboard;

public class DashboardTest extends Launch{

    Dashboard dbd;

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
    public void TestDashboardMenu()
    {
        dbd = new Dashboard(Launch.getDriver());
        dbd.clickDbdMenu();
    }


}
