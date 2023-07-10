package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.EnUygun_POM;
import utilities.DriverClass;

import java.time.Duration;
import java.util.HashMap;

public class EnUygunTest {
    HashMap<String, String> actualHashMap;
    EnUygun_POM eu = new EnUygun_POM();

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
        eu.sendKeysMethod(eu.getOrigin(), "Istanbul");
        eu.sendKeysMethod(eu.getDestination(), "Izmir");
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
        eu.sendKeysMethod(eu.getEmailAddressBeforePayment(), "qahuntproject@gmail.com");
        eu.sendKeysMethod(eu.getPhoneNumberBeforePayment(), "5555555555");
        eu.sendKeysMethod(eu.getPassengerName(), "John");
        eu.sendKeysMethod(eu.getPassengerLastname(), "Doe");
        eu.clickMethod(eu.getNonCitizenCheckbox());
        eu.sendKeysMethod(eu.getPassportNumber(), "34738292");
        Select select = new Select(eu.getCountryCodeSelectionButton());
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

    @And("Click each of navigate bar link")
    public void clickEachOfNavigateBarLink() {
        actualHashMap = new HashMap<>();
        for (WebElement element : eu.getNavbarLinkList()) {
            String key = element.getText();
            element.click();
            String value = DriverClass.getDriver().getCurrentUrl();
            actualHashMap.put(key, value);
            DriverClass.getDriver().navigate().back();
        }
    }

    @Then("Verify that the page has loaded successfully by checking the page URL")
    public void verifyThatThePageHasLoadedSuccessfullyByCheckingThePageURL() {
        HashMap<String, String> expectedMap = new HashMap<>();
        expectedMap.put("Uçak Bileti", "https://www.enuygun.com/ucak-bileti/");
        expectedMap.put("Otobüs Bileti", "https://www.enuygun.com/otobus-bileti/");
        expectedMap.put("Otel", "https://www.enuygun.com/otel/");
        expectedMap.put("Araç Kiralama", "https://www.enuygun.com/arac-kiralama/");
        expectedMap.put("Transfer", "https://www.enuygun.com/transfer/");
        Assert.assertEquals(actualHashMap, expectedMap);
    }

    @Given("Go to hepsiburada")
    public void goToHepsiburada() {
        DriverClass.getDriver().get("https://www.hepsiburada.com/");
        DriverClass.getDriver().findElement(By.cssSelector("button[id='onetrust-accept-btn-handler']"));
        DriverClass.setWait(2);
        JavascriptExecutor jse = (JavascriptExecutor) DriverClass.getDriver();
        jse.executeScript("arguments[0].click()", DriverClass.getDriver().findElement(By.xpath("//div[text()='Ürün, kategori veya marka ara']")));
        DriverClass.setWait(2);
        DriverClass.getDriver().findElement(By.cssSelector("input[placeholder='Ürün, kategori veya marka ara']")).sendKeys("Araba");
        DriverClass.setWait(2);
        DriverClass.getDriver().findElement(By.cssSelector("div[class='searchBoxOld-yDJzsIfi_S5gVgoapx6f']")).click();

    }
}
