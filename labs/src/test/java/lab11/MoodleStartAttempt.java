package lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoodleStartAttempt {
    private final WebDriver driver;
//    @FindBy(how = How.XPATH, using = "//div[@class='singlebutton quizstartbuttondiv']//ancestor::button")
    @FindBy(how = How.ID,using = "id_submitbutton")
    private WebElement attemptQuizButton;

    public MoodleStartAttempt(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public MoodleFillTest startAttempt() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(attemptQuizButton));
        attemptQuizButton.click();
//        Utils.jsClick(attemptQuizButton,driver);
        return new MoodleFillTest(driver);
    }
}
