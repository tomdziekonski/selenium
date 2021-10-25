package CucumberStepDefinition;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoggingOutTest extends BaseClass {
private WebElement LogOutMenu;
private WebElement LogOut;
private WebElement WebTitle;
private WebElement user;
private WebElement pass;
private WebElement login;

@Given("^User is logged in$")
    public void logCheck(){
    setBrowser();
    tester.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    user= tester.findElement((By.id("txtUsername")));
    pass = tester.findElement((By.id("txtPassword")));
    login = tester.findElement((By.id("btnLogin")));
    user.sendKeys("Admin");
    pass.sendKeys("admin123");
    login.click();
    WebTitle = tester.findElement(By.id("welcome"));
    String title = WebTitle.getText();
    assertion.assertEquals(title, "Welcome PaulRamRamRamRam");
    assertion.assertAll();
}
@When("^User clicks on the logout button$")
    public void logOutMenu(){
    LogOutMenu = tester.findElement(By.id("welcome"));
    LogOutMenu.click();
}
@Then("^User is logged out$")
    public void loggingOut(){
    LogOut = tester.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
    LogOut.click();
    assertion.assertTrue(user.isDisplayed());
    assertion.assertTrue(pass.isDisplayed());
    assertion.assertAll();
}
}
