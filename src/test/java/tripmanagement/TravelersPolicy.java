package tripmanagement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tripmanagement.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelersPolicy {
    private Trip economyTrip;
    private Trip businessTrip;
    private Traveler mike;
    private Traveler john;

    @Given("^there is an economy trip$")
    public void thereIsAnEconomyTrip() throws Throwable {
        economyTrip = new EconomyTrip("1");
    }

    @When("^we have a usual traveler$")
    public void weHaveAUsualTraveler() throws Throwable {
        mike  = new Traveler("Mike", false);
    }

    @Then("^you can add and remove him from an economy trip$")
    public void youCanAddAndRemoveHimFromAnEconomyTrip() throws Throwable {
        assertAll("Verify all conditions for a usual traveler and an economy trip",
                () -> assertEquals("1", economyTrip.getId()),
                () -> assertEquals(true, economyTrip.addTraveler(mike)),
                () -> assertEquals(1, economyTrip.getTravelersList().size()),
                () -> assertEquals("Mike", economyTrip.getTravelersList().get(0).getName()),
                () -> assertEquals(true, economyTrip.removeTraveler(mike)),
                () -> assertEquals(0, economyTrip.getTravelersList().size())
        );
    }

    @When("^we have a VIP traveler$")
    public void weHaveAVIPTraveler() throws Throwable {
        john = new Traveler("John", true);
    }

    @Then("^you can add him but cannot remove him from an economy trip$")
    public void youCanAddHimButCannotRemoveHimFromAnEconomyTrip() throws Throwable {
        assertAll("Verify all conditions for a VIP traveler and an economy trip",
                () -> assertEquals("1", economyTrip.getId()),
                () -> assertEquals(true, economyTrip.addTraveler(john)),
                () -> assertEquals(1, economyTrip.getTravelersList().size()),
                () -> assertEquals("John", economyTrip.getTravelersList().get(0).getName()),
                () -> assertEquals(false, economyTrip.removeTraveler(john)),
                () -> assertEquals(1, economyTrip.getTravelersList().size())
        );
    }

    @Given("^there is an business trip$")
    public void thereIsAnBusinessTrip() throws Throwable {
        businessTrip = new BusinessTrip("2");
    }

    @Then("^you cannot add or remove him from a business trip$")
    public void youCannotAddOrRemoveHimFromABusinessTrip() throws Throwable {
        assertAll("Verify all conditions for a usual traveler and a business trip",
                () -> assertEquals(false, businessTrip.addTraveler(mike)),
                () -> assertEquals(0, businessTrip.getTravelersList().size()),
                () -> assertEquals(false, businessTrip.removeTraveler(mike)),
                () -> assertEquals(0, businessTrip.getTravelersList().size())
        );
    }

    @Then("^you can add him but cannot remove him from a business trip$")
    public void youCanAddHimButCannotRemoveHimFromABusinessTrip() throws Throwable {
        assertAll("Verify all conditions for a VIP traveler and a business trip",
                () -> assertEquals(true, businessTrip.addTraveler(john)),
                () -> assertEquals(1, businessTrip.getTravelersList().size()),
                () -> assertEquals(false, businessTrip.removeTraveler(john)),
                () -> assertEquals(1, businessTrip.getTravelersList().size())
        );
    }
}
