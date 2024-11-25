package co.com.udea.certificacion.creditsim.stepdefinitions;

import co.com.udea.certificacion.creditsim.navigation.NavigateTo;
import co.com.udea.certificacion.creditsim.questions.IsButtonDisabled;
import co.com.udea.certificacion.creditsim.questions.IsErrorMessageDisplayed;
import co.com.udea.certificacion.creditsim.questions.IsTheValueIn;
import co.com.udea.certificacion.creditsim.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en_old.Ac;
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

    @And("{actor} waits for the captcha")
    public void waitsForTheCaptcha(Actor actor) {
        try {
            Thread.sleep(15000); // 15 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura el estado de interrupción
        }
    }

    @Then("{actor} should see home leasing loan information:")
    public void shouldSeeHomeLeasingLoanInformation(Actor actor, DataTable dataTable) {
        Map<String, String> expectedData = dataTable.asMaps().get(0);

        String fixedFee = expectedData.get("fixed_fee");
        String constantCapital = expectedData.get("constant_capital");

        actor.should(
                seeThat("The housing leasing fixed fee label is displayed",
                        IsTheValueIn.input("Housing leasing fixed fee label", fixedFee)),
                seeThat("The housing leasing constant capital label is displayed",
                        IsTheValueIn.input("Housing leasing constant capital label", constantCapital))
        );
    }

    @Then("{actor} should see home loan information:")
    public void shouldSeeLoanInformation(Actor actor, DataTable dataTable) {
        Map<String, String> expectedData = dataTable.asMaps().get(0);

        String fixedFee = expectedData.get("fixed_fee");
        String constantCapital = expectedData.get("constant_capital");
        String constantFee = expectedData.get("constant_fee");

        actor.should(
                seeThat("The housing loan fixed fee label is displayed",
                        IsTheValueIn.input("Housing loan fixed fee label", fixedFee)),
                seeThat("The housing loan constant capital label is displayed",
                        IsTheValueIn.input("Housing loan constant capital label", constantCapital)),
                seeThat("The housing loan constant fee label is displayed",
                        IsTheValueIn.input("Housing loan constant fee label", constantCapital))
        );
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

    @Then("{actor} should see displayed in the {string} the error message: {string}")
    public void shouldSeeTheErrorMessage(Actor actor, String field, String string) {
      actor.should(
              seeThat("The error message is displayed correctly",
                      IsErrorMessageDisplayed.in(field, string)
              )
        );
    }

    @Then("{actor} should see that the {string} button remains disabled")
    public void theButtonRemainsDisabled(Actor actor, String string) {
      actor.should(
              seeThat("The button is disabled",
                      IsButtonDisabled.named(string))
        );
    }

    @When("{actor} enters a commercial value of {string}")
    public void entersACommercialValueOf(Actor actor, String value){
        actor.attemptsTo(
                EnterThe.commercialValue(value)
        );
    }

    @And("{actor} deletes the value of the loan amount input")
    public void deletesTheValueOfThe(Actor actor) {
        actor.attemptsTo(
                ClearThe.loanAmountInput()
        );
    }
    @And("{actor} enters a loan amount that equals a loan percentage below 1% or above 80% of the commercial value")
    public void entersALoanValueThatEqualsALoanPercentageOutsideAllowedRange(Actor actor, DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        String commercialValue = data.get("commercial_value");
        String loanAmount = data.get("loan_amount");

        actor.attemptsTo(
                EnterThe.commercialValue(commercialValue),
                EnterThe.loanAmount(loanAmount)
        );
    }

    @When("{actor} selects a loan percentage")
    public void selectsALoanPercentage(Actor actor, DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        String percentage = data.get("percentage");

        actor.attemptsTo(
                EnterThe.percent(percentage)
        );
    }

    @Then("{actor} should see that the {string} remain set to {string}")
    public  void shouldSeeThatTheInputRemainSetTo(Actor actor, String input, String value){
        actor.should(
                seeThat("The input remain set to 70%",
                IsTheValueIn.input(input, value))
        );
    }

    @Then("{actor} should see the {string} updated to the corresponding value")
    public void shouldSeeTheInputUpdatedToTheCorrespondingValue(Actor actor, String input, DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        String expectedLoanAmount = data.get("expected_value");

        actor.should(
                seeThat("The input updated to the corresponding value",
                        IsTheValueIn.input(input, expectedLoanAmount))
        );
    }

    @When("{actor} enters a loan term below 5 years")
    public void entersALoanTermBelow5Years(Actor actor, DataTable dataTable){
        Map<String, String> data = dataTable.asMaps().get(0);

        String loanTerm = data.get("loan_term");

        actor.attemptsTo(
                EnterThe.desiredTerm(loanTerm)
        );
    }

    @When("{actor} enters a loan term above 30 years")
    public void entersALoanTermAbove30Years(Actor actor, DataTable dataTable){
        Map<String, String> data = dataTable.asMaps().get(0);

        String loanTerm = data.get("loan_term");

        actor.attemptsTo(
                EnterThe.desiredTerm(loanTerm)
        );
    }

}