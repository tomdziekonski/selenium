package Utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Utils {
private WebDriver driver;
        public Utils(WebDriver driver) {
            this.driver = driver;
        }

        public void jsExecutor(WebElement element) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }

        public void screen() throws IOException {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH-mm-ss z");
            Date date = new Date(System.currentTimeMillis());
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("C:\\Users\\dziekonskit\\Desktop\\Java\\output\\" + formatter.format(date) + ".jpg"));

        }
    }


