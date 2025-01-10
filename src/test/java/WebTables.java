import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTables {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmisheladze\\Desktop\\Homework4\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/tables");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table1")));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        boolean frankExists = false;
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> columns = row.findElements(By.tagName("td"));

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