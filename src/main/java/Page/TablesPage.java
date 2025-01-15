package Page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class TablesPage {

    private final SelenideElement table = $("#table1");

    public ElementsCollection getRows() {
        return table.$$("tr");
    }

    public void printUserData() {
        ElementsCollection rows = getRows();

        for (int i = 1; i < rows.size(); i++) {
            ElementsCollection columns = rows.get(i).$$("td");

            String name = columns.get(1).getText();
            String balance = columns.get(3).getText();

            System.out.println("Name: " + name + ", Balance: " + balance);
        }
    }

    public boolean isUserPresent(String userName) {
        ElementsCollection rows = getRows();
        for (int i = 1; i < rows.size(); i++) {
            ElementsCollection columns = rows.get(i).$$("td");
            String name = columns.get(1).getText();
            if (name.equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
