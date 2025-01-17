package Elements;

import org.openqa.selenium.By;

public class MyAccountElements {
    public By shop = By.linkText("Shop");
    public By order = By.xpath("//li[contains(@class, 'woocommerce-MyAccount-navigation-link--orders')]/a");
    public By ordersTable = By.cssSelector("table.woocommerce-MyAccount-orders tbody");
    public By ordersTableRows = By.cssSelector("tr.order");
    public By orderNumber = By.cssSelector("td.order-number a");
    public By accountDetails = By.xpath("//li[contains(@class, 'woocommerce-MyAccount-navigation-link--edit-account')]/a");

}
