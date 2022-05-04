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

public class MoodlePractice {
    private final WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@id='section-4']//ancestor::div[3]/a/span")
    private WebElement practice;
    public MoodlePractice(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public MoodleOpenTest openPractises(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(practice));
//        Utils.jsClick(practice,driver);
        practice.click();
        return new MoodleOpenTest(driver);
    }

}
