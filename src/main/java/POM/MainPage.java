package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {


    private By PersonalInfo = (By.id("menu_pim_viewMyDetails"));
    private By AboutandLogoutButton = (By.id("welcome"));
    private By BuzzPage = (By.id("menu_buzz_viewBuzz"));
    private By Logout = (By.xpath("//a[contains(.,'Logout')]"));
    private By Maintenance = (By.xpath("//a[text()='Access Records']"));
    private WebElement element;
    private WebDriver driver;



    public MainPage(WebDriver driver) {
    this.driver = driver;
    }

    public WebElement OpenPersonalInfo() {
        element = driver.findElement(PersonalInfo);
        return element;
    }

    public WebElement OpenMaintenance() {
        element = driver.findElement(Maintenance);
        return element;
    }

    public WebElement AboutandLogout() {
        element = driver.findElement(AboutandLogoutButton);
        return element;
    }

    public WebElement LogOut() {
        element = driver.findElement(Logout);

        return element;
    }

    public WebElement Buzz() {
        element = driver.findElement(BuzzPage);

        return element;
    }

}
