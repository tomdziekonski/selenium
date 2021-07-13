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
        loggingIn();
    }

    @Test (priority = 2, description = "User is editing Personal Information")
    @Step ("Edit Personal Information")
    public void PersonalInfo() throws IOException, InterruptedException {
        utils.jsExecutor(main.OpenPersonalInfo());
        wait.until(ExpectedConditions.elementToBeClickable(info.EnableDisablePersonalInfoEditing()));
        Thread.sleep(2000);
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
