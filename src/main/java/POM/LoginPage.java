package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private By UserName = (By.id("txtUsername"));
    private By Password = (By.id("txtPassword"));
    private By ConfirmLogin = (By.id("btnLogin"));
    private WebElement element;
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
    this.driver = driver;
    }

    public WebElement LogInUsername() {
        element = driver.findElement(UserName);
        return element;
    }

    public WebElement LogInPassword() {
        element = driver.findElement(Password);
        return element;
    }

    public WebElement ConfirmLogin() {
        element = driver.findElement(ConfirmLogin);
        return element;
    }

}
