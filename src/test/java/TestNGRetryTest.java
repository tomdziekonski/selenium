import Base.BaseClass;
import Utils.TestNGRetryLogic;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestNGRetryTest extends BaseClass {

        @BeforeTest
        public void beforeTestSetup() {
            setBrowser();
        }

        @Test(priority = 1, description = "User is logging in")
        @Step("Log In to OpenHRM")
        public void LogIn() throws InterruptedException, IOException {
            loggingIn("Admpin", "admin123");
            WebElement message = tester.findElement(By.xpath("//span[contains(text(), 'Username cannot be empty')]"));
            assertion.assertTrue(message.isDisplayed(), "Empty credentials message is not displayed");
            assertion.assertAll();        }
}
