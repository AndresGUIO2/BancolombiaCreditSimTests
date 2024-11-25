package co.com.udea.certificacion.creditsim.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SimulatorPage {
    public static final Target BACKGROUND = Target.the("Background")
            .locatedBy("//*[@id=\"layoutContainers\"]/div/div[2]/div/div[2]/div/section/div[2]/div[2]/app-root/div[1]/app-credit-form/section");
    public static final Target COMMERCIAL_VALUE_INPUT = Target.the("Modal monthly income input")
            .locatedBy("//*[@id=\"valor-simulacion\"]");
    public static final Target PERCENT_INPUT = Target.the("Percentage dropdown")
            .locatedBy("//*[@id='elegir-porcentaje']");
    public static final Target LOAN_AMOUNT_INPUT = Target.the("Loan amount input")
            .locatedBy("//*[@id=\"mat-input-4\"]");
    public static final Target DESIRED_TERM_INPUT = Target.the("Home loan button")
            .locatedBy("//*[@id=\"valor-year\"]");
    public static final Target PREVIOUS_YEARS_BUTTON = Target.the("Previous years button")
            .locatedBy("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[2]");
    public static final Target BIRTHDATE_INPUT = Target.the("Home loan button")
            .locatedBy("//*[@id=\"campo-fecha\"]");
    public static final Target SIMULATE_BUTTON = Target.the("Home loan button")
            .locatedBy("//*[@id=\"boton-simular\"]");
    public static final Target HOUSING_LEASING_BUTTON = Target.the("Leasing habitacional button")
            .locatedBy("//*[@id=\"credit-on-UVR-button\"]/div");
    public static final Target INVALID_COMMERCIAL_VALUE_LABEL = Target.the("Invalid commercial value label")
            .locatedBy("//*[@id=\"error-valorProperty-minimo\"]");
    public static final Target INVALID_PERCENTAGE_LABEL = Target.the("Invalid percentage label")
            .locatedBy("//*[@id=\"layoutContainers\"]/div/div[2]/div/div[2]/div/section/div[2]/div[2]/app-root/div[1]/app-credit-form/section/div/form/div[2]/p/span");
    public static final Target INVALID_MINIMUM_LOAN_TERM_LABEL = Target.the("Invalid minimum loan term label")
            .locatedBy("//*[@id=\"error-meses-minimo\"]");
    public static final Target INVALID_MAXIMUM_LOAN_TERM_LABEL = Target.the("Invalid maximum loan term label")
            .locatedBy("//*[@id=\"error-meses-maximo\"]");
    public static final Target HOUSING_LEASING_FIXED_FEE_LABEL = Target.the("Housisng leasing fixed fee label")
            .locatedBy("//*[@id=\"resultado-FIXEDRATEFIXEDFEE\"]");
    public static final Target HOUSING_LOAN_FIXED_FEE_LABEL = Target.the("Housisng loan fixed fee label")
            .locatedBy("//*[@id=\"resultado-FIXEDFEECOP\"]");
    public static final Target HOUSING_LEASING_CONSTANT_CAPITAL_LABEL = Target.the("Housing leasing constant capital label")
            .locatedBy("//*[@id=\"resultado-FIXEDRATECONSTANTCAPITAL\"]");
    public static final Target HOUSING_LOAN_CONSTANT_CAPITAL_LABEL = Target.the("Housing loan constant capital label")
            .locatedBy("//*[@id=\"resultado-CONSTANTAMORTIZATIONUVR\"]");
    public static final Target HOUSING_LOAN_CONSTANT_FEE_LABEL = Target.the("Housing loan constant fee label")
            .locatedBy("//*[@id=\"resultado-CONSTANTFEEUVR\"]");
}