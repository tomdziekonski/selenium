package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    private WebDriver driver;
    private XLSDataProvider reader;

    private String sheet = "C:\\Users\\dziekonskit\\IdeaProjects\\HRProject\\dataprovider.xlsx";

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void jsExecutor(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void JsExecutorScrollDown() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,100)");
    }

    public void screen() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH-mm-ss z");
        Date date = new Date(System.currentTimeMillis());
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("C:\\Users\\dziekonskit\\Desktop\\Java\\output\\" + formatter.format(date) + ".jpg"));
    }

    public ArrayList<Object[]> data() {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        try {
            reader = new XLSDataProvider("C:\\Users\\dziekonskit\\IdeaProjects\\HRProject\\dataprovider.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowNumber = 1; rowNumber <= reader.getXLSRowCount("Login"); rowNumber++) {
            String address = reader.getCellData("Login", 0, rowNumber);
            String city = reader.getCellData("Login", 1, rowNumber);
            String state = reader.getCellData("Login", 2, rowNumber);
            String code = reader.getCellData("Login", 3, rowNumber);
            String telephone = reader.getCellData("Login", 4, rowNumber);
            String mobile = reader.getCellData("Login", 5, rowNumber);
            String work = reader.getCellData("Login", 6, rowNumber);
            String email = reader.getCellData("Login", 7, rowNumber);

            Object ob[] = {address, city, state, code, telephone, mobile, work, email};
            data.add(ob);
        }
        return data;
    }
}


