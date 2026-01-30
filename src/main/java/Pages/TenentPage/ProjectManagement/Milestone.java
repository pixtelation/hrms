package Pages.TenentPage.ProjectManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Milestone {

    private WebDriver driver;

    public Milestone(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
