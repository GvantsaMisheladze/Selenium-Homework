package Elements;

import org.openqa.selenium.By;

public class OrderDetailsElements {
    public By discount = By.xpath("//tfoot//tr[th[contains(text(),'Discount')]]//td/span");
    public By roamingTax = By.xpath("//tfoot//tr[th[contains(text(),'Roaming Tax')]]//td/span");
    public By paymentMethod = By.xpath("//tfoot//tr[th[contains(text(),'Payment Method')]]//td");
    public By myAccount = By.id("menu-item-50");
    public By orderNumber = By.xpath("//li[contains(@class, 'order')]/strong");
}
