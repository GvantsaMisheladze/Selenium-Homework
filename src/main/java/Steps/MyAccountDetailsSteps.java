package Steps;

import Elements.MyAccountDetailsElements;
import Helpers.EmailPasswordGenerator;
import org.openqa.selenium.WebDriver;

public class MyAccountDetailsSteps extends MyAccountDetailsElements {
    WebDriver driver;

    public MyAccountDetailsSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void EnterFirstAndLstName(){
        driver.findElement(firstName).sendKeys("TestFirstName");
        driver.findElement(lastName).sendKeys("TestLastName");
    }

    public String ChangePassword(String oldPassword){
        String newPasswordStr = EmailPasswordGenerator.generateRandomPassword(15);
        driver.findElement(currentPassword).sendKeys(oldPassword);
        driver.findElement(newPassword).sendKeys(newPasswordStr);
        driver.findElement(confirmPassword).sendKeys(newPasswordStr);
        driver.findElement(saveChanges).click();
        return newPasswordStr;
    }

    public void SignOut(){
        driver.findElement(signOut).click();
    }
}
