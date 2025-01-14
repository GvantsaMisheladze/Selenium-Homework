package Tests;

import Pages.WebTablesPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.WebTablesPages;

import java.util.List;
import org.openqa.selenium.WebElement;

public class WebTablesTests {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmisheladze\\Desktop\\Homework5\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/tables");

        WebTablesPages webTablesPages = new WebTablesPages(driver);

        List<WebElement> rows = webTablesPages.getTableRows();
        boolean frankExists = false;

        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

            String name = columns.get(1).getText();
            String balance = columns.get(3).getText();
            System.out.println("Name: " + name + ", Balance: " + balance);

            if (name.equals("Frank")) {
                frankExists = true;
            }
        }

        if (frankExists) {
            System.out.println("User Frank found in the table.");
        } else {
            System.out.println("User Frank not found in the table.");
        }

        driver.quit();
    }
}
