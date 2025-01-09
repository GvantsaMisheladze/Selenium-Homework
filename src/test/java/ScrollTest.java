import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmisheladze\\Desktop\\Homework3\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/infinite_scroll");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Number initialScrollPosition = (Number) js.executeScript("return window.scrollY;");
        Number currentScrollPosition = 0;

        for(int i = 1; i <= 3; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            js.executeScript("window.scrollBy(0, 500);");
            currentScrollPosition = (Number) js.executeScript("return window.scrollY;");
            Assert.assertTrue(currentScrollPosition.longValue() > initialScrollPosition.longValue(), "The page did not scroll correctly.");
            initialScrollPosition = currentScrollPosition;
        }

        driver.quit();
    }
}
