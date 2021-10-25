import Base.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class MouseHoverTest extends BaseClass {

        @BeforeTest
        public void beforeTestSetup() {
            setBrowser();
        }

        @Test(priority = 1, description = "User is logging in")
        @Step("Log In to OpenHRM")
        public void logIn() throws InterruptedException, IOException {
            loggingIn("Admin", "admin123");
        }

        @Test(priority = 2, description = "User is hovering the cursor to read a pie chart")
        @Step("Reading a pie chart")
        public void mouseHover() throws IOException, InterruptedException {
            WebElement PieLabel = tester.findElement(By.xpath("//span[@id='pieLabel3']"));
            Actions actions = new Actions(tester);
            actions.moveToElement(PieLabel, -4, 50).build().perform();
            //actions.moveToElement(PieLabel, 45, 50).build().perform();

            Thread.sleep(5000);

            //WebElement ChartData = tester.findElement(By.xpath("//span[contains(text(), 'Engineering: 11 Employee(s) (27.50%)')]"));

        }

        @Test(priority = 3, description = "User is logging out")
        @Step("Log Out")
        public void logOut() {
            main.AboutandLogout().click();
            main.LogOut().click();
        }

        @AfterTest
        public void closeTheBrowser() {
            tester.close();
        }
    }

