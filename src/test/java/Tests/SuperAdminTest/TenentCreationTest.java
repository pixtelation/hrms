package Tests.SuperAdminTest;

import org.testng.annotations.Test;

import Base.Launch;
import Pages.SuperAdminPage.TenentCreation;

public class TenentCreationTest extends Launch {
    TenentCreation tc ;


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
