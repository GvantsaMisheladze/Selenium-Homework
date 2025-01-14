package Task6Tests;

import Page.TablesPage;
import Page.ToolTipPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import Page.TablesPage;
import Page.ToolTipPage;
import Page.GoogleSearchPage;

import java.awt.*;

import static com.codeborne.selenide.Selenide.*;

public class Task6Tests {

    @BeforeAll
    public static void setup() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testTablePage() {
        open("https://the-internet.herokuapp.com/tables");
        TablesPage tablePage = new TablesPage();

        tablePage.printUserData();
        String balance = tablePage.getUserBalance("Frank");
        System.out.println("Frank's balance: " + balance);

        boolean isFrankPresent = tablePage.isUserPresent("Frank");
        System.out.println("Is Frank present: " + isFrankPresent);
    }

    @Test
    public void testTooltipPage() {
        open("https://demoqa.com/tool-tips");
        ToolTipPage tooltipPage = new ToolTipPage();

        tooltipPage.hoverOverButton();
        boolean isTooltipVisible = tooltipPage.isTooltipVisible();
        System.out.println("Is tooltip visible: " + isTooltipVisible);
    }

    @Test
    public void testRobotClassForGoogleSearch() throws AWTException {
        open("https://www.google.com");
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();

        googleSearchPage.performSearchUsingRobot("Selenium Robot Class example");
        googleSearchPage.clickFirstLinkUsingRobot();
    }
}