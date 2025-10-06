package Tests.TenentTest;

import org.testng.annotations.Test;

import Base.Launch;
import Pages.TenentPage.Dashboard;

public class DashboardTest extends Launch{

    Dashboard dbd;

    @Test
    public void TestDashboardMenu()
    {
        dbd = new Dashboard(Launch.getDriver());
        dbd.clickDbdMenu();
    }


}
