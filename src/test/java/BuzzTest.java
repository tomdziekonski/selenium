import Base.BaseClass;
import Utils.AllureListener;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

@Listeners({AllureListener.class})
public class BuzzTest extends BaseClass {

    @BeforeTest
    public void beforeTestSetup() {
        setBrowser();
    }

    @Test(priority = 1, description = "User is logging in")
    @Step("Log In to OpenHRM")
    public void LogIn() throws InterruptedException, IOException {
        loggingIn("Admin", "admin123");
    }

    @Test(priority = 2, description = "User is writing a post")
    @Step("Writing a post")
    public void itShouldBePossibleToWriteAPost() throws IOException, InterruptedException {
        String element = main.AboutandLogout().getText();

        System.out.println(element);
        assertion.assertTrue(element.equals("Welcome Tom0"), "Incorrect welcome message");

        utils.jsExecutor(main.Buzz());
        buzz.postContent().click();
        buzz.postContent().sendKeys("I am writing a post");
        buzz.savePost().click();
        assertion.assertAll();

    }

    @Test(priority = 3, description = "User is logging out")
    @Step("Log Out")
    public void LogOut() {
        main.AboutandLogout().click();
        main.LogOut().click();
    }

    @AfterTest
    public void closeTheBrowser() {
        tester.close();
    }
}