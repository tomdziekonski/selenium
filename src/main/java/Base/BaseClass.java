package Base;
import POM.Buzz;
import POM.LoginPage;
import POM.MainPage;
import POM.PersonalInfo;
import Utils.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public Properties prop = new Properties();
    public WebDriver tester;
    public SoftAssert assertion;
    public Utilities utils;
    public Buzz buzz;
    public WebDriverWait wait;
    public LoginPage logIn;
    public MainPage main;
    public PersonalInfo info;

    public void setBrowser(){
        try {
            prop = new Properties();
            FileInputStream input = new FileInputStream("C:\\Users\\dziekonskit\\IdeaProjects\\HRProject\\src\\main\\java\\Properties\\prop.properties");
            prop.load(input);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browser = prop.getProperty("browser");

        if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();

            tester = new FirefoxDriver();
            tester.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            tester.manage().window().maximize();
            wait = new WebDriverWait(tester, 5);
            assertion  = new SoftAssert();
            logIn = new LoginPage(tester);
            utils = new Utilities(tester);
            main = new MainPage(tester);
            info = new PersonalInfo(tester);
            buzz = new Buzz(tester);
        }

        else if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            tester = new ChromeDriver();
            tester.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            tester.manage().window().maximize();
            wait = new WebDriverWait(tester, 5);
            assertion  = new SoftAssert();
            logIn = new LoginPage(tester);
            utils = new Utilities(tester);
            main = new MainPage(tester);
            info = new PersonalInfo(tester);
            buzz = new Buzz(tester);
        }

        else if (browser.equals("ie")){
            WebDriverManager.iedriver().setup();
            tester = new InternetExplorerDriver();
            tester.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            tester.manage().window().maximize();
            wait = new WebDriverWait(tester, 5);
            assertion  = new SoftAssert();
            logIn = new LoginPage(tester);
            utils = new Utilities(tester);
            main = new MainPage(tester);
            info = new PersonalInfo(tester);
            buzz = new Buzz(tester);
        }

        else if (browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            tester = new EdgeDriver();
            tester.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            tester.manage().window().maximize();
            wait = new WebDriverWait(tester, 5);
            assertion  = new SoftAssert();
            logIn = new LoginPage(tester);
            utils = new Utilities(tester);
            main = new MainPage(tester);
            info = new PersonalInfo(tester);
            buzz = new Buzz(tester);
        }
    }

    public void loggingIn() throws IOException {
        tester.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        logIn.LogInUsername().click();
        logIn.LogInUsername().sendKeys("Admin");
        logIn.LogInPassword().click();
        logIn.LogInPassword().sendKeys("admin123");
        assertion.assertTrue(tester.getTitle().equals("Orange0HRM"), "The title is incorrect");
        utils.screen();
        logIn.ConfirmLogin().click();
        assertion.assertAll();
    }
}
