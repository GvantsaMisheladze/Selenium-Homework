package Elements;

import org.openqa.selenium.By;

public class CheckoutElements {
    public By firstName = By.id("billing_first_name");
    public By lastName = By.id("billing_last_name");
    public By companyName = By.id("billing_company");
    public By email = By.id("billing_email");
    public By phone = By.id("billing_phone");
    public By countryDropdown = By.id("select2-chosen-1");
    public By countryDropdownSearch = By.id("s2id_autogen1_search");
    public By countryDropdownSelectedOption = (By.xpath("//span[contains(text(),'Georgia')]"));
    public By address1 = By.id("billing_address_1");
    public By address2 = By.id("billing_address_2");
    public By city = By.id("billing_city");
    public By state = By.id("billing_state");
    public By postcode = By.id("billing_postcode");
    public By cashOnDeliveryOption = By.id("payment_method_cod");
    public By placeOrderButton = By.id("place_order");
}
