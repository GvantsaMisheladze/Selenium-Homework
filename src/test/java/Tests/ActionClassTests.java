package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.ActionClassPages;

public class ActionClassTests {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmisheladze\\Desktop\\Homework5\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://demoqa.com/tool-tips");

        ActionClassPages actionClassPages = new ActionClassPages(driver);

        String tooltipText = actionClassPages.getToolTipText();
        assert tooltipText.equals("You hovered over the button!") : "Tooltip text is incorrect. Expected: 'You hovered over the button!', but got: " + tooltipText;

        driver.quit();
    }
}