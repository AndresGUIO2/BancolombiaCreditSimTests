package co.com.udea.certificacion.creditsim.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PickThe implements Interaction {
    private final Target dropdown;
    private final Target option;

    public PickThe(Target dropdown, Target option) {
        this.dropdown = dropdown;
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(dropdown),
                Click.on(option)
        );
    }

    public static PickThe valueFromDropdown(Target dropdown, Target option) {
        return instrumented(PickThe.class, dropdown, option);
    }
}