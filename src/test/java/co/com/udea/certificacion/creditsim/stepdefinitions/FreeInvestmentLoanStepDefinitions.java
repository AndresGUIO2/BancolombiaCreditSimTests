package co.com.udea.certificacion.creditsim.stepdefinitions;


import co.com.udea.certificacion.creditsim.interactions.LoanInfo;
import co.com.udea.certificacion.creditsim.navigation.NavigateTo;
import co.com.udea.certificacion.creditsim.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class FreeInvestmentLoanStepDefinitions {

    @Given("{actor} is on the Bancolombia homepage")
    public void actorIsOnHomepage(Actor actor) {
        actor.can(BrowseTheWeb.with(ThucydidesWebDriverSupport.getDriver()));
        actor.wasAbleTo(
                NavigateTo.bancolombia()
        );
    }

    @And("{actor} navigates to the loan simulator section")
    public void actorNavigatesToTheLoanSimulatorSection(Actor actor) {
        actor.attemptsTo(
                NavigateToLoanSimulator.navigate()
        );
    }

    @When("{actor} answers the question {string} with {string}")
    public void answerTheQuestion(Actor actor, String question, String answer) {
        actor.attemptsTo(
                SelectTheKnowMoneyNeed.answerToQuestion(answer)
        );
        actor.remember("answer", answer);

    }

    @And("{actor} enters simulation details free investment:")
    public void he_enters_simulation_details_free_investment(Actor actor, DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        String amount = data.get("amount");
        String deadline = data.get("deadline");
        String birthdate = data.get("birthdate");

        actor.attemptsTo(
                EnterTheFV.amount(amount),
                EnterTheFV.deadline(deadline),
                EnterTheFV.birthdate(birthdate)

        );
    }

    @When("{actor} clicks on simulate button")
    public void heClicksOnButton(Actor actor) {
        actor.attemptsTo(
                ClickSimulate.clickOnSimulateButton()
        );
    }

    @Then("{actor} should see loan information:")
    public void verifyLoanInformation(Actor actor, DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        String answer = actor.recall("answer");
        rows.forEach(row -> {
            String expectedFee = row.get("fees_tf_cf");   // Obtén el valor esperado de la columna "fee"
            System.out.println("Expected Fee: " + expectedFee);
            // Verifica que la tasa esperada coincida para la respuesta dada
            actor.should(
                    seeThat(LoanInfo.feesAre(expectedFee, answer))
            );
        });
    }



}
