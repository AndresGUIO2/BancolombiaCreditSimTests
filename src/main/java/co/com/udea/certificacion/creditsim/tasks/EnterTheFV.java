package co.com.udea.certificacion.creditsim.tasks;

import co.com.udea.certificacion.creditsim.interactions.SelectDateFromDatePicker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.AMOUNT_INPUT;
import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.DEADLINE_INPUT;

import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.BIRTHDATE_INPUT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;


public class EnterTheFV implements Task {
    private final String value;
    private final Target target;

    public EnterTheFV(String value, Target target) {
        this.value = value;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (target.equals(BIRTHDATE_INPUT)) {
            actor.attemptsTo(
                    Click.on(target)
            );
            actor.attemptsTo(
                    SelectDateFromDatePicker.withDate(value)
            );
        } else {
            actor.attemptsTo(
                    Clear.field(target),
                    WaitUntil.the(target, isPresent()),
                    Click.on(target),
                    SendKeys.of(value).into(target)
            );
        }
    }

    public static EnterTheFV amount(String value) {return instrumented(EnterTheFV.class, value, AMOUNT_INPUT);}

    public static EnterTheFV birthdate(String value) {return instrumented(EnterTheFV.class, value, BIRTHDATE_INPUT);}

    public static EnterTheFV deadline(String value) {return instrumented(EnterTheFV.class, value, DEADLINE_INPUT);}



}
