import POM.LoginPage;
import POM.MainPage;
import POM.PersonalInfo;
import Utils.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class PersonalInfoTestNG {
    private WebDriver tester;
    private Utilities utils;
    private LoginPage logIn;
    private MainPage main;
    private PersonalInfo info;
    private WebDriverWait wait;
    private SoftAssert soft;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.firefoxdriver().setup();
        tester = new FirefoxDriver();
        tester.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils = new Utilities(tester);
        logIn = new LoginPage(tester);
        main = new MainPage(tester);
        info = new PersonalInfo(tester);
        wait = new WebDriverWait(tester, 5);
        soft = new SoftAssert();
    }

    @Test (priority = 1)
    public void LogIn() throws InterruptedException, IOException {
        tester.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        tester.manage().window().maximize();

        logIn.LogInUsername().click();
        logIn.LogInUsername().sendKeys("Admin");
        logIn.LogInPassword().sendKeys("admin123");
        logIn.LogInPassword().click();
        utils.screen();
        logIn.ConfirmLogin().click();

    }

    @Test (priority = 2)
    public void PersonalInfo() throws IOException {

        utils.jsExecutor(main.OpenPersonalInfo());

        wait.until(ExpectedConditions.elementToBeClickable(info.EnableDisablePersonalInfoEditing()));

        info.EnableDisablePersonalInfoEditing().click();
        info.FirstName().sendKeys("Tom");
        info.LastName().sendKeys("Tester");
        info.EmployeeID().clear();
        info.EmployeeID().sendKeys("666");
        info.FemaleGender().click();
        info.Date().clear();
        info.Date().sendKeys("2000-11-15");
        info.EnableDisablePersonalInfoEditing().click();
        info.Pic().click();
        info.SetAvatar().sendKeys("C:\\Users\\dziekonskit\\Desktop\\Java\\tstimg.jpg");
        info.EnableDisablePersonalInfoEditing().click();
        utils.screen();
    }

    @Test (priority = 3)
    public void LogOut(){
        main.AboutandLogout().click();
        main.LogOut().click();

    }

    @AfterTest
    public void close(){
        tester.close();

    }
}
