package Tests;

import Helpers.EmailPasswordGenerator;
import Steps.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineShopTests extends EmailPasswordGenerator{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmisheladze\\Desktop\\Homework8\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in//my-account");

        RegisterSteps register = new RegisterSteps(driver);
        MyAccountSteps myAccount = new MyAccountSteps(driver);
        ShopSteps shop = new ShopSteps(driver);
        CartSteps cart = new CartSteps(driver);
        CheckoutSteps checkout = new CheckoutSteps(driver);
        OrderDetailsSteps orderDetails = new OrderDetailsSteps(driver);
        MyAccountDetailsSteps myAccountDetails = new MyAccountDetailsSteps(driver);
        LoginSteps login = new LoginSteps(driver);

        String password = EmailPasswordGenerator.generateRandomPassword(15);
        String email = EmailPasswordGenerator.generateRandomEmail();
        register.enterEmail(email);
        register.enterPassword(password);
        register.clickEnter();

        myAccount.clickShop();

        shop.ChangeSortingPriceLowToHigh();
        shop.CheckSorting();
        shop.FilterByName();
        shop.FilterByPrice(300);
        shop.AddAllProductsToBasket();
        shop.ClickCart();

        cart.RemoveItemFromCart();
        cart.ReturnToShop();

        shop.AddSelectedProductsToCart();
        shop.ClickCart();

        cart.ApplyCoupon("krishnasakinala");
        cart.RemoveCoupon();
        cart.ApplyCoupon("krishnasakinala");
        cart.ProceedToCheckout();

        checkout.FillCheckoutPageInfo();

        orderDetails.CheckOrderDetails();
        String orderNumber = orderDetails.GetOrderNumber();
        orderDetails.GoToMyAccountPage();

        myAccount.ClickOrders();
        myAccount.CheckOrderPresence(orderNumber);
        myAccount.ClickAccountDetails();

        myAccountDetails.EnterFirstAndLstName();
        String newPassword = myAccountDetails.ChangePassword(password);
        myAccountDetails.SignOut();

        login.Login(email, newPassword);

        driver.quit();
    }
}