package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ToolTipPage {

    private final SelenideElement hoverButton = $("#toolTipButton");
    private final SelenideElement tooltipText = $(".tooltip-inner");

    public void hoverOverButton() {
        hoverButton.hover();
    }

    public boolean isTooltipVisible() {
        return tooltipText.isDisplayed();
    }
}
