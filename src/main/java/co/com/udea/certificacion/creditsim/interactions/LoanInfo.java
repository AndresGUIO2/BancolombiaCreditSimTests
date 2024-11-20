package co.com.udea.certificacion.creditsim.interactions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.*;

public class LoanInfo {

    private static Target getFeesFieldBasedOnAnswer(String answer) {
        if ("Si".equalsIgnoreCase(answer)) {
            return FEES_FIELD_YES; // Define este target en la clase FreeInvestmentPage
        } else if ("No".equalsIgnoreCase(answer)) {
            return FEES_FIELD_NO; // Define este target en la clase FreeInvestmentPage
        } else {
            throw new IllegalArgumentException("Respuesta inválida: " + answer);
        }
    }


    public static Question<Boolean> feesAre(String expectedFees, String answer) {
        return actor -> {
            Target feesField = getFeesFieldBasedOnAnswer(answer);
            String actualFees = feesField.resolveFor(actor).getText();
            return actualFees.equals(expectedFees);
        };
    }
}