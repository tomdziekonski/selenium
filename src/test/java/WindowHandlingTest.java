import Base.BaseClass;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Set;

public class WindowHandlingTest extends BaseClass {

    @BeforeTest
    public void beforeTestSetup() {
        setBrowser();
    }

    @Test(priority = 1, description = "User is logging in")
    @Step("Log In to OpenHRM")
    public void LogIn() throws InterruptedException, IOException {
        loggingIn("Admin", "admin123");
        assertion.assertTrue(tester.getTitle().equals("Orange0HRM"), "The title is incorrect");
    }

    @Test(priority = 2, description = "User is clicking on the Help button")
    @Step("Launch the Help window")
    public void ItShouldBePossibleToLaunchTheHelpWindow() throws IOException, InterruptedException {
        utils.jsExecutor(main.HelpButton());
        String parent = tester.getWindowHandle();
        Set<String> windows = tester.getWindowHandles();
        for (String i : windows) {
            if (!i.equals(parent)) {
                String child = i;
                tester.switchTo().window(child);
                help.OpenHelp().click();
            }
        }
        tester.close();
        tester.switchTo().window(parent);
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


