package co.com.udea.certificacion.creditsim.tasks;

import static co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage.*;
import static co.com.udea.certificacion.creditsim.userinterfaces.HomeLoanPage.*;

import co.com.udea.certificacion.creditsim.interactions.TabManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;


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
                        Click.on(LOAN_BUTTON),
                        TabManager.switchToNewTabAndCloseOthers()
                );
                break;
            case "home loan button":
                actor.attemptsTo(
                        WaitUntil.the(HOME_LOAN_BUTTON , isPresent()),
                        WaitUntil.the(HOME_LOAN_BUTTON , isEnabled()),
                        WaitUntil.the(HOME_LOAN_BUTTON , isClickable()),
                        Click.on(HOME_LOAN_BUTTON )
                );
                break;

            case "simular":
                actor.attemptsTo(
                        WaitUntil.the(SIMULATE_BUTTON, isPresent()),
                        WaitUntil.the(SIMULATE_BUTTON, isEnabled()),
                        WaitUntil.the(SIMULATE_BUTTON, isClickable()),
                        Click.on(SIMULATE_BUTTON)
                );
                break;

            case "credit button":
                actor.attemptsTo(
                        WaitUntil.the(CREDIT_BUTTON, isPresent()),
                        WaitUntil.the(CREDIT_BUTTON, isEnabled()),
                        WaitUntil.the(CREDIT_BUTTON, isClickable()),
                        Click.on(CREDIT_BUTTON),
                        TabManager.switchToNewTabAndCloseOthers()
                );
                break;


            case "home value based button":
                actor.attemptsTo(
                        WaitUntil.the(HOME_VALUE_BASED_BUTTON , isPresent()),
                        WaitUntil.the(HOME_VALUE_BASED_BUTTON , isEnabled()),
                        WaitUntil.the(HOME_VALUE_BASED_BUTTON , isClickable()),
                        Click.on(HOME_VALUE_BASED_BUTTON)
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

    public static FindThe homeLoanButton() {
        return instrumented(FindThe.class, "home loan button");
    }

    public static FindThe creditButton () {
        return instrumented(FindThe.class, "credit button");
    }

    public static FindThe homeValueBasedButton () {
        return instrumented(FindThe.class, "home value based button");
    }
}