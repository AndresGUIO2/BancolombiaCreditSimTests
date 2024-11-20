package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage.*;

public class ErrorMessageDisplayed implements Question<Boolean> {

    private final String expectedErrorMessage;
    private final String errorLabel;

    public ErrorMessageDisplayed(String errorLabel, String expectedErrorMessage) {
        this.errorLabel = errorLabel;
        this.expectedErrorMessage = expectedErrorMessage;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        switch (errorLabel.toLowerCase()) {
            case "invalid commercial value label":
                String errorMessageText = INVALID_COMMERCIAL_VALUE_LABEL
                        .resolveFor(actor).getText();
                return expectedErrorMessage.equals(errorMessageText);

            default:
                return false;
        }
    }

    public static ErrorMessageDisplayed displayedIn(String errorFieldXPath, String expectedErrorMessage) {
        return new ErrorMessageDisplayed(errorFieldXPath, expectedErrorMessage);
    }
}

