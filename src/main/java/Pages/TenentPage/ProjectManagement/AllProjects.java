package Pages.TenentPage.ProjectManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProjects {

    public AllProjects(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//A[normalize-space(.)='Projects']")
    WebElement ProjectMenuBtn;
    public void clickPMMenuBtn()
    {
        ProjectMenuBtn.click();
    }

}
