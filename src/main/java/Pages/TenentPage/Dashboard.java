package Pages.TenentPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;


public class Dashboard {

    public  Dashboard(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//li[@class='sidebar-item'])[1]")
    WebElement DashboardMenuBtn;





    public void clickDbdMenu()
    {
        DashboardMenuBtn.click();
    }


}
