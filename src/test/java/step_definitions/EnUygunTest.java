package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.EnUygun_POM;
import utilities.DriverClass;

public class EnUygunTest {
    EnUygun_POM eu=new EnUygun_POM();
    @Given("Navigated to home page")
    public void navigateToHttpsWwwEnuygunComOtobusBileti() {
        DriverClass.getDriver().get("https://www.enuygun.com/");
    }
    @And("Click on bus tab")
    public void clickOnBusTab() {
        eu.clickMethod(eu.getBusTab());
    }

    @When("Fill out the form")
    public void fillOutTheForm() {
        eu.sendKeysMethod(eu.getOrigin(),"Istanbul");
        eu.sendKeysMethod(eu.getDestination(),"Izmir");
        eu.clickMethod(eu.getDepartureDateButton());
        eu.clickMethod(eu.getGetDepartureDate());

    }

    @And("Click on search button")
    public void clickOnSearchButton() {
        eu.clickMethod(eu.getContinueButton());
    }

    @And("Select the proper option")
    public void selectTheProperOption() {
        eu.clickMethod(eu.getPamukkaleCompany().get(1));
        eu.clickMethod(eu.getFirstAvailableSeat().get(1));

    }

    @And("Choose the seat as male")
    public void chooseTheSeatAsMale() {
        eu.clickMethod(eu.getGenderButtonForMale());
        eu.clickMethod(eu.getAcceptAndContinueButton());
    }

    @When("Fill out the passenger information")
    public void fillOutThePassengerInformation() {
        eu.sendKeysMethod(eu.getEmailAddressBeforePayment(),"qahuntproject@gmail.com");
        eu.sendKeysMethod(eu.getPhoneNumberBeforePayment(),"5555555555");
        eu.sendKeysMethod(eu.getPassengerName(),"John");
        eu.sendKeysMethod(eu.getPassengerLastname(),"Doe");
        eu.clickMethod(eu.getNonCitizenCheckbox());
        eu.sendKeysMethod(eu.getPassportNumber(),"34738292");
        Select select=new Select(eu.getCountryCodeSelectionButton());
        select.selectByVisibleText("Amerika Birleşik Devletleri");

    }

    @And("Click on continue")
    public void clickOnContinue() {
        eu.clickMethod(eu.getContinueToPaymentButton());
    }

    @Then("User should land on the payment page")
    public void userShouldLandOnThePaymentPage() {
        Assert.assertTrue(eu.verifyIsDisplayedMethod(eu.getPayButton()));
    }

    @When("Select the company")
    public void selectTheCompany() {
        eu.clickMethod(eu.getPamukkaleCompany().get(1));
    }

    @And("Choose the seat is already booked")
    public void chooseTheSeatIsAlreadyBooked() {
eu.clickMethod(eu.getBookedSeat());
    }

    @Then("User should see the warning message")
    public void userShouldSeeTheWarningMessage() {
        Assert.assertTrue(eu.verifyIsDisplayedMethod(eu.getWarningMessage()));
    }
}
