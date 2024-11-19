package co.com.udea.certificacion.creditsim.interactions;

import net.serenitybdd.core.pages.WaitForAngular;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitFor implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriverWait wait = new WebDriverWait(
                BrowseTheWeb.as(actor).getDriver(),
                Duration.ofSeconds(30)
        );

        wait.until(driver -> {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return Boolean.TRUE.equals(js.executeScript(
                    "return document.readyState === 'complete';"
            ));
        });
    }

    public static WaitFor load() {
        return Tasks.instrumented(WaitFor.class);
    }
}