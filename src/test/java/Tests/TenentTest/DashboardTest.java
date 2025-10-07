package Tests.TenentTest;

import Base.Launch;
import org.testng.annotations.Test;

import Base.Launch1;
import Pages.TenentPage.Dashboard;

public class DashboardTest extends Launch {

    Dashboard dbd;

    @Test
    public void TestDashboardMenu()
    {
        dbd = new Dashboard(driver);
        dbd.clickDbdMenu();
    }


}
