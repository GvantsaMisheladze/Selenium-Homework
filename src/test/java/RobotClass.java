import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class RobotClass {
    public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmisheladze\\Desktop\\Homework4\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.navigate().to(" https://www.google.com");
        WebElement searchBar = driver.findElement(By.id("APjFqb"));
        searchBar.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Robot robot = new Robot();

        String textToType = "Selenium Robot Class example";

        for (char c : textToType.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        boolean isFirstResultFocused = false;
        while (!isFirstResultFocused) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            Thread.sleep(500);

            WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"S0lXRd\"]/div/div/div[1]/div/div/span/a/h3"));
            isFirstResultFocused = firstResult.equals(driver.switchTo().activeElement());
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}