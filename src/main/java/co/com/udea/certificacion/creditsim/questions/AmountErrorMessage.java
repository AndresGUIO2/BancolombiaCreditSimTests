package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.MAX_AMOUNT_TEXT_ERROR;
import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.MIN_AMOUNT_TEXT_ERROR;


public class AmountErrorMessage implements Question<String> {

    private final Target target;

    public AmountErrorMessage(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText();
    }

    public static Question<String> minAmountError() {
        return new AmountErrorMessage(MIN_AMOUNT_TEXT_ERROR);
    }

    public static Question<String> maxAmountError() {
        return new AmountErrorMessage(MAX_AMOUNT_TEXT_ERROR);
    }
}

