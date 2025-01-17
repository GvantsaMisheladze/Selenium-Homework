package Elements;

import org.openqa.selenium.By;

public class MyAccountDetailsElements {
    public By firstName = By.id("account_first_name");
    public By lastName = By.id("account_last_name");
    public By currentPassword = By.id("password_current");
    public By newPassword = By.id("password_1");
    public By confirmPassword = By.id("password_2");
    public By saveChanges = By.name("save_account_details");
    public By signOut = By.cssSelector("a[href='https://practice.automationtesting.in/my-account/customer-logout/']");
}
