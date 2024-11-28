package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.SIMULATE_BUTTON;

public class ButtonState implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return SIMULATE_BUTTON.resolveFor(actor).isDisabled();
    }

    public static ButtonState isSimulateButtonDisabled() {
        return new ButtonState();
    }
}


