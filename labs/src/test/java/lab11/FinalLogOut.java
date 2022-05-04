package lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FinalLogOut {
    private final WebDriver driver;
    //    @FindBy(how = How.XPATH, using = "//div[@class='singlebutton quizstartbuttondiv']//ancestor::button")
    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary']")
    private WebElement logOutButton;

    public FinalLogOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void logOutForSure() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(logOutButton));
        logOutButton.click();
    }
}

