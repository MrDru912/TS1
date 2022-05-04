package lab11;

import lab10.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoodleAttemptQuiz {
    private final WebDriver driver;
    @FindBy(how = How.XPATH, using = "//div[@class='singlebutton quizstartbuttondiv']//ancestor::button")
    private WebElement attemptQuizButton;

    public MoodleAttemptQuiz(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public MoodleStartAttempt attemptQuiz() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(attemptQuizButton));
        attemptQuizButton.click();
//        Utils.jsClick(attemptQuizButton,driver);
        return new MoodleStartAttempt(driver);
    }
}
