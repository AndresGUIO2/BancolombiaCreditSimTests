package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage.*;

public class IsErrorMessageDisplayed implements Question<Boolean> {

    private final String expectedErrorMessage;
    private final String errorLabel;

    public IsErrorMessageDisplayed(String errorLabel, String expectedErrorMessage) {
        this.errorLabel = errorLabel;
        this.expectedErrorMessage = expectedErrorMessage;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String errorMessageText;

        switch (errorLabel.toLowerCase()) {
            case "invalid commercial value label":
                errorMessageText = INVALID_COMMERCIAL_VALUE_LABEL
                        .resolveFor(actor).getText();
                return expectedErrorMessage.equals(errorMessageText);

            case "invalid percentage label":
                errorMessageText = INVALID_PERCENTAGE_LABEL
                        .resolveFor(actor).getText();
                return expectedErrorMessage.equals(errorMessageText);

            case "invalid minimum loan term label":
                errorMessageText = INVALID_MINIMUM_LOAN_TERM_LABEL
                        .resolveFor(actor).getText();
                return expectedErrorMessage.equals(errorMessageText);

            case "invalid maximum loan term label":
                errorMessageText = INVALID_MAXIMUM_LOAN_TERM_LABEL
                        .resolveFor(actor).getText();
                return expectedErrorMessage.equals(errorMessageText);
            default:
                return false;
        }
    }

    public static IsErrorMessageDisplayed in(String errorFieldXPath, String expectedErrorMessage) {
        return new IsErrorMessageDisplayed(errorFieldXPath, expectedErrorMessage);
    }
}

