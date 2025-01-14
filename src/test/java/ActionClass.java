import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmisheladze\\Desktop\\Homework4\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/tool-tips");
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.id("toolTipButton"));
        action.moveToElement(element).click().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tooltip-inner")));

        String tooltipText = tooltip.getText();
        assert tooltipText.equals("You hovered over the button!") : "Tooltip text is incorrect. Expected: 'You hovered over the button!', but got: " + tooltipText;

        driver.quit();
    }
}