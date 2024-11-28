package co.com.udea.certificacion.creditsim.stepdefinitions;


import co.com.udea.certificacion.creditsim.navigation.NavigateTo;
import co.com.udea.certificacion.creditsim.questions.*;
import co.com.udea.certificacion.creditsim.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;




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



    @Given("{actor} has answered the question {string} with {string}")
    public void hasAnsweredTheQuestion(Actor actor,String question, String answer) {
        actor.attemptsTo(
                SelectTheKnowMoneyNeed.answerToQuestion(answer)
        );
    }

    //ESCENARIOS DE MENSAJES DE ERROR
    @When("{actor} enters simulation details free investment with wrong amount:")
    public void entersSimulationDetailsWithWrongAmount(Actor actor,DataTable table) {
        List<Map<String, String>> details = table.asMaps(String.class, String.class);
        for (Map<String, String> row : details) {
            actor.attemptsTo(
                    EnterTheFV.amount(row.get("wrong_amount")),
                    EnterTheFV.deadline(row.get("correct_deadline")),
                    EnterTheFV.birthdate(row.get("correct_birthdate"))
            );
        }
    }

    @When("{actor} enters simulation details free investment with wrong deadline:")
    public void entersSimulationDetailsWithWrongDeadline(Actor actor, DataTable table) {
        List<Map<String, String>> details = table.asMaps(String.class, String.class);
        for (Map<String, String> row : details) {
            actor.attemptsTo(
                    EnterTheFV.amount(row.get("correct_amount")),
                    EnterTheFV.deadline(row.get("wrong_deadline")),
                    EnterTheFV.birthdate(row.get("c_birthdate"))
            );
        }
    }

    @Then("{actor} should see an error message {string}")
    public void shouldSeeAnErrorMessage(Actor actor, String errorMessage) {

        if (errorMessage.contains("mínimo")) {
            actor.should(seeThat(AmountErrorMessage.minAmountError(), equalTo(errorMessage)));
        } else if (errorMessage.contains("máximo")) {
            actor.should(seeThat(AmountErrorMessage.maxAmountError(), equalTo(errorMessage)));
        }
    }

    @Then("{actor} should see other error message {string}")
    public void shouldSeeOtherErrorMessage(Actor actor, String errorMessage) {
        if (errorMessage.contains("mínimo")) {
            actor.should(seeThat(DeadlineErrorMessage.minDeadlineError(), equalTo(errorMessage)));
        } else if (errorMessage.contains("máximo")) {
            actor.should(seeThat(DeadlineErrorMessage.maxDeadlineError(), equalTo(errorMessage)));
        }
    }

    @And("{actor} should see the simulate button disabled")
    public void shouldSeeTheSimulateButtonDisabled(Actor actor) {
        actor.should(seeThat(ButtonState.isSimulateButtonDisabled(), is(true)));
    }



    //ESCENARIO DE EDAD INVÁLIDA
    @When("{actor} attempts to select the birthdate field")
    public void attemptsToSelectTheBirthdateField(Actor actor) {

        actor.attemptsTo(CheckBirthdateAccessibility.onDatepicker());
    }

    @Then("{actor} should not be able to select the birthdate {string}")
    public void shouldNotBeAbleToSelectTheBirthdate(Actor actor, String birthdate) {
        String[] dateParts = birthdate.split("/");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];


        if (actor.asksFor(DatePartState.forYear(year))) {

            actor.attemptsTo(SelectDatePart.year(year));
            if (actor.asksFor(DatePartState.forMonth(month))) {

                actor.attemptsTo(SelectDatePart.month(month));
                actor.should(seeThat(DatePartState.forDay(day), is(false)));

            } else {
                actor.should(seeThat(DatePartState.forMonth(month), is(false)));
            }
        } else {
            actor.should(seeThat(DatePartState.forYear(year), is(false)));
        }
    }







   //ESCENARIO EXITOSO
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
        List<String> columnsToValidate = List.of("fees_tf_cf", "fees_tv_cf", "fees_tv_cv");
        String answer = actor.recall("answer");

        actor.should(
                seeThat(ValidateFees.forColumns(rows, columnsToValidate))
        );
    }



}
