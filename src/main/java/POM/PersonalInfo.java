package POM;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonalInfo {

    private By EnableDisablePersonalInfoEditing = (By.id("btnSave"));
    private By FirstName = (By.id("personal_txtEmpFirstName"));
    private By LastName = (By.id("personal_txtEmpLastName"));
    private By EmployeeID = (By.id("personal_txtEmployeeId"));
    private By MaleGender = (By.id("personal_optGender_1"));
    private By FemaleGender = (By.id("personal_optGender_2"));
    private By Date = (By.id("personal_txtLicExpDate"));
    private By Flag = (By.id("personal_chkSmokeFlag"));
    private By Nationality = (By.id("personal_cmbNation"));
    private By Image = (By.id("empPic"));
    private By InputFile = (By.id("photofile"));


    private Select select;
    private WebElement element;
    private WebDriver driver;

    public PersonalInfo(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement EnableDisablePersonalInfoEditing() {
        return driver.findElement(EnableDisablePersonalInfoEditing);
    }

    public WebElement FirstName() {

        driver.findElement(FirstName).clear();
        element = driver.findElement(FirstName);
        return element;
    }

    public WebElement LastName() {
        driver.findElement(LastName).clear();
        element = driver.findElement(LastName);

        return element;
    }

    public WebElement EmployeeID() {
        return driver.findElement(EmployeeID);
    }

    public WebElement MaleGender() {
        return driver.findElement(MaleGender);
    }

    public WebElement FemaleGender() {
        return driver.findElement(FemaleGender);
    }

    public WebElement Date() {
        return driver.findElement(Date);
    }

    public WebElement Flag() {
        return driver.findElement(Flag);
    }

    public WebElement Nationality() {
        return driver.findElement(Nationality);
    }

    public WebElement SetAvatar() {
        return driver.findElement(InputFile);
    }

    public Select SetNationality() {
        select = new Select(driver.findElement(Nationality));
        return select;
    }

    public WebElement Pic() {
        return driver.findElement(Image);
    }


    public WebElement getEnableDisablePersonalInfoEditing() {

        return driver.findElement(EnableDisablePersonalInfoEditing);
    }
}
