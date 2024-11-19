package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class InitialFee implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return "INITIAL_FEE.resolveFor(actor).getText()";
    }

    public static Question<String> shown() {
        return new InitialFee();
    }
}