package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userInterface.SanAngelUserInterface.*;

public class AddProduct implements Task {
    private final String productName;
    private final String quantity;

    public AddProduct(String productName, String quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_HOME_LINK,isVisible())
                        .forNoMoreThan(20).seconds(),
                Click.on(BTN_HOME_LINK),
                WaitUntil.the(BTN_PRODUCT.of(productName),isVisible())
                        .forNoMoreThan(20).seconds(),
                Click.on(BTN_PRODUCT.of(productName)),
                WaitUntil.the(TXT_QUANTITY.of(productName),isVisible())
                        .forNoMoreThan(20).seconds(),
                Enter.theValue(quantity).into(TXT_QUANTITY),
//                Scroll.to(BTN_ADD_PRODUCT),
                WaitUntil.the(BTN_ADD_PRODUCT.of(productName),isVisible())
                        .forNoMoreThan(20).seconds(),
                Click.on(BTN_ADD_PRODUCT),
                WaitUntil.the(BTN_HOME_LINK,isVisible())
                        .forNoMoreThan(20).seconds(),
                Click.on(BTN_HOME_LINK)

        );
    }

    public static AddProduct add(String productName, String quantity) {
        return Instrumented.instanceOf(AddProduct.class).withProperties(productName,quantity);
    }
}
