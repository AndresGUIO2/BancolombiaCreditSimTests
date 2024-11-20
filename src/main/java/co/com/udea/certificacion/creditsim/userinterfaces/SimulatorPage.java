package co.com.udea.certificacion.creditsim.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SimulatorPage {

    public static final Target COMMERCIAL_VALUE_INPUT = Target.the("Modal monthly income input")
            .locatedBy("//*[@id=\"valor-simulacion\"]");
    public static final Target PERCENT_INPUT = Target.the("Percentage dropdown")
            .locatedBy("//*[@id='elegir-porcentaje']");
    public static final Target DESIRED_TERM_INPUT = Target.the("Home loan button")
            .locatedBy("//*[@id=\"valor-year\"]");
    public static final Target PREVIOUS_YEARS_BUTTON = Target.the("Previous years button")
            .locatedBy("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[2]");
    public static final Target BIRTHDATE_INPUT = Target.the("Home loan button")
            .locatedBy("//*[@id=\"campo-fecha\"]");
    public static final Target YEAR_SELECTOR = Target.the("Year option")
            .locatedBy("//*[@id=\"mat-datepicker-0\"]/div/mat-multi-year-view/table/tbody/tr[2]/td[4]/div");
    public static final Target MONTH_SELECTOR = Target.the("Month option")
            .locatedBy("//*[@id=\"mat-datepicker-0\"]/div/mat-year-view/table/tbody/tr[3]/td[3]/div");

    public static final Target DAY_SELECTOR = Target.the("Day option")
            .locatedBy("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[4]/td[3]/div");
    public static final Target SIMULATE_BUTTON = Target.the("Home loan button")
            .locatedBy("//*[@id=\"boton-simular\"]");;

}