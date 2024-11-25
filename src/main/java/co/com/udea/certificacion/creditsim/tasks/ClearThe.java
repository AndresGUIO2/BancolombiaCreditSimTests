package co.com.udea.certificacion.creditsim.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage.*;

public class ClearThe implements Task {
    private final Target target;

    public ClearThe(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isPresent()),
                Click.on(target),
                Clear.field(target)
        );
    }

    public static ClearThe loanAmountInput() {
        return instrumented(ClearThe.class, LOAN_AMOUNT_INPUT);
    }
}

