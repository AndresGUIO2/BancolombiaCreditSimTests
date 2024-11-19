package co.com.udea.certificacion.creditsim.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.SIMULATE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class ClickSimulate implements Task {

    private final Target target;

    public ClickSimulate(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isPresent()),
                Click.on(target)
        );
    }

    // Método para crear la tarea haciendo clic en el botón de simulación
    public static ClickSimulate clickOnSimulateButton() {
        return instrumented(ClickSimulate.class, SIMULATE_BUTTON);
    }
}
