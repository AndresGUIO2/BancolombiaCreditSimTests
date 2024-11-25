package co.com.udea.certificacion.creditsim.tasks;

import co.com.udea.certificacion.creditsim.interactions.PickThe;
import co.com.udea.certificacion.creditsim.interactions.SelectDate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.creditsim.interactions.PickThe.valueFromDropdown;
import static co.com.udea.certificacion.creditsim.interactions.SelectDate.with;
import static co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class EnterThe implements Task {
    private final String value;
    private final Target target;

    public EnterThe(String value, Target target) {
        this.value = value;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    WaitUntil.the(target, isPresent()),
                    Click.on(target),
                    SendKeys.of(value).into(target)
            );
    }

    public static EnterThe commercialValue(String value) {
        return instrumented(EnterThe.class, value, COMMERCIAL_VALUE_INPUT);
    }

    public static EnterThe percent(String value) {
        Target option = Target.the("Percentage option")
                .locatedBy("//mat-option/span[contains(text(), '" + value + "')]");
        return new EnterThe(value, PERCENT_INPUT) {
            @Override
            public <T extends Actor> void performAs(T actor) {
                actor.attemptsTo(
                        valueFromDropdown(PERCENT_INPUT, option)
                );
            }
        };
    }

    public static EnterThe loanAmount(String value) {
        return instrumented(EnterThe.class, value, LOAN_AMOUNT_INPUT);
    }

    public static EnterThe desiredTerm(String value) {
        return instrumented(EnterThe.class, value, DESIRED_TERM_INPUT);
    }

    public static EnterThe birthdate(String value) {
        return new EnterThe(value, BIRTHDATE_INPUT) {
            String[] dateParts = value.split("/");
            @Override
            public <T extends Actor> void performAs(T actor) {
                actor.attemptsTo(
                        with(dateParts[2], dateParts[1], dateParts[0])
                );
            }
        };
    }
}