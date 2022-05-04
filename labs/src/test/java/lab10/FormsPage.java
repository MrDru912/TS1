package lab10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FormsPage {
    private final WebDriver driver;
    @FindBy(how = How.XPATH, using = "//span[text()='Practice Form']")
    private WebElement practiceForm;

    public FormsPage(WebDriver driver) {
        this.driver = driver;
    }

    public FormsPage clickPractiseForm(){
        practiceForm.click();
        return this;
    }
}
