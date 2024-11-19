package co.com.udea.certificacion.creditsim.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToLoanSimulator implements Task {

    // Definimos los targets de los elementos en el menú desplegable
    private static final Target MENU_PRODUCTOS_LINK = Target.the("Menu Productos link")
            .locatedBy("#menu-productos"); // Usamos el ID para el enlace principal

    // Usamos el nuevo target ID para "Créditos"
    private static final Target CREDITS_LINK = Target.the("Credits link")
            .locatedBy("#header-productos-creditos"); // Usamos el nuevo ID para 'Créditos' // XPath para el enlace de 'Créditos'

    private static final Target SIMULATION_BUTTON = Target.the("Free investment loan simulation button")
            .locatedBy("//*[@id=\"creditos\"]/div/div[1]/div[1]/div/div[2]/div/a[1]");

    private static final Target CONTINUE_BUTTON = Target.the("Continue Free investment loan simulation")
            .locatedBy("//*[@id=\"boton-seleccion-tarjeta\"]");
    private static final Target FREE_INVESTMENT_TEXT = Target.the("On Free investment loan page")
            .locatedBy("//*[@id=\"layoutContainers\"]/div/div[2]/div/div[2]/div/section/div[2]/div[2]/app-root/div/app-solicitud-informacion/section/div[1]/h1");


    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Primero se hace clic en el enlace del menú "Productos"
                Click.on(MENU_PRODUCTOS_LINK), // Hace clic en "Menú Productos"
                // Espera hasta que el enlace "Créditos" sea visible (esto es útil si el menú se despliega dinámicamente)
                WaitUntil.the(CREDITS_LINK, isVisible()).forNoMoreThan(10).seconds(), // Espera hasta que "Créditos" sea visible
                // Después hace clic en el enlace "Créditos"
                Click.on(CREDITS_LINK), // Hace clic en "Créditos"
                WaitUntil.the(SIMULATION_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SIMULATION_BUTTON),  // O el siguiente paso que necesites
                WaitUntil.the(FREE_INVESTMENT_TEXT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CONTINUE_BUTTON)
        );
    }

    // Método para instanciar la tarea
    public static NavigateToLoanSimulator navigate() {
        return instrumented(NavigateToLoanSimulator.class);
    }
}
