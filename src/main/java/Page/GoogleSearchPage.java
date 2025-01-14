package Page;

import java.awt.*;
import java.awt.event.KeyEvent;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchPage {

    public void performSearchUsingRobot(String searchQuery) throws AWTException {
        Robot robot = new Robot();

        for (char c : searchQuery.toCharArray()) {
            if (Character.isUpperCase(c)) {
                robot.keyPress(KeyEvent.VK_SHIFT);
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            } else {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
            }
            sleep(100);
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        sleep(3000);
    }

    public void clickFirstLinkUsingRobot() throws AWTException {
        Robot robot = new Robot();

        boolean firstLinkFocused = false;
        while (!firstLinkFocused) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            sleep(500);

            firstLinkFocused = true;
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        sleep(5000);
    }
}
