package co.com.udea.certificacion.creditsim.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;



import static net.serenitybdd.screenplay.Tasks.instrumented;


public class SelectBirthdate implements Task {
    private final String date;

    public SelectBirthdate(String date) {
        this.date = date;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Divide la fecha en día, mes y año
        String[] dateParts = date.split("/");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];

        // Lógica para seleccionar la fecha en el datepicker
        actor.attemptsTo(
                Click.on(Target.the("Year in datepicker")
                        .locatedBy("//*[@id='mat-datepicker-0']//td//div[contains(text(), '" + year + "')]"))
        );

        // Luego, seleccionar el mes
        actor.attemptsTo(
                Click.on(Target.the("Month in datepicker")
                        .locatedBy("//*[@id='mat-datepicker-0']//td//div[contains(text(), '" + month + "')]"))
        );

        // Finalmente, seleccionar el día
        actor.attemptsTo(
                Click.on(Target.the("Day in datepicker")
                        .locatedBy("//*[@id='mat-datepicker-0']//td//div[contains(text(), '" + day + "')]"))
        );
    }

    public static SelectBirthdate withDate(String date) {
        return instrumented(SelectBirthdate.class, date);
    }

}
