import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class LinkSpringerSearch {
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id='query']")
    private WebElement searchInput;
    @FindBy(how = How.XPATH, using = "//input[@id='search']")
    private WebElement searchButton;

    public LinkSpringerSearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }


    public Publication getPublication(String articleName) {
        // searching article
        searchInput.sendKeys(articleName);
        searchButton.click();

        WebElement articleLink = driver.findElement(By.xpath("//a[contains(text(),'"+articleName+"')]"));
        Utils.jsClick(articleLink,driver);
        WebElement date = driver.findElement(By.xpath("//a[text()='Published: ']//time"));
        WebElement doi = driver.findElement(By.xpath("//p[contains(abbr,\"DOI\")]//span[@class='c-bibliographic-information__value']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(date));
        wait.until(ExpectedConditions.visibilityOf(doi));
        Publication publication = new Publication();
        publication.name = articleName;
        publication.date = date.getText();
        publication.doi = doi.getText();
        driver.navigate().back();
        System.out.println(publication+"\n");
        return publication;
    }

}
