package co.com.udea.certificacion.creditsim.interactions;

import co.com.udea.certificacion.creditsim.userinterfaces.SimulatorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectDate implements Task {
    private final String year;
    private final String month;
    private final String day;

    public SelectDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SimulatorPage.BIRTHDATE_INPUT));

        // --------
        // For YEAR
        // --------

        boolean yearFound = false;

        while (!yearFound) {
            Target firstYearCell = Target.the("First year cell")
                    .locatedBy("//*[@id='mat-datepicker-0']/div/mat-multi-year-view/table/tbody/tr[1]/td[1]/div");

            String firstYearText = firstYearCell.resolveFor(actor).getText();

            if (Integer.parseInt(year) < Integer.parseInt(firstYearText)) {
                actor.attemptsTo(
                        Click.on(SimulatorPage.PREVIOUS_YEARS_BUTTON),
                        WaitUntil.the(firstYearCell, isPresent()).forNoMoreThan(5).seconds()
                );
                continue;
            }

            for (int row = 1; row <= 6 && !yearFound; row++) {
                for (int col = 1; col <= 4 && !yearFound; col++) {
                    Target yearCell = Target.the("Year cell")
                            .locatedBy("//*[@id='mat-datepicker-0']/div/mat-multi-year-view/table/tbody/tr[" + row + "]/td[" + col + "]/div");

                    if (yearCell.resolveFor(actor).isVisible() && yearCell.resolveFor(actor).getText().equals(year)) {
                        actor.attemptsTo(
                                Click.on(yearCell)
                        );
                        yearFound = true;
                    }
                }
            }

            if (!yearFound && Integer.parseInt(year) >= Integer.parseInt(firstYearText)) {
                throw new AssertionError("The specified year '" + year + "' was not found in the datepicker.");
            }
        }

        // ---------
        // For MONTH
        // ---------

        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("1", "ENE");
        monthMap.put("2", "FEB");
        monthMap.put("3", "MAR");
        monthMap.put("4", "ABR");
        monthMap.put("5", "MAY");
        monthMap.put("6", "JUN");
        monthMap.put("7", "JUL");
        monthMap.put("8", "AGO");
        monthMap.put("9", "SEPT");
        monthMap.put("10", "OCT");
        monthMap.put("11", "NOV");
        monthMap.put("12", "DIC");

        String monthAbbreviation = monthMap.get(month);

        if (monthAbbreviation == null) {
            throw new IllegalArgumentException("Invalid month number: " + month);
        }

        boolean monthFound = false;

        for (int row = 1; row <= 3 && !monthFound; row++) {
            for (int col = 1; col <= 4 && !monthFound; col++) {
                Target monthCell = Target.the("Month cell")
                        .locatedBy("//*[@id=\"mat-datepicker-0\"]/div/mat-year-view/table/tbody/tr[" + row + "]/td[" + col + "]/div");

                if (monthCell.resolveFor(actor).isVisible() && monthCell.resolveFor(actor).getText().equalsIgnoreCase(monthAbbreviation)) {
                    actor.attemptsTo(
                            Click.on(monthCell)
                    );
                    monthFound = true;
                }
            }
        }

        // -------
        // For DAY
        // -------

        boolean dayFound = false;

        for (int row = 1; row <= 5 && !dayFound; row++) {
            for (int col = 1; col <= 7 && !dayFound; col++) {
                Target dayCell = Target.the("Day cell")
                        .locatedBy("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[" + row + "]/td[" + col + "]/div");

                if (dayCell.resolveFor(actor).isVisible() && dayCell.resolveFor(actor).getText().equalsIgnoreCase(day)) {
                    actor.attemptsTo(
                            Click.on(dayCell)
                    );
                    dayFound = true;
                }
            }
        }

        if (!dayFound) {
            throw new AssertionError("The specified day '" + day + "' was not found in the datepicker.");
        }
    }

    public static SelectDate with(String year, String month, String day) {
        return instrumented(SelectDate.class, year, month, day);
    }
}

