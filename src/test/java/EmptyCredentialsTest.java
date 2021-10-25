import Base.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class EmptyCredentialsTest extends BaseClass {
    @BeforeTest
    public void beforeTestSetup() {
        setBrowser();
    }

    @Test(priority = 1, description = "User is logging in")
    @Step("Log In to OpenHRM")
    public void itShouldNotBePossibleToLogInWithEmptyUserCredentials() throws IOException {
        loggingIn("", "");
        WebElement message = tester.findElement(By.xpath("//span[contains(text(), 'Username cannot be empty')]"));
        assertion.assertTrue(message.isDisplayed(), "Empty credentials message is not displayed");
        assertion.assertAll();
    }

    @AfterTest
    public void closeTheBrowser() {
        tester.close();
    }

}
