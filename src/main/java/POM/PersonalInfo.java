package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonalInfo {

    private By EnableDisablePersonalInfoEditing = (By.id("btnSave"));
    private By firstName = (By.id("personal_txtEmpFirstName"));
    private By LastName = (By.id("personal_txtEmpLastName"));
    private By EmployeeID = (By.id("personal_txtEmployeeId"));
    private By MaleGender = (By.id("personal_optGender_1"));
    private By FemaleGender = (By.id("personal_optGender_2"));
    private By Date = (By.id("personal_txtLicExpDate"));
    private By Flag = (By.id("personal_chkSmokeFlag"));
    private By Nationality = (By.id("personal_cmbNation"));
    private By Image = (By.id("empPic"));
    private By InputFile = (By.id("photofile"));
    private By ContactDetails = (By.xpath("//a[contains(text(), 'Contact Details')]"));
    private By ContactAddress = (By.id("contact_street1"));
    private By ContactCity = (By.id("contact_city"));
    private By ContactState = (By.id("contact_province"));
    private By ContactPostalCode = (By.id("contact_emp_zipcode"));
    private By ContactTelephone = (By.id("contact_emp_hm_telephone"));
    private By ContactMobile = (By.id("contact_emp_mobile"));
    private By ContactWorkPhone = (By.id("contact_emp_work_telephone"));
    private By ContactEmail = (By.id("contact_emp_work_email"));

    private Select select;
    private WebElement element;
    private WebDriver driver;

    public PersonalInfo(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement EnableDisablePersonalInfoEditing() {
        return driver.findElement(EnableDisablePersonalInfoEditing);
    }

    public WebElement clearTextField(By elementId) {
        driver.findElement(elementId).clear();
        element = driver.findElement(elementId);
        return element;
    }

    public WebElement clickWebElement(By elementId){
        element = driver.findElement(elementId);
        element.click();
        return element;
    }

    public WebElement findWebElement(By elementId){
        element = driver.findElement(elementId);
        return element;
    }

    public void EditEmployeeData(String employeeFirstName, String employeeLastName, String employeeIDs, String date, String avatarFileDirectory){
        clickWebElement(EnableDisablePersonalInfoEditing);
        clickWebElement(firstName);
        clearTextField(firstName).sendKeys(employeeFirstName);
        clickWebElement(LastName);
        clearTextField(LastName).sendKeys(employeeLastName);
        clickWebElement(EmployeeID);
        clearTextField(EmployeeID).sendKeys(employeeIDs);
        clickWebElement(MaleGender);
        clickWebElement(Date);
        clearTextField(Date).sendKeys(date);
        clickWebElement(EnableDisablePersonalInfoEditing);
        clickWebElement(Image);
        findWebElement(InputFile).sendKeys(avatarFileDirectory);
        clickWebElement(EnableDisablePersonalInfoEditing);
    }

    public void OpenContactInfo(){
        clickWebElement(ContactDetails);
    }

    public void EditContactInfo(String address, String city, String state, String code, String phone, String mobile, String work, String mail){
        clickWebElement(EnableDisablePersonalInfoEditing);
        clearTextField(ContactAddress);
        clickWebElement(ContactAddress).sendKeys(address);
        clearTextField(ContactCity);
        clickWebElement(ContactCity).sendKeys(city);
        clearTextField(ContactState);
        clickWebElement(ContactState).sendKeys(state);
        clearTextField(ContactPostalCode);
        clickWebElement(ContactPostalCode).sendKeys(code);
        clearTextField(ContactTelephone);
        clickWebElement(ContactTelephone).sendKeys(phone);
        clearTextField(ContactMobile);
        clickWebElement(ContactMobile).sendKeys(mobile);
        clearTextField(ContactWorkPhone);
        clickWebElement(ContactWorkPhone).sendKeys(work);
        clearTextField(ContactEmail);
        clickWebElement(ContactEmail).sendKeys(mail);
        clickWebElement(EnableDisablePersonalInfoEditing);
    }
   }
