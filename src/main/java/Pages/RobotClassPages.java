package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class RobotClassPages {
    private WebDriver driver;
    private By searchBarLocator = By.name("q");

    public RobotClassPages(WebDriver driver) {
        this.driver = driver;
    }

    public void typeUsingRobot(String text) throws AWTException, InterruptedException {
        WebElement searchBar = driver.findElement(searchBarLocator);
        searchBar.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Robot robot = new Robot();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                robot.keyPress(KeyEvent.VK_SHIFT);
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            } else {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
            }
            Thread.sleep(100);
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}

