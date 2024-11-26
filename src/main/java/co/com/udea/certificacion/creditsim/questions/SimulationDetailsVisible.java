package co.com.udea.certificacion.creditsim.questions;

import co.com.udea.certificacion.creditsim.utils.DateUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage;

public class SimulationDetailsVisible implements Question<Boolean> {

    private final String amount;
    private final String deadline;
    private final String birthdate;

    public SimulationDetailsVisible(String amount, String deadline, String birthdate) {
        this.amount = amount;
        this.deadline = deadline;
        this.birthdate = birthdate;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String birthdateFromPage = FreeInvestmentPage.BIRTHDATE_INPUT.resolveFor(actor).getValue();
        String formattedBirthdateFromPage = DateUtils.convertToAbbreviatedMonthDate(birthdateFromPage);

        return FreeInvestmentPage.AMOUNT_INPUT.resolveFor(actor).getValue().equals(amount)
                && FreeInvestmentPage.DEADLINE_INPUT.resolveFor(actor).getValue().equals(deadline)
                && formattedBirthdateFromPage.equals(birthdate);

    }

    public static SimulationDetailsVisible areCorrect(String amount, String deadline, String birthdate) {
        return new SimulationDetailsVisible(amount, deadline, birthdate);
    }
}
