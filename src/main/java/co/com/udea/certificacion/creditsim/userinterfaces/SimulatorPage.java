package co.com.udea.certificacion.creditsim.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SimulatorPage {

    public static final Target COMMERCIAL_VALUE_INPUT = Target.the("Modal monthly income input")
            .locatedBy("//*[@id=\"valor-simulacion\"]");

    public static final Target PERCENT_INPUT = Target.the("Home loan button")
            .locatedBy("//*[@id=\"elegir-porcentaje\"]/div/div[1]/span/span");

    public static final Target DESIRED_TERM_INPUT = Target.the("Home loan button")
            .locatedBy("//*[@id=\"calcular-cuotas\"]");

    public static final Target BIRTHDATE_INPUT = Target.the("Home loan button")
            .locatedBy("//*[@id=\"campo-fecha\"]");

    public static final Target SIMULATE_BUTTON = Target.the("Home loan button")
            .locatedBy("//*[@id=\"boton-simular\"]");


}