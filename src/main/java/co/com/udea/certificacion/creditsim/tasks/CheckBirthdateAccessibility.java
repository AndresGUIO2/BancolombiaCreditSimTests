package co.com.udea.certificacion.creditsim.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.BIRTHDATE_INPUT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckBirthdateAccessibility implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BIRTHDATE_INPUT) // Abre el datepicker
        );
    }

    public static CheckBirthdateAccessibility onDatepicker() {
        return instrumented(CheckBirthdateAccessibility.class);
    }
}
