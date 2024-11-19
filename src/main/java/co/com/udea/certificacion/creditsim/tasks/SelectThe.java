package co.com.udea.certificacion.creditsim.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SelectThe implements Task {
    private final String term;

    public SelectThe(String term) {
        this.term = term;
        System.out.println("DEBUG - Iniciando SelectThe con término: " + term);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            System.out.println("DEBUG - Ejecutando script para término: " + term);

            String setupScript =
                    "window.selectButton = async function(term) {" +
                            "    const layout = document.querySelector('initial-layout');" +
                            "    if (!layout) {" +
                            "        console.log('No layout found');" +
                            "        return false;" +
                            "    }" +
                            "    const widget = layout.shadowRoot.querySelector('bbog-simulator-widget');" +
                            "    if (!widget) {" +
                            "        console.log('No widget found');" +
                            "        return false;" +
                            "    }" +
                            "    const options = widget.shadowRoot.querySelector('bdb-credit-options');" +
                            "    if (!options) {" +
                            "        console.log('No options found');" +
                            "        return false;" +
                            "    }" +
                            "    const time = options.shadowRoot.querySelector('bdb-credit-time');" +
                            "    if (!time) {" +
                            "        console.log('No time found');" +
                            "        return false;" +
                            "    }" +
                            "    const buttons = Array.from(time.shadowRoot.querySelectorAll('bdb-ml-active-selector'));" +
                            "    const currentSelected = buttons.find(b => b.getAttribute('select') === 'true');" +
                            "    const targetButton = buttons.find(b => b.getAttribute('text') === term);" +
                            "    if (!targetButton) {" +
                            "        console.log('Target button not found');" +
                            "        return false;" +
                            "    }" +
                            "    if (currentSelected) {" +
                            "        currentSelected.setAttribute('select', 'false');" +
                            "        await new Promise(resolve => setTimeout(resolve, 100));" +
                            "    }" +
                            "    targetButton.setAttribute('select', 'true');" +
                            "    targetButton.click();" +
                            "    await new Promise(resolve => setTimeout(resolve, 100));" +
                            "    return true;" +
                            "};";

            js.executeScript(setupScript);

            String executeScript =
                    "var callback = arguments[arguments.length - 1];" +
                            "window.selectButton(arguments[0]).then(callback);";

            boolean success = false;
            for (int i = 0; i < 3 && !success; i++) {
                if (i > 0) {
                    System.out.println("DEBUG - Esperando antes del intento " + (i + 1));
                    Thread.sleep(2000);
                }

                Object result = js.executeAsyncScript(executeScript, term);
                success = result instanceof Boolean && (Boolean) result;
                System.out.println("DEBUG - Intento " + (i + 1) + " - Resultado: " + success);
            }

            if (!success) {
                String debugScript =
                        "const layout = document.querySelector('initial-layout');" +
                                "if (!layout) return 'No layout';" +
                                "const widget = layout.shadowRoot.querySelector('bbog-simulator-widget');" +
                                "if (!widget) return 'No widget';" +
                                "const options = widget.shadowRoot.querySelector('bdb-credit-options');" +
                                "if (!options) return 'No options';" +
                                "const time = options.shadowRoot.querySelector('bdb-credit-time');" +
                                "if (!time) return 'No time';" +
                                "const buttons = Array.from(time.shadowRoot.querySelectorAll('bdb-ml-active-selector'));" +
                                "return JSON.stringify(buttons.map(b => ({" +
                                "    text: b.getAttribute('text')," +
                                "    select: b.getAttribute('select')," +
                                "    id: b.id" +
                                "})), null, 2);";

                String debug = (String) js.executeScript(debugScript);
                System.out.println("DEBUG - Estado de los botones: " + debug);

                throw new RuntimeException("No se pudo hacer click en el botón para el término: " + term);
            }

            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("ERROR - " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al seleccionar el plazo: " + term, e);
        }
    }

    public static SelectThe loanTerm(String term) {
        return Tasks.instrumented(SelectThe.class, term);
    }
}