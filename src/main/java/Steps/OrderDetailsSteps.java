package Steps;

import Elements.OrderDetailsElements;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrderDetailsSteps extends OrderDetailsElements {
    WebDriver driver;

    public OrderDetailsSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void CheckOrderDetails(){
        Assert.assertEquals(driver.findElement(discount).getText(), "₹50.00", "Discount is incorrect.");
        Assert.assertEquals(driver.findElement(roamingTax).getText(), "₹36.50", "Roaming Tax is incorrect.");
        Assert.assertEquals(driver.findElement(paymentMethod).getText(), "Cash on Delivery", "Payment Method is incorrect.");
    }

    public String GetOrderNumber(){
        return driver.findElement(orderNumber).getText();
    }

    public void GoToMyAccountPage(){
        driver.findElement(myAccount).click();
    }
}
