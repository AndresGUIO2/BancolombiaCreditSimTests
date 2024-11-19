package co.com.udea.certificacion.creditsim.stepdefinitions;

import co.com.udea.certificacion.creditsim.navigation.NavigateTo;
import co.com.udea.certificacion.creditsim.questions.InitialFee;
import co.com.udea.certificacion.creditsim.questions.InterestRate;
import co.com.udea.certificacion.creditsim.questions.LoanAmount;
import co.com.udea.certificacion.creditsim.questions.MonthlyPayment;
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
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

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
                FindThe.loanButton()
        );
    }

    @Given("he enters to the home value based simulation option")
    public void heEntersToTheHomeValueBasedSimulationOption(Actor actor) {
        actor.attemptsTo(
                FindThe.homeValueSimButton()
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
            EnterThe.commercialValue(percent),
            EnterThe.commercialValue(desiredTerm),
            EnterThe.commercialValue(birthdate)
        );
    }

    @And("{actor} clicks on {string} button")
    public void heClicksOnButton(String arg0) {
    }

    @Then("{actor} should see loan information:")
    public void shouldSeeLoanInformation(Actor actor, DataTable dataTable) {
        Map<String, String> expectedData = dataTable.asMaps().get(0);

        actor.should(
                seeThat(LoanAmount.shown(),
                        equalTo(expectedData.get("loan_amount"))),
                seeThat(MonthlyPayment.shown(),
                        equalTo(expectedData.get("monthly_payment"))),
                seeThat(InterestRate.shown(),
                        equalTo(expectedData.get("interest_rate"))),
                seeThat(InitialFee.shown(),
                        equalTo(expectedData.get("initial_fee")))
        );
    }



}