package Steps;

import Elements.MyAccountElements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MyAccountSteps extends MyAccountElements {
    WebDriver driver;
    Actions actions;

    public MyAccountSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void clickShop() {
        actions = new Actions(driver);
        WebElement shopButton = driver.findElement(shop);
        actions.moveToElement(shopButton).click().sendKeys(Keys.RETURN).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public  void ClickOrders(){
        driver.findElement(order).click();
    }

    public void CheckOrderPresence(String orderNumberStr){
        WebElement orders = driver.findElement(ordersTable);
        List<WebElement> rows = orders.findElements(ordersTableRows);

        boolean isOrderFound = false;
        for (WebElement row : rows) {
            WebElement orderNumberElement = row.findElement(orderNumber);
            String orderNumberText = orderNumberElement.getText().replace("#", "");

            if (orderNumberText.equals(orderNumberStr)) {
                isOrderFound = true;
                break;
            }
        }

        Assert.assertTrue(isOrderFound, "Order is not present in orders list");
    }

    public void ClickAccountDetails(){
        driver.findElement(accountDetails).click();
    }
}
