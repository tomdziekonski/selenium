package POM;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    public By getPersonalInfo() {
        return PersonalInfo;
    }

    public By getAboutandLogoutButton() {
        return AboutandLogoutButton;
    }

    public By getLogout() {
        return Logout;
    }


    private By PersonalInfo = (By.id("menu_pim_viewMyDetails"));
    private By AboutandLogoutButton = (By.id("welcome"));
    private By Logout = (By.xpath("//a[contains(.,'Logout')]"));
    private WebElement element;
    private WebDriver driver;

    public MainPage(WebDriver driver) {
    this.driver = driver;
    }

    public WebElement OpenPersonalInfo() {
        element = driver.findElement(PersonalInfo);
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

}
