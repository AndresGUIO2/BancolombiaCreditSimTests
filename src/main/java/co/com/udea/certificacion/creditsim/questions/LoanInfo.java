package co.com.udea.certificacion.creditsim.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.stream.Collectors;

import static co.com.udea.certificacion.creditsim.userinterfaces.FreeInvestmentPage.*;

public class LoanInfo {

    public static Question<Boolean> feesAre(List<String> expectedFeesList) {
        return actor -> {


            for (int i = 0; i < expectedFeesList.size(); i++) {
                String expectedFee = expectedFeesList.get(i);
                Target feeField = Target.the("Fee field").locatedBy("/html/body/div[2]/div[2]/div/div[2]/div/div[2]/div/section/div[2]/div[2]/app-root/div/app-resultado-simulacion/section[1]/swiper/div/div[1]/div[" + (i + 1) + "]/div/div[3]/h4");
                String actualFee = feeField.resolveFor(actor).getText();
                if (!actualFee.equals(expectedFee)) {
                    return false;
                }
            }

            return true;
        };
    }
}