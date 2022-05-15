import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinkSpringerLogIn {

     private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id='login-box-email']")
    private WebElement emailField;
    @FindBy(how = How.XPATH, using = "//input[@id='login-box-pw']")
    private WebElement password;
    @FindBy(how = How.XPATH, using = "//button[text()='Log in']")
    private WebElement button;

        public LinkSpringerLogIn(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(this.driver,this);
            driver.get("https://link.springer.com/signup-login");
        }


    public LinkSpringerSearch logIn(String email,String pw) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(emailField));
        wait.until(ExpectedConditions.visibilityOf(password));
        wait.until(ExpectedConditions.visibilityOf(button));

        emailField.sendKeys(email);
        password.sendKeys(pw);
        Utils.jsClick(button,driver);
//        button.click();
        return new LinkSpringerSearch(driver);
    }
}
