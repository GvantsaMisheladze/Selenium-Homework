package Page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TablesPage {

    private final SelenideElement exampleTable = $("#table1");

    public String getUserBalance(String userName) {
        return exampleTable.$x(".//tr[td[text()='" + userName + "']]/td[4]").getText();
    }

    public boolean isUserPresent(String userName) {
        return exampleTable.$x(".//tr[td[text()='" + userName + "']]").exists();
    }

    public void printUserData() {
        ElementsCollection rows = exampleTable.$$("tr");
        rows.forEach(row -> {
            String rowText = row.$$("td").texts().toString();
            System.out.println(rowText);
        });
    }
}