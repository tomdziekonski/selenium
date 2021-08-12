import Base.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class PersonalInfoTest extends BaseClass {

    @BeforeTest
    public void beforeTest() {
        setBrowser();
    }

    @Test (priority = 1, description = "User is logging in")
    @Step ("Log In to OpenHRM")
    public void LogIn() throws InterruptedException, IOException {
        loggingIn("Admin", "admin123");
        assertion.assertTrue(tester.getTitle().equals("Orange0HRM"), "The title is incorrect");
    }

    @Test (priority = 2, description = "User is editing Personal Information")
    @Step ("Edit Personal Information")
    public void ItShouldBePossibleToEditEmployeeInformation() throws IOException, InterruptedException {
        utils.jsExecutor(main.OpenPersonalInfo());
        wait.until(ExpectedConditions.elementToBeClickable(info.EnableDisablePersonalInfoEditing()));
        Thread.sleep(2000);
        info.EditEmployeeData("Tom", "Tester", "666", "2000-11-15", "C:\\\\Users\\\\dziekonskit\\\\Desktop\\\\Java\\\\tstimg.jpg");
        utils.screen();
    }

    @Test (priority = 3, description = "User is logging out")
    @Step ("Log Out")
    public void LogOut(){
        main.AboutandLogout().click();
        main.LogOut().click();
    }

    @AfterTest
    public void close(){
        tester.close();
    }
}
