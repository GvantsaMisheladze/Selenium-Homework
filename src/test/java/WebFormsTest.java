import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebFormsTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmisheladze\\Desktop\\Homework3\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement dropdown = driver.findElement(By.id("dropdowm-menu-1"));
        dropdown.click();
        WebElement option = driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-1\"]/option[3]"));
        option.click();
        String selectedOption =  dropdown.getAttribute("value");
        assert selectedOption.equals("python") : "The 'Python' option was not selected correctly. Selected option: " + selectedOption;

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[1]/input"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[2]/input"));
        WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[3]/input"));
        WebElement checkbox4 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[4]/input"));

        if (!checkbox1.isSelected()) checkbox1.click();
        if (!checkbox2.isSelected()) checkbox2.click();
        if (!checkbox3.isSelected()) checkbox3.click();
        if (!checkbox4.isSelected()) checkbox4.click();

        Assert.assertTrue(checkbox1.isSelected(), "Checkbox is not checked");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox is not checked");
        Assert.assertTrue(checkbox3.isSelected(), "Checkbox is not checked");
        Assert.assertTrue(checkbox4.isSelected(), "Checkbox is not checked");

        WebElement yellowRadioButton = driver.findElement(By.xpath("//*[@id=\"radio-buttons\"]/input[3]"));
        yellowRadioButton.click();

        WebElement dropdown1 = driver.findElement(By.id("fruit-selects"));
        dropdown1.click();
        WebElement orangeOption = driver.findElement(By.xpath("//*[@id=\"fruit-selects\"]/option[2]"));
        assert !orangeOption.isEnabled() : "The 'Orange' option is not disabled as expected.";
        Thread.sleep(2000);
        driver.quit();
    }
}