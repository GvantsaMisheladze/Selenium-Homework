package Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;

public class ToolTipPage {

    private final SelenideElement hoverButton = $("#toolTipButton");
    private final SelenideElement tooltipText = $(".tooltip-inner");

    public void hoverOverButton() {
        hoverButton.scrollIntoView(true).hover();
    }

    public boolean isTooltipVisible() {
        tooltipText.shouldBe(Condition.visible, Duration.ofSeconds(3));
        return tooltipText.isDisplayed();
    }
}

