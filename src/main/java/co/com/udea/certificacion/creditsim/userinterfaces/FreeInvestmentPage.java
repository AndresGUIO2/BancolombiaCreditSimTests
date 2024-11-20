package co.com.udea.certificacion.creditsim.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FreeInvestmentPage {

    // XPath para las tasas de interés cuando la respuesta es 'Sí'
    public static final String FEES_FOR_YES_XPATH = "";


    public static final Target FEES_FIELD_YES = Target.the("Fees field for YES option")
            .locatedBy("//*[@id='valor-resultados-compras']");
    public static final Target FEES_FIELD_NO = Target.the("Fees field for NO option")
            .locatedBy("//*[@id=\"layoutContainers\"]/div/div[2]/div/div[2]/div/section/div[2]/div[2]/app-root/div/app-resultado-simulacion/section[1]/swiper/div/div[1]/div[1]/div/div[2]/div/h4");
    public static final Target LOAN_SIMULATOR_BUTTON = Target.the("Loan simulator button")
            .locatedBy("#loan-simulator-btn");
    public static final Target FEES_FIELD = Target.the("Fees output field")
            .locatedBy("//*[@id=\"valor-resultados-compras\"]");
    public static final Target AMOUNT_INPUT = Target.the("Amount input field")
            .locatedBy("//*[@id=\"valor-simulacion\"]");
    public static final Target DEADLINE_INPUT = Target.the("Deadline input field")
            .locatedBy("//*[@id=\"valor-plazo\"]");
    public static final Target BIRTHDATE_INPUT = Target.the("Birthdate input field")
            .locatedBy("//*[@id=\"campo-fecha\"]");
    public static final Target SIMULATE_BUTTON = Target.the("Simulate button")
            .locatedBy("//*[@id=\"boton-simular\"]");
    public static final Target YES_OPTION = Target.the("Yes option")
            .locatedBy("//*[@id=\"opcion-si\"]/label/span[2]");
    public static final Target NO_OPTION = Target.the("No option")
            .locatedBy("//*[@id=\"opcion-no\"]/label/span[2]");
    public static final Target LOAN_OPTIONS = Target.the("Loan options")
            .locatedBy("//div[@class='loan-options']//span");
    private static final Target MENU_PRODUCTOS_LINK = Target.the("Menu Productos link")
            .locatedBy("#menu-productos"); // Usamos el ID para el enlace principal
    private static final Target CREDITS_LINK = Target.the("Credits link")
            .locatedBy("#header-productos-creditos"); // Usamos el nuevo ID para 'Créditos' // XPath para el enlace de 'Créditos'
    private static final Target SIMULATION_BUTTON = Target.the("Free investment loan simulation button")
            .locatedBy("//*[@id=\"creditos\"]/div/div[1]/div[1]/div/div[2]/div/a[1]");
    private static final Target CONTINUE_BUTTON = Target.the("Continue Free investment loan simulation")
            .locatedBy("//*[@id=\"boton-seleccion-tarjeta\"]");
    private static final Target FREE_INVESTMENT_TEXT = Target.the("On Free investment loan page")
            .locatedBy("//*[@id=\"layoutContainers\"]/div/div[2]/div/div[2]/div/section/div[2]/div[2]/app-root/div/app-solicitud-informacion/section/div[1]/h1");
}
