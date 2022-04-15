package lab09;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaTests extends TestCase{

    private WebDriver driver;

    @Test
    public void openDemoQA(){
        WebDriver driver = getDriver();
        driver.get("https://demoqa.com/");
    }

    @Test
    public void finalElementTest(){
        WebDriver driver = getDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastNameXpath = driver.findElement(By.xpath("//div//input[@id='lastName']"));
        System.out.println();
    }

    @Test
    public void fillFormTest(){
        WebDriver driver = getDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastNameXpath = driver.findElement(By.xpath("//div//input[@id='lastName']"));
        WebElement email = driver.findElement(By.xpath("//div//input[@id='userEmail']"));
        WebElement phoneNumber = driver.findElement(By.xpath("//div//input[@id='userNumber']"));
        WebElement gender = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));

        lastNameXpath.sendKeys("Mamaev");
        firstName.sendKeys("Andrei");
        email.sendKeys("mamaev@gmail.com");
        phoneNumber.sendKeys("+42077302020");
        gender.click();

        System.out.println();

    }
}
