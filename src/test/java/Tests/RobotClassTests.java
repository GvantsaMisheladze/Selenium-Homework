package Tests;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotClassTests {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmisheladze\\Desktop\\Homework5\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        Robot robot = new Robot();
        Thread.sleep(3000);

        String searchText = "Selenium Robot Class example";

        for (char c : searchText.toCharArray()) {
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

        Thread.sleep(3000);

        boolean firstLinkFocused = false;
        while (!firstLinkFocused) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(500);

            firstLinkFocused = true;
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(5000);
        driver.quit();
    }
}
