package Steps;

import Elements.RegisterElements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterSteps extends RegisterElements {
    WebDriver driver;
    Actions actions;

    public RegisterSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }

    public void enterPassword(String userPassword) {
        driver.findElement(password).sendKeys(userPassword);
    }

    public void clickEnter() {
        actions = new Actions(driver);
        WebElement passwordInput = driver.findElement(password);
        actions.moveToElement(passwordInput).click().sendKeys(Keys.RETURN).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(signOut));
    }
}
