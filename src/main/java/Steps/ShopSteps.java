package Steps;

import Elements.ShopElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShopSteps extends ShopElements {
    WebDriver driver;
    Actions actions;

    public ShopSteps(WebDriver driver) {
        this.driver = driver;
    }


    public void ChangeSortingPriceLowToHigh(){
        Select select = new Select(driver.findElement(orderBy));
        select.selectByVisibleText("Sort by price: low to high");
    }

    public void CheckSorting(){
        List<WebElement> priceElements = driver.findElements(productPrices);

        List<Double> actualPrices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("₹", "").replace(",", "");
            actualPrices.add(Double.parseDouble(priceText));
        }

        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);

        Assert.assertEquals(actualPrices, sortedPrices, "Products are NOT sorted by price: low to high.");
    }

    private List<String> GetJSBooks(){
        List<WebElement> productElements = driver.findElements(productNames);

        List<String> matchingProducts = new ArrayList<>();

        for (WebElement productElement : productElements) {
            String productName = productElement.getText();
            if (productName.contains("JS") || productName.contains("JavaScript")) {
                matchingProducts.add(productName);
            }
        }

        return matchingProducts;
    }

    public void FilterByName(){
        List<String> bookBeforeFilter = GetJSBooks();
        Collections.sort(bookBeforeFilter);
        actions = new Actions(driver);
        WebElement filter = driver.findElement(filterSetting);
        filter.click();
        List<String> bookAfterFilter = GetJSBooks();
        Collections.sort(bookAfterFilter);
        Assert.assertEquals(bookBeforeFilter, bookAfterFilter, "Books are NOT filtered correctly.");
    }

    public void FilterByPrice(int targetMinPrice){
        WebElement leftSlider = driver.findElement(priceSliderLeftHandle);
        WebElement minPriceField = driver.findElement(minPriceInput);
        int currentMinPrice = Integer.parseInt(minPriceField.getAttribute("data-min"));

        int sliderRange = 350 - 150;
        int sliderWidth = driver.findElement(By.cssSelector(".price_slider")).getSize().getWidth();

        int pixelOffset = (int) (((double) (targetMinPrice - currentMinPrice) / sliderRange) * sliderWidth);

        Actions actions = new Actions(driver);
        actions.clickAndHold(leftSlider).moveByOffset(pixelOffset, 0).release().perform();

        driver.findElement(filterButton).click();

        Assert.assertEquals(1, GetJSBooks().size(), "Incorrect number of products");
    }

    public void AddAllProductsToBasket() {
        List<WebElement> buttons = driver.findElements(addToBasketButtons);

        for (WebElement button : buttons) {
            button.click();
        }

        Assert.assertTrue(IsBasketItemCountCorrect(buttons.size()), "Cart is not working correctly");
    }

    private boolean IsBasketItemCountCorrect(int expectedItemCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.textToBePresentInElementLocated(basketItemCount, expectedItemCount + " Item"),
                ExpectedConditions.textToBePresentInElementLocated(basketItemCount, expectedItemCount+ " Items")
        ));

        String itemCountText = driver.findElement(basketItemCount).getText();

        int actualItemCount = Integer.parseInt(itemCountText.split(" ")[0]);
        return actualItemCount == expectedItemCount;
    }

    public void ClickCart(){
        driver.findElement(cart).click();
    }

    public void AddSelectedProductsToCart(){
        List<String> selectedProducts = List.of("HTML5 Forms", "Selenium Ruby");

        List<WebElement> productElements = driver.findElements(product);

        for (WebElement product : productElements) {
            String productName = product.findElement(By.tagName("h3")).getText();

            if (selectedProducts.contains(productName)) {
                WebElement addToBasketButton = product.findElement(addToBasketButtons);
                addToBasketButton.click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.or(
                        ExpectedConditions.textToBePresentInElementLocated(basketItemCount, "Item"),
                        ExpectedConditions.textToBePresentInElementLocated(basketItemCount, "Items")
                ));
            }
        }

        Assert.assertTrue(IsBasketItemCountCorrect(selectedProducts.size()), "Selected products were not added to the cart correctly.");
    }
}
