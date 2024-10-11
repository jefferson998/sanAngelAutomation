package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userInterface.SanAngelUserInterface.*;

public class VerifyProductsInCart implements Question<Boolean> {
    private final List<String> productNames;
    private final List<String> quantities;

    public VerifyProductsInCart(List<String> productNames, List<String> quantities) {
        this.productNames = productNames;
        this.quantities = quantities;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_FINISH_PURCHASE, isVisible())
                        .forNoMoreThan(20).seconds(),
                Click.on(BTN_FINISH_PURCHASE)
        );

        for (int i = 0; i < productNames.size(); i++) {
            String productName = productNames.get(i);
            String quantity = quantities.get(i);

            System.out.println(LBL_PRODUCT_NAME.of(productName));
            System.out.println(LBL_PRODUCT_QUANTITY.of(productName));

            String actualProductName = Text.of(LBL_PRODUCT_NAME.of(productName)).answeredBy(actor);
            String actualQuantity = actor.asksFor(Value.of(LBL_PRODUCT_QUANTITY.of(productName)));

            System.out.println(actualProductName + " " + actualQuantity);

            if (!actualProductName.contains(productName) || !actualQuantity.equals(quantity)) {
                return false;
            }
        }
        return true;
    }

    public static Question<Boolean> with(List<String> productNames, List<String> quantities) {
        return new VerifyProductsInCart(productNames, quantities);
    }
}
