package co.com.udea.certificacion.creditsim.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SimulatorPage {
    public static final Target BACKGROUND = Target.the("Background")
            .locatedBy("//*[@id=\"layoutContainers\"]/div/div[2]/div/div[2]/div/section/div[2]/div[2]/app-root/div[1]/app-credit-form/section");
    public static final Target COMMERCIAL_VALUE_INPUT = Target.the("Modal monthly income input")
            .locatedBy("//*[@id=\"valor-simulacion\"]");
    public static final Target INVALID_COMMERCIAL_VALUE_LABEL = Target.the("Invalid commercial value label")
            .locatedBy("//*[@id=\"error-valorProperty-minimo\"]");
    public static final Target PERCENT_INPUT = Target.the("Percentage dropdown")
            .locatedBy("//*[@id='elegir-porcentaje']");
    public static final Target DESIRED_TERM_INPUT = Target.the("Home loan button")
            .locatedBy("//*[@id=\"valor-year\"]");
    public static final Target PREVIOUS_YEARS_BUTTON = Target.the("Previous years button")
            .locatedBy("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[2]");
    public static final Target BIRTHDATE_INPUT = Target.the("Home loan button")
            .locatedBy("//*[@id=\"campo-fecha\"]");
    public static final Target SIMULATE_BUTTON = Target.the("Home loan button")
            .locatedBy("//*[@id=\"boton-simular\"]");;

}