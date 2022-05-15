import com.beust.ah.A;
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

public class LinkSpringerArticle {
    private final WebDriver driver;

    String[] articles = new String[4];

//    @FindBy(how = How.XPATH, using = "//span[text()='Article']")
    private WebElement articleLink;
    @FindBy(how = How.XPATH, using = "//h1[@class='c-article-title']")
    private WebElement name;
    @FindBy(how = How.XPATH, using = "//a[text()='Published: ']//time")
    private WebElement date;
    @FindBy(how = How.XPATH, using = "//p[contains(abbr,\"DOI\")]//span[@class='c-bibliographic-information__value']")
    private WebElement doi;
    ArrayList<Publication> publications;
    public LinkSpringerArticle(WebDriver driver) {
        articles[0] = "https://link.springer.com/article/10.1007/s11219-016-9331-9";
        articles[1] = "https://link.springer.com/article/10.1007/s13198-017-0646-0";
        articles[2] = "https://link.springer.com/article/10.1007/s11219-021-09575-w";
        articles[3] = "https://link.springer.com/article/10.1007/s11859-007-0005-0";
        publications = new ArrayList<>();
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public LinkSpringerArticle goToArticles(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        articleLink = driver.findElement(By.xpath("//span[text()='Article']"));
        wait.until(ExpectedConditions.visibilityOf(articleLink));
        Utils.jsClick(articleLink,driver);
        return this;
    }
    public ArrayList<Publication> read4Articles(){
        addPublicationToList(articles[0],publications);
        addPublicationToList(articles[1],publications);
        addPublicationToList(articles[2],publications);
        addPublicationToList(articles[3],publications);
        return publications;
    }

    public void addPublicationToList(String article, ArrayList<Publication> publications){
        driver.get(article);
        Publication publication = new Publication();
        publication.name = name.getText();
        publication.date = date.getText();
        publication.doi = doi.getText();
        driver.navigate().back();
//        System.out.println(publication);
        publications.add(publication);
    }

}
