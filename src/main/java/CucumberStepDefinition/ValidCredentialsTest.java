package CucumberStepDefinition;

import Base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class ValidCredentialsTest extends BaseClass {
    private WebElement user;
    private WebElement pass;
    private WebElement login;

    @Given("^User opens the Login Page$")
    public void openLoginPage() throws IOException {
        setBrowser();
        tester.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }

    @When("^Login Page web elements are available$")
    public void checkWebElements() {
        user= tester.findElement((By.id("txtUsername")));
        pass = tester.findElement((By.id("txtPassword")));
        login = tester.findElement((By.id("btnLogin")));
        assertion.assertTrue(user.isDisplayed());
        assertion.assertTrue(pass.isDisplayed());
        assertion.assertAll();
    }
    @Then("^User provides a valid Username, valid Password and clicks on the Login button$")
    public void enterCredentials(){
        user.sendKeys("Admin");
        pass.sendKeys("admin123");
        login.click();
    }

    @And("^User lands on the Home Page$")
    public void homePageValidation(){
        WebElement WebTitle = tester.findElement(By.id("welcome"));
        String title = WebTitle.getText();
        assertion.assertEquals(title, "Welcome PaulRamRamRamRam");
        assertion.assertAll();
    }
}



