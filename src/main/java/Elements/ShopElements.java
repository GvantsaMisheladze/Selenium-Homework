package Elements;

import org.openqa.selenium.By;

public class ShopElements {
    public By orderBy = By.className("orderby");
    public By productPrices = By.cssSelector(".price ins .woocommerce-Price-amount");
    public By productNames = By.cssSelector("h3");
    public By filterSetting = By.xpath("//a[text()='JavaScript']");
    public By priceSliderLeftHandle = By.xpath("(//span[contains(@class, 'ui-slider-handle')])[1]");
    public By minPriceInput = By.id("min_price");
    public By filterButton = By.cssSelector(".button[type='submit']");
    public By addToBasketButtons = By.cssSelector("a.add_to_cart_button");
    public By basketItemCount = By.cssSelector(".cartcontents");
    public By cart = By.id("wpmenucartli");
    public By product = By.cssSelector(".products .product");
}
