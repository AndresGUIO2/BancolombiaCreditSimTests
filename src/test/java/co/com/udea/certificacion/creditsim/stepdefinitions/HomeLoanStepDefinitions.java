package co.com.udea.certificacion.creditsim.stepdefinitions;

import co.com.udea.certificacion.creditsim.navigation.NavigateTo;
import co.com.udea.certificacion.creditsim.questions.ButtonIsDisabled;
import co.com.udea.certificacion.creditsim.questions.ErrorMessageDisplayed;
import co.com.udea.certificacion.creditsim.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Map;

import static co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage.*;
import static  net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class HomeLoanStepDefinitions {
    @Given("{actor} is on the Bancolombia homepage")
    public void actorIsOnHomepage(Actor actor) {
        actor.can(BrowseTheWeb.with(getDriver()));
        actor.wasAbleTo(
                NavigateTo.bancolombia()
        );
    }

    @Given("{actor} navigates to the home loan section")
    public void navigateToHomeLoanSection(Actor actor) {
        actor.attemptsTo(
                FindThe.homeLoanButton(),
                FindThe.loanButton(),
                FindThe.creditButton()
        );
    }

    @Given("{actor} enters to the home value based simulation option")
    public void heEntersToTheHomeValueBasedSimulationOption(Actor actor) {
        actor.attemptsTo(
                FindThe.homeValueBasedButton()
        );
    }

    @When("{actor} enters simulation details:")
    public void entersSimulationDetails(Actor actor, DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        String commercialValue = data.get("commercial_value");
        String percent = data.get("percent");
        String desiredTerm = data.get("desired_term");
        String birthdate = data.get("birthdate");

        actor.attemptsTo(
                EnterThe.commercialValue(commercialValue),
                EnterThe.percent(percent),
                EnterThe.desiredTerm(desiredTerm),
                EnterThe.birthdate(birthdate)
        );
    }

    @And("{actor} clicks on {string} button")
    public void heClicksOnButton(Actor actor, String buttonName) {
        actor.attemptsTo(
                FindThe.element(buttonName)
        );
    }

    @Then("{actor} should see loan information:")
    public void shouldSeeLoanInformation(Actor actor, DataTable dataTable) {
        Map<String, String> expectedData = dataTable.asMaps().get(0);

      /*  actor.should(
        );*/
    }

    @When("{actor} enters a commercial value below 52000000 COP")
    public void entersACommercialValueBelow52000000COP(Actor actor, DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        String commercialValue = data.get("commercial_value");

        actor.attemptsTo(
                EnterThe.commercialValue(commercialValue)
        );
    }

    @And("{actor} clicks off the field")
    public void clicksOffTheField(Actor actor){
        actor.attemptsTo(
                Click.on(BACKGROUND)
        );
    }

    @Then("{actor} should see the error message: {string}")
    public void shouldSeeTheErrorMessage(Actor actor, String string) {
      actor.should(
              seeThat("The error message is displayed correctly",
                      ErrorMessageDisplayed.displayedIn("Invalid commercial value label", string)
              )
        );
    }

    @Then("{actor} should see that the {string} button remains disabled")
    public void theButtonRemainsDisabled(Actor actor, String string) {
      actor.should(
              seeThat("The button is disabled",
                      ButtonIsDisabled.named(string))
        );
    }
}