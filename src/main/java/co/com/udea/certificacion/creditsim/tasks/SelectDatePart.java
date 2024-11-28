package co.com.udea.certificacion.creditsim.tasks;

import co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

public class SelectDatePart implements Task {

    private final Target target;

    public SelectDatePart(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        target.resolveFor(actor).click();
    }

    public static SelectDatePart year(String year) {
        return new SelectDatePart(FreeInvestmentPage.year(year));
    }

    public static SelectDatePart month(String month) {
        return new SelectDatePart(FreeInvestmentPage.month(month));
    }
}
