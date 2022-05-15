import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class DataHelper{

    public static void main(String[] args) {
        List<Publication> publications = getPublications();
        System.out.println(publications);
        System.out.println(publications.size());
    }

    static public List<Publication> getPublications(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\andre\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        List<Publication> publications = new LinkSpringerAdvancedSearch(driver)
                .search()
                .goToArticles()
                .read4Articles();

        driver.quit();
        return publications;
    }
}
