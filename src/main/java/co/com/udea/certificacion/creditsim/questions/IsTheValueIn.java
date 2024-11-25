package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage.*;

public class IsTheValueIn implements Question<Boolean> {

    private final String expectedValue;
    private final String input;

    public IsTheValueIn(String input, String expectedValue) {
        this.input = input;
        this.expectedValue = expectedValue;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String value;

        switch (input.toLowerCase()) {
            case "loan amount input":
                value = LOAN_AMOUNT_INPUT
                        .resolveFor(actor).getValue();
                return expectedValue.equals(value);

            case "percentage dropdown":
                value = PERCENT_INPUT
                        .resolveFor(actor).getText();
                return expectedValue.equals(value);

            default:
                return false;
        }
    }

    public static IsTheValueIn input(String input, String expectedValue) {
        return new IsTheValueIn(input, expectedValue);
    }
}