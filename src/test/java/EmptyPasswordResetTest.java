import Base.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class EmptyPasswordResetTest extends BaseClass {

    @BeforeTest
    public void beforeTestSetup() {
        setBrowser();
    }

    @Test(priority = 1, description = "User is navigating to the Password Reset page")
    @Step("Open Password Reset")
    public void ItShouldNotBePossibleToResetUserPasswordWithoutProvidingUsername() throws IOException, InterruptedException {
        tester.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
        tester.findElement(By.xpath("//a[contains(text(), 'Forgot your password?')]")).click();
        tester.findElement(By.xpath("//input[@value='Reset Password']")).click();
        WebElement message = tester.findElement(By.xpath("//div[contains(text(), 'Could not find a user with given details')]"));
        assertion.assertTrue(message.isDisplayed(), "Empty field message is not displayed");
        assertion.assertAll();
    }

    @AfterTest
    public void closeTheBrowser() {
        tester.close();
    }
}
