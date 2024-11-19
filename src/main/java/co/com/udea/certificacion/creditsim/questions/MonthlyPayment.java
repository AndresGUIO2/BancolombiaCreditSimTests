package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage;

public class MonthlyPayment implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return "SimulatorPage.MONTHLY_PAYMENT.resolveFor(actor).getText()";
    }

    public static Question<String> shown() {
        return new MonthlyPayment();
    }
}