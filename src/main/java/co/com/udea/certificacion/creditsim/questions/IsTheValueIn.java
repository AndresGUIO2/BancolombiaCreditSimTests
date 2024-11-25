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

            case "housing leasing fixed fee label":
                value = HOUSING_LEASING_FIXED_FEE_LABEL
                        .resolveFor(actor).getText();
                return expectedValue.equals(value);

            case "housing leasing constant capital label":
                value = HOUSING_LEASING_CONSTANT_CAPITAL_LABEL
                        .resolveFor(actor).getText();
                return expectedValue.equals(value);

            case "housing loan fixed fee label":
                value = HOUSING_LOAN_FIXED_FEE_LABEL
                        .resolveFor(actor).getText();
                System.out.println(value);
                System.out.println(expectedValue);
                return expectedValue.equals(value);

            case "housing loan constant capital label":
                value = HOUSING_LOAN_CONSTANT_CAPITAL_LABEL
                        .resolveFor(actor).getText();
                System.out.println(value);
                System.out.println(expectedValue);
                return expectedValue.equals(value);

            case "housing loan constant fee label":
                value = HOUSING_LOAN_CONSTANT_FEE_LABEL
                        .resolveFor(actor).getText();
                System.out.println(value);
                System.out.println(expectedValue);
                return expectedValue.equals(value);

            default:
                return false;
        }
    }

    public static IsTheValueIn input(String input, String expectedValue) {
        return new IsTheValueIn(input, expectedValue);
    }
}