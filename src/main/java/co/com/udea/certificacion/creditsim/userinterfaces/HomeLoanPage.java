package co.com.udea.certificacion.creditsim.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomeLoanPage {

    public static final Target HOME_LOAN_BUTTON = Target.the("Home loan button")
            .locatedBy("//*[@id=\"card-flotante-2\"]/label");

    public static final Target LOAN_BUTTON = Target.the("Home loan button")
            .locatedBy("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div/section/div[2]/section/div/div/div/div/div[2]/div[1]/div/div[1]/div[1]/div/a");

    public static final Target CREDIT_BUTTON = Target.the("Credit button")
            .locatedBy("//*[@id=\"btnflotante\"]/div[2]/a/em");

    public static final Target HOME_VALUE_BASED_BUTTON = Target.the("Home value based button")
            .locatedBy("//*[@id=\"calcular-cuotas\"]");

}

