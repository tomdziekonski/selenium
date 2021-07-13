package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Buzz {

    private By CommentField = (By.xpath("//textarea[@id='createPost_content']"));
    private By SaveButton = (By.xpath("//input[@id='postSubmitBtn']"));

    private WebElement element;
    private WebDriver driver;

    public Buzz(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement postContent() {
        driver.findElement(CommentField).clear();
        element = driver.findElement(CommentField);

        return element;
    }

    public WebElement savePost() {
        element = driver.findElement(SaveButton);

        return element;
    }
}
