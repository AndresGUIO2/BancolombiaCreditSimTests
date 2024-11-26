package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValidateFees implements Question<Boolean> {
    private final List<Map<String, String>> rows;
    private final List<String> columnsToValidate;

    public ValidateFees(List<Map<String, String>> rows, List<String> columnsToValidate) {
        this.rows = rows;
        this.columnsToValidate = columnsToValidate;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        for (Map<String, String> row : rows) {
            List<String> expectedFeesList = new ArrayList<>();

            for (String column : columnsToValidate) {
                String expectedFee = row.get(column);
                if (expectedFee != null) {
                    expectedFeesList.add(expectedFee);
                }
            }
            boolean result = LoanInfo.feesAre(expectedFeesList).answeredBy(actor);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public static ValidateFees forColumns(List<Map<String, String>> rows, List<String> columnsToValidate ) {
        return new ValidateFees(rows, columnsToValidate);
    }
}
