package step_definitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Nescafe_POM;
import utilities.DriverClass;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class Nescafe_Test {
    String priceOnNescafe;
    String nameOnNescafe;
    String priceOnMigros;
    String nameOnMigros;

    Nescafe_POM nescafe=new Nescafe_POM();
    @Given("I open the web browser and navigate to {string}")
    public void iOpenTheWebBrowserAndNavigateTo(String arg0) {
        DriverClass.getDriver().get("https://www.nescafe.com/tr/");

    }
    @When("I click on the Satin Al button")
    public void iClickOnTheSatinAlButton() {
        nescafe.clickMethod(nescafe.getSatinAlButton());
        nescafe.setWait(10);
    }
    @And("I select Migros Sanal Market from desired supermarket brand options")
    public void iSelectMigrosSanalMarketFromDesiredSupermarketBrandOptions() {
        DriverClass.getDriver().switchTo().frame(nescafe.getIframe());
        nescafe.clickMethod(nescafe.getMigrosSanalMarket());
        nescafe.setWait(5);
    }

    @And("And I extract the price and name displayed on the nescafe.com website for at index {string}")
    public void andIExtractThePriceAndNameDisplayedOnTheNescafeComWebsiteForAtIndex(String index) {
        int productIndex = Integer.parseInt(index);
        nameOnNescafe=nescafe.getNameOfProductsOnNescafe().get(productIndex).getText();
        priceOnNescafe=nescafe.getPriceOfProductsOnNescafe().get(productIndex).getText();
        nescafe.clickMethod(nescafe.getBuySingleProduct().get(productIndex));
    }

    @And("I navigate to the selected supermarket's website")
    public void iNavigateToTheSelectedSupermarketSWebsite() {
        Set<String> windowHandles = DriverClass.getDriver().getWindowHandles();
        String[] handlesArray = windowHandles.toArray(new String[0]);
        DriverClass.getDriver().switchTo().window(handlesArray[1]);
        nescafe.setWait(20);
    }
    @And("I extract the price and name displayed on the supermarket's website")
    public void iExtractThePriceAndNameDisplayedOnTheSupermarketSWebsite() {
        priceOnMigros=nescafe.getSingleProductPriceOnMigros().getText();
        nameOnMigros=nescafe.getNameOfTheProductOnMigros().getText();
    }
    @Then("I compare the prices and the names to see if they are the same")
    public void iCompareThePricesAndTheNamesToSeeIfTheyAreTheSame() {
        Assert.assertTrue(priceOnNescafe.contains(priceOnMigros.substring(0,5)));
        Assert.assertEquals(nameOnMigros,nameOnNescafe);
    }


}
