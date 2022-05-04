package lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoodleLogedPage {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//h5[text()='Software Testing']")
    private WebElement courseButton;
    public MoodleLogedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public MoodlePractice goToTestCourse(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(courseButton));
       // Utils.jsClick(courseButton,driver);
        courseButton.click();
        return new MoodlePractice(driver);
    }

}
