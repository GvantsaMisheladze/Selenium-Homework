import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class CommandsTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmisheladze\\Desktop\\Classwork\\src\\main\\resources\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        enableButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));
        assert inputField.isEnabled() : "Input field is not enabled";

        WebElement message = driver.findElement(By.id("message"));
        assert message.isDisplayed() : "'It's enabled!' message is not visible";
        assert enableButton.getText().equals("Disable") : "Button text did not change to 'Disable'";

        Thread.sleep(2000);
        inputField.sendKeys("Bootcamp");
        Thread.sleep(500);
        inputField.clear();

        Thread.sleep(2000);
        driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement columnA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-a")));
        WebElement columnB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-b")));

        Thread.sleep(2000);

        int aY = columnA.getLocation().getY();
        int bY = columnB.getLocation().getY();
        assert aY == bY : "Y coordinates of columns A and B do not match. A: " + aY + ", B: " + bY;
        Thread.sleep(2000);

        driver.quit();
    }
}