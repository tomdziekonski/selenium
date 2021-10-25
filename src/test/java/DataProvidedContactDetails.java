import Base.BaseClass;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataProvidedContactDetails extends BaseClass {

    @BeforeTest
    public void beforeTestSetup() {
        setBrowser();
    }

    @Test(priority = 1, description = "User is logging in")
    @Step("Log In to OpenHRM")
    public void LogIn() throws InterruptedException, IOException {
        loggingIn("Admin", "admin123");
    }

    @DataProvider
    @Test(priority = 2, description = "Import data from Excel")
    @Step("Importing data from Excel")
    public Iterator<Object[]> getDataFromExcel() throws InterruptedException, IOException {
        ArrayList<Object[]> testData = utils.data();
        return testData.iterator();
    }

    @Test(dataProvider = "getDataFromExcel", priority = 3, description = "User is editing Contact Information")
    @Step("Edit Personal Information")
    public void ItShouldBePossibleToEditEmployeeContactInformation(String address, String city, String state, String code, String phone, String mobile, String work, String mail) throws IOException, InterruptedException {
        utils.jsExecutor(main.OpenPersonalInfo());
        info.OpenContactInfo();
        utils.JsExecutorScrollDown();
        info.EditContactInfo(address, city, state, code, phone, mobile, work, mail);

    }

    @Test(priority = 4, description = "User is logging out")
    @Step("Log Out")
    public void LogOut() {
        main.AboutandLogout().click();
        main.LogOut().click();
    }

    @AfterTest
    public void closeTheBrowser() {
        tester.close();
    }
}


