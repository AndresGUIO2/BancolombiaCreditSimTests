package co.com.udea.certificacion.creditsim.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.creditsim.userinterfaces.HomeLoanPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class FindThe implements Task {
    private final String elementToFind;

    public FindThe(String elementToFind) {
        this.elementToFind = elementToFind;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (elementToFind.toLowerCase()) {
            case "loan button":
                actor.attemptsTo(
                        WaitUntil.the(LOAN_BUTTON, isClickable()),
                        Click.on(LOAN_BUTTON)
                );
                break;
            case "home value sim button":
                actor.attemptsTo(
                        WaitUntil.the(HOME_VALUE_SIM_BUTTON , isPresent()),
                        WaitUntil.the(HOME_VALUE_SIM_BUTTON , isEnabled()),
                        WaitUntil.the(HOME_VALUE_SIM_BUTTON , isClickable()),
                        Click.on(HOME_VALUE_SIM_BUTTON )
                );
                break;
        }
    }

    public static FindThe element(String elementToFind) {
        return instrumented(FindThe.class, elementToFind);
    }

    public static FindThe loanButton() {
        return instrumented(FindThe.class, "loan button");
    }

    public static FindThe homeValueSimButton() {
        return instrumented(FindThe.class, "home value sim button");
    }
}