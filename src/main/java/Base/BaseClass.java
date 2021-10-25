package Base;

import POM.*;
import Utils.Utils;
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
    public Utils utils;
    public Buzz buzz;
    public WebDriverWait wait;
    public LoginPage logIn;
    public MainPage main;
    public PersonalInfo info;
    public HelpPage help;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();


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
            utils = new Utils(tester);
            main = new MainPage(tester);
            info = new PersonalInfo(tester);
            buzz = new Buzz(tester);
            help = new HelpPage(tester);
            tdriver.set(tester);
        }

        else if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            tester = new ChromeDriver();
            tester.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            tester.manage().window().maximize();
            wait = new WebDriverWait(tester, 5);
            assertion  = new SoftAssert();
            logIn = new LoginPage(tester);
            utils = new Utils(tester);
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
            utils = new Utils(tester);
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
            utils = new Utils(tester);
            main = new MainPage(tester);
            info = new PersonalInfo(tester);
            buzz = new Buzz(tester);
        }
    }

    public void loggingIn(String user, String password) throws IOException {
        tester.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        logIn.LogInUsername().click();
        logIn.LogInUsername().sendKeys(user);
        logIn.LogInPassword().click();
        logIn.LogInPassword().sendKeys(password);
        utils.screen();
        logIn.ConfirmLogin().click();
        //assertion.assertAll();
    }

    public static synchronized WebDriver getDriver(){
        return tdriver.get();
    }
}
