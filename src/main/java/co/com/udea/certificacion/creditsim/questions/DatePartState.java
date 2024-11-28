package co.com.udea.certificacion.creditsim.questions;

import co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;



public class DatePartState implements Question<Boolean> {

    private final Target target;

    public DatePartState(Target target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Verificar si está presente y habilitado
        return target.resolveFor(actor).isPresent() && target.resolveFor(actor).isEnabled();
    }

    public static DatePartState forYear(String year) {
        return new DatePartState(FreeInvestmentPage.year(year));
    }

    public static DatePartState forMonth(String month) {
        return new DatePartState(FreeInvestmentPage.month(month));
    }

    public static DatePartState forDay(String day) {
        return new DatePartState(FreeInvestmentPage.day(day));
    }
}

