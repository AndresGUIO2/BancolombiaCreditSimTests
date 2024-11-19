package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoanAmount implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        WebDriverWait wait = new WebDriverWait(
                actor.usingAbilityTo(BrowseTheWeb.class).getDriver(),
                Duration.ofSeconds(10)
        );

        String checkScript =
                "return document.querySelector('initial-layout') && " +
                        "document.querySelector('initial-layout').shadowRoot && " +
                        "document.querySelector('initial-layout').shadowRoot.querySelector('bbog-simulator-widget') && " +
                        "document.querySelector('initial-layout').shadowRoot.querySelector('bbog-simulator-widget').shadowRoot && " +
                        "document.querySelector('initial-layout').shadowRoot.querySelector('bbog-simulator-widget').shadowRoot.querySelector('bdb-credit-options') && " +
                        "document.querySelector('initial-layout').shadowRoot.querySelector('bbog-simulator-widget').shadowRoot.querySelector('bdb-credit-options').shadowRoot && " +
                        "document.querySelector('initial-layout').shadowRoot.querySelector('bbog-simulator-widget').shadowRoot.querySelector('bdb-credit-options').shadowRoot.querySelector('bdb-credit-information');";

        JavascriptExecutor js = ((JavascriptExecutor) actor.usingAbilityTo(BrowseTheWeb.class).getDriver());

        wait.until(driver -> {
            Boolean result = (Boolean) js.executeScript(checkScript);
            return result != null && result;
        });

        return (String) js.executeScript(
                "return document.querySelector('initial-layout')" +
                        ".shadowRoot.querySelector('bbog-simulator-widget')" +
                        ".shadowRoot.querySelector('bdb-credit-options')" +
                        ".shadowRoot.querySelector('bdb-credit-information')" +
                        ".getAttribute('simulationvalue');"
        );
    }

    public static Question<String> shown() {
        return new LoanAmount();
    }
}