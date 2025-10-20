package Tests.SuperAdminTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Launch;
import Pages.SuperAdminPage.TenentCreation;

public class TenentCreationTest extends Launch {
    TenentCreation tc ;
    
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


    @Test (priority = 2)//// Positive Add new Tenent
    public void AddTenentPositive()
    {
        tc.CLickTenentManageMenuFunction();
        tc.ClickAddNewFunction();
        tc.EnterCompanyNameFunction();
        tc.EnterDomainNameFunction();
        tc.EnterAdminNameFunction();
        tc.EnterTenentEmailFunction();
        tc.ClickAddTenentFormFunction();
    }


    @Test (priority = 1)
    public void BlankTenent()
    {
        tc = new TenentCreation(Launch.getDriver());
        tc.CLickTenentManageMenuFunction();
        tc.ClickAddNewFunction();
        tc.ClickAddTenentFormFunction();
    }




}
