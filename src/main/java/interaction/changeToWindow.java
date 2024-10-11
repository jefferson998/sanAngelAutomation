package interaction;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class changeToWindow implements Interaction {
    private static String defaultWindows;
    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String windowHandle : BrowseTheWeb.as(actor).getDriver().getWindowHandles()) {
            if (!windowHandle.equals(defaultWindows)) {
                BrowseTheWeb.as(actor).getDriver().switchTo().window(windowHandle);

            }
        }
    }
    public static Performable on() {
        return Instrumented.instanceOf(changeToWindow.class).withProperties();
    }
}
