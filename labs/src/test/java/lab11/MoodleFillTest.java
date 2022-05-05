package lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoodleFillTest {
    private final WebDriver driver;
    @FindBy(how = How.XPATH,using = "//textarea[@class='qtype_essay_plain qtype_essay_response form-control']")
    private WebElement blank1;

    @FindBy(how = How.XPATH,using = "//span[@class='answer']//input")
    private WebElement blank2;
    @FindBy(how = How.XPATH,using = "//p[text()='Planetou sluneční soustavy není ']//ancestor::select[@class='select custom-select custom-select place1']")
    private WebElement selector1;
    @FindBy(how = How.XPATH,using = "//p[text()='Mezi státy evropské unie patří ']//ancestor::select[@class='select custom-select custom-select place1']")
    private WebElement selector2;

    public MoodleFillTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public MoodleLogOut fillTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(blank1));
        blank1.sendKeys("Andrei Mamaev 12");
        wait.until(ExpectedConditions.visibilityOf(blank2));
        blank2.sendKeys("86400");
        Select select = new Select(selector1);
        select.selectByVisibleText("Oberon");
        Select select2 = new Select(selector2);
        select2.selectByVisibleText("Rumunsko");
        return new MoodleLogOut(driver);
    }
}
