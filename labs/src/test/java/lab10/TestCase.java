package lab10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestCase {

    private  WebDriver driver;

    @BeforeEach
    public void init(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\andre\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterEach
    public void clean(){
        driver.quit();
    }

}
