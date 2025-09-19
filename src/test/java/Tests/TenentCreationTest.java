package Tests;

import org.testng.annotations.Test;

import Base.Launch;
import Pages.TenentCreation;

public class TenentCreationTest extends Launch {
    TenentCreation tc ;


    @Test //// Positive Add new Tenent
    public void AddTenentPositive()
    {
        tc.CLickTenentManageFunction();
        tc.ClickAddNewFunction();
        tc.EnterCompanyNameFunction();
        tc.EnterDomainNameFunction();
        tc.EnterAdminNameFunction();
        tc.EnterTenentEmailFunction();
        tc.ClickAddTenentFormFunction();
    }


    @Test
    public void BlankTenent()
    {
        tc = new TenentCreation(driver);
        tc.ClickAddTenentFormFunction();
    }




}
