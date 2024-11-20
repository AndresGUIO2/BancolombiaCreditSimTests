package co.com.udea.certificacion.creditsim.stepdefinitions;

import co.com.udea.certificacion.creditsim.navigation.NavigateTo;
import co.com.udea.certificacion.creditsim.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.Map;

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



}