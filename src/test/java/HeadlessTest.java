import Base.BaseClass;
import POM.LoginPage;
import Utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class HeadlessTest extends BaseClass {
    @BeforeTest
    public void beforeTestSetup() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Test(priority = 1, description = "User is logging in")
    @Step("Log In to OpenHRM")
    public void LogIn() throws InterruptedException, IOException {
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments("--headless");
    tester = new FirefoxDriver(options);
    logIn = new LoginPage(tester);
    utils = new Utils(tester);

    loggingIn("Admin", "admin123");
    System.out.println(tester.getTitle());
    }
}
