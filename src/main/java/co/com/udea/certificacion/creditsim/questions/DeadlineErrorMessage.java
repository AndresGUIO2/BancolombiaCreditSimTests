package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.MIN_DEADLINE_TEXT_ERROR;
import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.MAX_DEADLINE_TEXT_ERROR;

public class DeadlineErrorMessage implements Question<String> {

    private final Target target;

    public DeadlineErrorMessage(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText();
    }

    public static Question<String> minDeadlineError() {
        return new DeadlineErrorMessage(MIN_DEADLINE_TEXT_ERROR);
    }

    public static Question<String> maxDeadlineError() {
        return new DeadlineErrorMessage(MAX_DEADLINE_TEXT_ERROR);
    }
}
