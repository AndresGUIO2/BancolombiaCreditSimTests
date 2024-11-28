package co.com.udea.certificacion.creditsim.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FreeInvestmentPage {

    //DatePicker
    public static final String YEAR_PICKER = "//*[@id='mat-datepicker-0']//td//div[contains(text(), '{0}')]";
    public static final String MONTH_PICKER = "//*[@id='mat-datepicker-0']//td//div[contains(text(), '{0}')]";
    public static final String DAY_PICKER = "//*[@id='mat-datepicker-0']//td//div[contains(text(), '{0}')]";

    public static Target year(String year) {
        return Target.the("Year in datepicker").locatedBy(YEAR_PICKER.replace("{0}", year));
    }
    public static Target month(String month) {
        return Target.the("Month in datepicker").locatedBy(MONTH_PICKER.replace("{0}", month));
    }
    public static Target day(String day) {
        return Target.the("Day in datepicker").locatedBy(DAY_PICKER.replace("{0}", day));
    }

    public static final Target LOAN_SIMULATOR_BUTTON = Target.the("Loan simulator button")
            .locatedBy("#loan-simulator-btn");

    // MAIN INPUT
    public static final Target AMOUNT_INPUT = Target.the("Amount input field")
            .locatedBy("//*[@id=\"valor-simulacion\"]");
    public static final Target DEADLINE_INPUT = Target.the("Deadline input field")
            .locatedBy("//*[@id=\"valor-plazo\"]");
    public static final Target BIRTHDATE_INPUT = Target.the("Birthdate input field")
            .locatedBy("//*[@id=\"campo-fecha\"]");

    //ERRORS
    public static final Target MIN_AMOUNT_TEXT_ERROR = Target.the("Amount minimal error message")
            .locatedBy("//*[@id=\"error-valor-minimo\"]");
    public static final Target MAX_AMOUNT_TEXT_ERROR = Target.the("Amount maximal error message")
            .locatedBy("//*[@id=\"error-valor-maximo\"]");
    public static final Target MIN_DEADLINE_TEXT_ERROR = Target.the("Deadline minimal error message")
            .locatedBy("//*[@id=\"error-meses-minimo\"]");
    public static final Target MAX_DEADLINE_TEXT_ERROR = Target.the("Deadline maximal error message")
            .locatedBy("//*[@id=\"error-meses-maximo\"]");

    //YES/NOT OPTION
    public static final Target SIMULATE_BUTTON = Target.the("Simulate button")
            .locatedBy("//*[@id=\"boton-simular\"]");
    public static final Target YES_OPTION = Target.the("Yes option")
            .locatedBy("//*[@id=\"opcion-si\"]/label/span[2]");
    public static final Target NO_OPTION = Target.the("No option")
            .locatedBy("//*[@id=\"opcion-no\"]/label/span[2]");

    //NAVIGATION
    public static final Target MENU_PRODUCTOS_LINK = Target.the("Menu Productos link")
            .locatedBy("#menu-productos");
    public static final Target CREDITS_LINK = Target.the("Credits link")
            .locatedBy("#header-productos-creditos");
    public static final Target SIMULATION_BUTTON = Target.the("Free investment loan simulation button")
            .locatedBy("//*[@id=\"creditos\"]/div/div[1]/div[1]/div/div[2]/div/a[1]");
    public static final Target CONTINUE_BUTTON = Target.the("Continue Free investment loan simulation")
            .locatedBy("//*[@id=\"boton-seleccion-tarjeta\"]");
    public static final Target FREE_INVESTMENT_TEXT = Target.the("On Free investment loan page")
            .locatedBy("//*[@id=\"layoutContainers\"]/div/div[2]/div/div[2]/div/section/div[2]/div[2]/app-root/div/app-solicitud-informacion/section/div[1]/h1");
    public static final Target FEES_FIELD = Target.the("Fees output field")
            .locatedBy("//*[@id=\"valor-resultados-compras\"]");


}
