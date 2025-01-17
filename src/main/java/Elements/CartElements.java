package Elements;

import org.openqa.selenium.By;

public class CartElements {
    public By removeButton = By.cssSelector("tr.cart_item .product-remove a.remove");
    public By basketItemCount = By.cssSelector(".cartcontents");
    public By emptyCartMessage = By.cssSelector(".cart-empty");
    public By returnToShopButton = By.cssSelector(".return-to-shop .wc-backward");
    public By cartInputField = By.id("coupon_code");
    public By applyCoupon = By.name("apply_coupon");
    public By couponDetails = By.cssSelector(".cart-discount.coupon-krishnasakinala");
    public By couponText = By.tagName("th");
    public By discountValue = By.cssSelector("td span.woocommerce-Price-amount");
    public By removeCoupon = By.linkText("[Remove]");
    public By proceedToCheckout = By.cssSelector(".wc-proceed-to-checkout .checkout-button");
}
