package Pages.TenentPage.ProjectManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProjects {

    private WebDriver driver;

    public AllProjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//A[normalize-space(.)='Projects']")
    WebElement ProjectMenuBtn;
    @FindBy(xpath = "//*[normalize-space(.)='New Project Alpha']")
    WebElement NewProjectAlpha;

    public void clickPMMenuBtn() {
        ProjectMenuBtn.click();
    }

    public void clickNewProjectAlpha() {
        NewProjectAlpha.click();
    }
       
}
