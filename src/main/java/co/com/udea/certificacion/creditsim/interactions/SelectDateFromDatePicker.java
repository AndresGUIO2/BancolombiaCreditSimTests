package co.com.udea.certificacion.creditsim.interactions;

import co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class SelectDateFromDatePicker implements Interaction {

    private final String date;

    public SelectDateFromDatePicker(String date) {
        this.date = date;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String[] dateParts = date.split("/");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];

        actor.attemptsTo(
                Click.on(FreeInvestmentPage.year(year)),
                Click.on(FreeInvestmentPage.month(month)),
                Click.on(FreeInvestmentPage.day(day))
        );

    }

    public static SelectDateFromDatePicker withDate(String date) {
        return new SelectDateFromDatePicker(date);
    }
}
