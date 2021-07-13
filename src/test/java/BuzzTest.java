import Base.BaseClass;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class BuzzTest extends BaseClass {

    @BeforeTest
    public void beforeTest() {
        setBrowser();
    }

    @Test(priority = 1, description = "User is logging in")
    @Step("Log In to OpenHRM")
    public void LogIn() throws InterruptedException, IOException {
        loggingIn();
    }

    @Test(priority = 2, description = "User is writing a post")
    @Step("Writing a post")
    public void WriteAPost() throws IOException, InterruptedException {
        utils.jsExecutor(main.Buzz());
        buzz.postContent().click();
        buzz.postContent().sendKeys("I am writing a post");
        buzz.savePost().click();
    }

    @Test(priority = 3, description = "User is logging out")
    @Step("Log Out")
    public void LogOut() {
        main.AboutandLogout().click();
        main.LogOut().click();
    }

    @AfterTest
    public void close() {
        tester.close();
    }
}