package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelpPage {

        private By AdminGuide = (By.xpath("//span[contains(text(), 'Admin User Guide')]"));
        private WebElement element;
        private WebDriver driver;

        public HelpPage(WebDriver driver) {
            this.driver = driver;
        }

        public WebElement OpenHelp() {
            element = driver.findElement(AdminGuide);
            return element;
        }

    }
