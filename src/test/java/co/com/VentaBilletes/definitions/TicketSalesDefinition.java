package co.com.VentaBilletes.definitions;

import co.com.VentaBilletes.steps.TicketSalesSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;


public class TicketSalesDefinition {

    @Steps
    TicketSalesSteps stepsTiketSales;

    @Given("Login to Vueling website {string}")
    public void login_to_vueling_website(String strUrl) {
        stepsTiketSales.loginToVuelingWebsite(strUrl);

    }

    @Given("Select the round trip option")
    public void select_the_round_trip_option() {
        //stepsTiketSales.AlertManagement();
        stepsTiketSales.SelectTheRoundTripOption();
    }

    @When("Fill out the form {string}, {string}, {string}, {string}")
    public void fillOutTheForm(String strOrigin, String strDestination, String strNumberAdults, String strNumberChildren) {
        stepsTiketSales.FillOutTheForm(strOrigin, strDestination, strNumberAdults, strNumberChildren);
    }

    @When("Search for flights")
    public void search_for_flights() {
        stepsTiketSales.SearchForFlights();

    }

    @Then("Select a flight")
    public void select_a_flight() {
        stepsTiketSales.SelectOutboundFlight();// Write code here that turns the phrase above into concrete actions
        stepsTiketSales.SelectReturnFlight();
    }

    @Then("select the tariff {string}")
    public void select_the_tariff(String tariff) {
        stepsTiketSales.SelectTheTariff(tariff);

    }

    @Then("validate message page who will travel")
    public void validate_message_page_who_will_travel() {
        stepsTiketSales.ValidateMessagePageWhoWillTravel();
        throw new io.cucumber.java.PendingException();
    }

}
