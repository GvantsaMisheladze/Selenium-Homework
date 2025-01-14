package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionClassPages {
    private WebDriver driver;
    private Actions actions;

    private static WebElement button = null;

    public ActionClassPages(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    private void hoverOverButton() {
        button = driver.findElement(By.id("toolTipButton"));
        actions.moveToElement(button).perform();
    }

    public String getToolTipText() {
        hoverOverButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tooltip-inner")));

        return tooltip.getText();
    }
}
