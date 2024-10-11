package userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class SanAngelUserInterface {
    public static final Target BTN_HOME_LINK = Target.the("Home page link").locatedBy("(//*[@class=\"navmenu__logo-link\"])[1]");
    public static final Target BTN_PRODUCT = Target.the("Product button with name").locatedBy("//*[text()='{0}']//ancestor::a");
    public static final Target TXT_QUANTITY = Target.the("Input quantity producto to add").locatedBy("//input[@name=\"quantity\"]");
    public static final Target BTN_ADD_PRODUCT = Target.the("Button add product").locatedBy("//*[@class=\"single_add_to_cart_button button alt\"]");
    public static final Target BTN_FINISH_PURCHASE = Target.the("Finish purchase").locatedBy("(//*[@href=\"https://sanangel.com.co/finalizar-compra/\"])[1]");
    public static final Target LBL_PRODUCT_NAME = Target.the("Label product name in cart").locatedBy("//div[contains(text(),'{0}')]");
    public static final Target LBL_PRODUCT_QUANTITY = Target.the("Label quantity product in cart").locatedBy("//div[contains(text(),'{0}')]//ancestor::span//following-sibling::input");
}
