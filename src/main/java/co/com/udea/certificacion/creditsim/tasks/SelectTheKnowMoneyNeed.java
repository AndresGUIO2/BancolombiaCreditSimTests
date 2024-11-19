package co.com.udea.certificacion.creditsim.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.NO_OPTION;
import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.YES_OPTION;


public class SelectTheKnowMoneyNeed implements Task {
    private final String answer;

    // Constructor para recibir la respuesta
    public SelectTheKnowMoneyNeed(String answer) {
        this.answer = answer;
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        if ("Si".equalsIgnoreCase(answer)) {
            actor.attemptsTo(Click.on(YES_OPTION));  // Si la respuesta es "Sí"
        } else if ("No".equalsIgnoreCase(answer)) {
            actor.attemptsTo(Click.on(NO_OPTION));  // Si la respuesta es "No"
        }
    }

    // Método estático para crear la tarea
    public static SelectTheKnowMoneyNeed answerToQuestion(String answer) {
        return new SelectTheKnowMoneyNeed(answer);
    }
}
