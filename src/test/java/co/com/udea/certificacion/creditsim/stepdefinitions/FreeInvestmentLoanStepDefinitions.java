package co.com.udea.certificacion.creditsim.stepdefinitions;


import co.com.udea.certificacion.creditsim.navigation.NavigateTo;
import co.com.udea.certificacion.creditsim.questions.SimulationDetailsVisible;
import co.com.udea.certificacion.creditsim.questions.ValidateFees;
import co.com.udea.certificacion.creditsim.tasks.*;
import co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;



public class FreeInvestmentLoanStepDefinitions {

    // ESCENARIO 1
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

        actor.should(seeThat("Simulation details are visible",
                SimulationDetailsVisible.areCorrect(amount, deadline, birthdate)
        ));
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
        List<String> columnsToValidate = List.of("fees_tf_cf", "fees_tv_cf", "fees_tv_cv");
        String answer = actor.recall("answer");

        actor.should(
                seeThat(ValidateFees.forColumns(rows, columnsToValidate))
        );
    }

    //ESCENARIO 2
    @When("{actor} enters invalid loan simulation details")
    public void whenActorEntersInvalidLoanSimulationDetails(Actor actor, DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        String amount = data.get("amount");
        String deadline = data.get("deadline");
        String birthdate = data.get("birthdate");

        actor.attemptsTo(
                EnterTheFV.amount(amount),
                EnterTheFV.deadline(deadline),
                EnterTheFV.birthdate(birthdate)
        );

        actor.should(seeThat("Simulation details are visible",
                SimulationDetailsVisible.areCorrect(amount, deadline, birthdate)
        ));
    }


    @Then("{actor} should see the following error messages:")
    public void verifyErrorMessages(Actor actor, DataTable dataTable) {
        List<Map<String, String>> errorData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> entry : errorData) {
            String field = entry.get("field");
            String expectedMessage = entry.get("expected_message");

            if (field.equals("amount")) {
                actor.should(seeThat("Amount error message",
                        WebElementQuestion.the(FreeInvestmentPage.AMOUNT_ERROR_MESSAGE),
                        containsText(expectedMessage)));
            }
            if (field.equals("deadline")) {
                actor.should(seeThat("Deadline error message",
                        WebElementQuestion.the(FreeInvestmentPage.DEADLINE_ERROR_MESSAGE),
                        containsText(expectedMessage)));
            }
            if (field.equals("birthdate")) {
                actor.should(seeThat("Birthdate error message",
                        WebElementQuestion.the(FreeInvestmentPage.BIRTHDATE_ERROR_MESSAGE),
                        containsText(expectedMessage)));
            }
        }
    }



}
