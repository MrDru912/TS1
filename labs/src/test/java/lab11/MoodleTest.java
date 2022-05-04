package lab11;

import lab10.TestCase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class MoodleTest extends TestCase {
    private WebDriver driver;

    @Test
    public void enterMoodlePage(){
        new MoodleMainPage(getDriver()).
                loginIntoMoodle()
                .goToTestCourse()
                .openPractises()
                .openTest()
                .attemptQuiz()
                .startAttempt()
                .fillTest()
                .LogOut1()
                .logOutForSure();
    }
}
