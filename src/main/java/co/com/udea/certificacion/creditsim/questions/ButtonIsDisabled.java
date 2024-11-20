package co.com.udea.certificacion.creditsim.questions;

import co.com.udea.certificacion.creditsim.interactions.TabManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage.*;

public class ButtonIsDisabled implements Question<Boolean>{
    private final String buttonName;

    public ButtonIsDisabled(String buttonName) {
        this.buttonName = buttonName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Target button;

        switch (buttonName.toLowerCase()) {

            case "simular":
                button = SIMULATE_BUTTON;
                return !button.resolveFor(actor).isEnabled();

            default:
                return false;
        }

    }

    public static ButtonIsDisabled named(String buttonName) {
        return new ButtonIsDisabled(buttonName);
    }
}
