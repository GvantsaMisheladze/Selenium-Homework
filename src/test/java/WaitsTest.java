import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WaitsTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmisheladze\\Desktop\\Homework3\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/progress-bar");
        WebElement startStopButton = driver.findElement(By.id("startStopButton"));
        startStopButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement progressBar = driver.findElement(By.cssSelector("#progressBar > div"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#progressBar > div"), "100"));
        String progressValue = progressBar.getAttribute("aria-valuenow");
        Assert.assertEquals(progressValue, "100", "Is not equal");
        System.out.println("100%");
        driver.quit();
    }
}
