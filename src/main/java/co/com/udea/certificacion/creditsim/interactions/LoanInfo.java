package co.com.udea.certificacion.creditsim.interactions;

import net.serenitybdd.screenplay.Question;

import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.FEES_FIELD;

public class LoanInfo {
    public static Question<Boolean> feesAre(String expectedFees) {
        return actor -> {
            String actualFees = FEES_FIELD.resolveFor(actor).getText(); // Define FEES_FIELD como el Target que apunta al campo de "fees"
            return actualFees.equals(expectedFees);
        };
    }
}