package co.com.udea.certificacion.creditsim.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TabManager implements Interaction {

    private final boolean closeOthers;

    public TabManager(boolean closeOthers) {
        this.closeOthers = closeOthers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        String currentTab = tabs.get(tabs.size() - 1);
        driver.switchTo().window(currentTab);

        if (closeOthers && tabs.size() > 1) {
            for (String tab : tabs) {
                if (!tab.equals(currentTab)) {
                    driver.switchTo().window(tab);
                    driver.close();
                }
            }
            driver.switchTo().window(currentTab);
        }
    }

    public static TabManager switchToNewTab() {
        return instrumented(TabManager.class, false);
    }

    public static TabManager switchToNewTabAndCloseOthers() {
        return instrumented(TabManager.class, true);
    }
}