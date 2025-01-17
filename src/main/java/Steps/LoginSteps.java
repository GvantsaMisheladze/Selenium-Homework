package Steps;

import Elements.LoginElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps extends LoginElements {
    WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void Login(String email, String newPassword){
        driver.findElement(username).sendKeys(email);
        driver.findElement(password).sendKeys(newPassword);
        driver.findElement(login).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signOutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(signOut));

        Assert.assertTrue(signOutLink.isDisplayed(), "Login failed");
    }
}
