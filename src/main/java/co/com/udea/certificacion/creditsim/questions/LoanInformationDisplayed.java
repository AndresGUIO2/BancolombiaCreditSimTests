package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage.*;

public class LoanInformationDisplayed implements Question<Boolean> {
    private final String expectedLoanAmount;
    private final String expectedFirstPayment;

    public LoanInformationDisplayed(String loanAmount, String firstPayment) {
        this.expectedLoanAmount = loanAmount;
        this.expectedFirstPayment = firstPayment;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualLoanAmount = LOAN_LABEL.resolveFor(actor).getText().replaceAll("[^0-9]", "");
        String actualFirstPayment = FIRST_PAYMENT_LABEL.resolveFor(actor).getText().replaceAll("[^0-9]", "");

        return actualLoanAmount.equals(expectedLoanAmount.replaceAll("[^0-9]", "")) &&
                actualFirstPayment.equals(expectedFirstPayment.replaceAll("[^0-9]", ""));
    }

    public static LoanInformationDisplayed matches(String loanAmount, String firstPayment) {
        return new LoanInformationDisplayed(loanAmount, firstPayment);
    }
}