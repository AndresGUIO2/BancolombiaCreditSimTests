package co.com.udea.certificacion.creditsim.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable bancolombia() {
        return Task.where("{0} opens the Bancolombia home page", Open.browserOn().the(BancolombiaHomePage.class));
    }
}