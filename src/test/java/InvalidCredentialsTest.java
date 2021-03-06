import Base.BaseClass;
import io.qameta.allure.Step;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;


public class InvalidCredentialsTest extends BaseClass {
    private Logger LOGGER = Logger.getLogger(InvalidCredentialsTest.class);
    @BeforeTest
    public void beforeTestSetup() {
        setBrowser();
    }

    @Test(priority = 1, description = "User is logging in")
    @Step("Log In to OpenHRM")
    public void itShouldNotBePossibleToLogInWithAnInvalidUsername() throws IOException {
        LOGGER.setLevel(Level.DEBUG);
        LOGGER.debug("DEBUG TEST");
        loggingIn("Adm5in", "admin123");
        WebElement message = tester.findElement(By.xpath("//span[contains(text(), 'Invalid credentials')]"));
        assertion.assertTrue(message.isDisplayed(), "Invalid credentials message is not displayed");
        assertion.assertAll();
            }

    @AfterTest
    public void closeTheBrowser() {
        tester.close();
    }
}
