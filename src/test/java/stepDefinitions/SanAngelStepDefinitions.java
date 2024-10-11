package stepDefinitions;

import driver.SeleniumWebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.AddProduct;
import questions.VerifyProductsInCart;

import java.io.IOException;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SanAngelStepDefinitions {
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("user enter to page san angel {string}")
    public void userEnterToPageSanAngel(String url) {
        SeleniumWebDriver.ChromeWebDriver();
        OnStage.theActorCalled("Jefferson").can(BrowseTheWeb.with(
                SeleniumWebDriver.on(url)));
    }





    @When("add product {string} with quantity {string} in cart")
    public void add_product_with_quantity_in_cart(String nameProduct, String quantity) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProduct.add(nameProduct, quantity)
        );
    }

    @Then("the cart should contain the following products:")
    public void theCartShouldContainTheFollowingProducts(io.cucumber.datatable.DataTable dataTable) {
        System.out.println(dataTable.asMap());
        List<String> productNames = dataTable.asLists(String.class).stream()
                .skip(1)
                .map(row -> row.get(0))
                .toList();

        List<String> quantities = dataTable.asLists(String.class).stream()
                .skip(1)
                .map(row -> row.get(1))
                .toList();


        OnStage.theActorInTheSpotlight().should(
                seeThat("The cart contains the added products",
                        VerifyProductsInCart.with(productNames, quantities)
                )
        );
    }




}
