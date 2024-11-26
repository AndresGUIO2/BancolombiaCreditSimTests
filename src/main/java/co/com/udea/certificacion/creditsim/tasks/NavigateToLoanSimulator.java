package co.com.udea.certificacion.creditsim.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToLoanSimulator implements Task {

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MENU_PRODUCTOS_LINK),
                WaitUntil.the(CREDITS_LINK, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CREDITS_LINK),
                WaitUntil.the(SIMULATION_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SIMULATION_BUTTON),
                WaitUntil.the(FREE_INVESTMENT_TEXT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CONTINUE_BUTTON)
        );
    }

    public static NavigateToLoanSimulator navigate() {
        return instrumented(NavigateToLoanSimulator.class);
    }
}
