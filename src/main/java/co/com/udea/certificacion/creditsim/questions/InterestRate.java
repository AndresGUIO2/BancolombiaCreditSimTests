package co.com.udea.certificacion.creditsim.questions;

import co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class InterestRate implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return "SimulatorPage.resolveFor(actor).getText()";
    }

    public static Question<String> shown() {
        return new InterestRate();
    }
}