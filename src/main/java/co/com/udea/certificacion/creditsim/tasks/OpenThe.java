package co.com.udea.certificacion.creditsim.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.creditsim.userinterfaces.HomeLoanPage.*;

public class OpenThe implements Task {

    public OpenThe(String text) {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SIMULATOR_OPTION)
        );
    }

    public static OpenThe simulator(String text) {
        return Tasks.instrumented(OpenThe.class, text);
    }
}
