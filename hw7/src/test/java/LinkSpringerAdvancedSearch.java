import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinkSpringerAdvancedSearch {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id='all-words']")
    private WebElement el;

    @FindBy(how = How.XPATH, using = "//input[@id='least-words']")
    private WebElement el2;
    @FindBy(how = How.XPATH, using = "//input[@id='facet-start-year']")
    private WebElement el3;

    @FindBy(how = How.XPATH, using = "//button[@id='submit-advanced-search']")
    private WebElement button;


    public LinkSpringerAdvancedSearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        driver.get("https://link.springer.com/advanced-search");
    }

    public LinkSpringerArticle search(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(el));
        wait.until(ExpectedConditions.visibilityOf(el2));
        wait.until(ExpectedConditions.visibilityOf(el3));
        el.sendKeys("Page Object Model");
        el2.sendKeys("Sellenium Testing");
        el3.sendKeys("2022");
        button.click();
        return new LinkSpringerArticle(driver);
    }
}
