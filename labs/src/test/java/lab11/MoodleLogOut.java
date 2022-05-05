package lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoodleLogOut {

    @FindBy(how = How.XPATH,using = "//a[@id='action-menu-toggle-1']")
    private WebElement menuButton;
    @FindBy(how = How.XPATH,using = "//a[@data-title='logout,moodle']")
    private WebElement logOutButton;
    private final WebDriver driver;
    public MoodleLogOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public FinalLogOut LogOut1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(menuButton));
        menuButton.click();
        wait.until(ExpectedConditions.visibilityOf(logOutButton));
        logOutButton.click();
        return new FinalLogOut(driver);
    }
}
