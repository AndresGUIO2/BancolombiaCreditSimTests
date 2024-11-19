package co.com.udea.certificacion.creditsim.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomeLoanPage {

    public static final Target LOAN_BUTTON = Target.the("Home loan button")
            .locatedBy("//*[@id=\"creditos\"]/div/div[1]/div[2]/div/div[1]/div/div[2]/div/a[1]");

    public static final Target HOME_VALUE_SIM_BUTTON = Target.the("Home loan button")
            .locatedBy("//*[@id=\"calcular-cuotas\"]");


}

