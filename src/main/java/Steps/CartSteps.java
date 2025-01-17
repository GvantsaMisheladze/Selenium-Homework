package Steps;

import Elements.CartElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartSteps extends CartElements {
    WebDriver driver;

    public CartSteps(WebDriver driver) {
        this.driver = driver;
    }


    public void RemoveItemFromCart(){
        WebElement removeButtonElement = driver.findElement(removeButton);
        removeButtonElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(basketItemCount,  0 + " Items"));
        WebElement emptyCartElement = driver.findElement(emptyCartMessage);
        String expectedEmptyCartMessage = "Your basket is currently empty.";
        Assert.assertEquals(emptyCartElement.getText(), expectedEmptyCartMessage, "Item is not removed");
    }

    public void ReturnToShop(){
        WebElement returnButton = driver.findElement(returnToShopButton);
        returnButton.click();
    }

    public void ApplyCoupon(String couponCode){
        driver.findElement(cartInputField).sendKeys(couponCode);
        driver.findElement(applyCoupon).click();
        CheckCouponDetails(couponCode);
    }

    public void CheckCouponDetails(String couponCode){
        WebElement couponRow = driver.findElement(couponDetails);
        String couponDetailsText = couponRow.findElement(couponText).getText();
        Assert.assertEquals(couponDetailsText, "Coupon: " + couponCode, "Coupon text is incorrect: " + couponText);
        String discountValueText = couponRow.findElement(discountValue).getText();
        Assert.assertEquals(discountValueText, "₹50.00", "Coupon discount is incorrect: " + discountValue);
        String couponDetails = couponRow.getText();
        Assert.assertTrue(couponDetails.contains("Free shipping coupon"), "Free shipping coupon is not applied.");
    }

    public void RemoveCoupon(){
        WebElement removeCouponLink = driver.findElement(removeCoupon);
        removeCouponLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isCouponRemoved = wait.until(ExpectedConditions.invisibilityOfElementLocated(couponDetails));
        Assert.assertTrue(isCouponRemoved, "Failed to remove the coupon.");
    }

    public void ProceedToCheckout(){
        driver.findElement(proceedToCheckout).click();
    }
}
