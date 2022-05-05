package lab11;

import lab10.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MoodleMainPage {
    private final WebDriver driver;
    @FindBy(how = How.ID, using = "username")
    private WebElement usernameForm;
    @FindBy(how = How.ID, using = "password")
    private WebElement passwordForm;
    @FindBy(how = How.NAME, using = "_eventId_proceed")
    private WebElement loginForm;

    public MoodleMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        driver.get("https://moodle.fel.cvut.cz/auth/shibboleth/index.php");
    }

    public MoodleLogedPage loginIntoMoodle(){
        Utils.fillInUsernameAndPassword(usernameForm,passwordForm,driver);
        usernameForm.sendKeys("");
        passwordForm.sendKeys("");
        Utils.jsClick(loginForm,driver);
        return new MoodleLogedPage(driver);
    }

}
