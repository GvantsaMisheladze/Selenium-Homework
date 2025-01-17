package Steps;
import Elements.CheckoutElements;
import org.openqa.selenium.WebDriver;


public class CheckoutSteps extends CheckoutElements {
    WebDriver driver;

    public CheckoutSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void FillCheckoutPageInfo(){
        // Fill out the billing form
        driver.findElement(firstName).sendKeys("TestFirstName");

        driver.findElement(lastName).sendKeys("TestLastName");

        driver.findElement(companyName).sendKeys("Credo");

        driver.findElement(phone).sendKeys("1234567890");

        driver.findElement(countryDropdown).click();
        driver.findElement(countryDropdownSearch).sendKeys("Georgia");
        driver.findElement(countryDropdownSelectedOption).click();

        driver.findElement(address1).sendKeys("Test address 1");

        driver.findElement(address2).sendKeys("Test address 2");

        driver.findElement(city).sendKeys("Tbilisi");

        driver.findElement(state).sendKeys("Tbilisi");

        driver.findElement(postcode).sendKeys("0183");

        driver.findElement(cashOnDeliveryOption).click();

        driver.findElement(placeOrderButton).click();
    }
}
