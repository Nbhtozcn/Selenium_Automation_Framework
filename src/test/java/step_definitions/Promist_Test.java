package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Promist_POM;
import utilities.DriverClass;

public class Promist_Test {
    Promist_POM promist=new Promist_POM();
    double initialPrice;
    double newPrice;
    @Given("I am logged in to my proticaret account")
    public void iAmLoggedInToMyProticaretAccount() {
        DriverClass.getDriver().get("https://www.proticaret.org/");
        promist.clickMethod(promist.getUyeGirisiButton());
        promist.sendKeysMethod(promist.getEmailInput(),"qahunt@gmail.com");
        promist.sendKeysMethod(promist.getPasswordInput(),"qahunt");
        promist.clickMethod(promist.getSubmitButtonForLogin());
        promist.waitUntilVisible(promist.getMyNameAfterLoggedIn());
        Assert.assertTrue(promist.getMyNameAfterLoggedIn().getText().contains("qa hunt"));
    }

    @When("I click on Urunlerimiz button")
    public void iClickOnUrunlerimizButton() {
        promist.clickMethod(promist.getUrunlerimizFromNavBar());



    }

    @And("Click b{int}cETicaretPaketleri from dropdown menu")
    public void clickBCETicaretPaketleriFromDropdownMenu(int arg0) {
        promist.clickMethod(promist.getB2cETicaretPaketleri());
    }

    @And("I close the popup")
    public void iCloseThePopup() {
        promist.clickMethod(promist.getCloseThePopUpButton());
    }

    @When("I click on Satin Al button for Standart option and add to cart")
    public void iClickOnSatinAlButtonForStandartOptionAndAddToCart() {
        promist.clickMethod(promist.getB2cETicaretStandartSatinAlButton());
        promist.clickMethod(promist.getAddToCartButton());
        DriverClass.getDriver().navigate().refresh();
    }

    @Then("I should see the product is in the Cart")
    public void iShouldSeeTheProductIsInTheCart() {
        promist.clickMethod(promist.getCartButton());
        promist.clickMethod(promist.getViewTheCartButton());
        promist.waitUntilVisible(promist.getProductName());
        Assert.assertTrue(promist.getProductName().getText().contains("Standart"));


    }

    @When("I go to my cart")
    public void iGoToMyCart() {
        promist.clickMethod(promist.getCartButton());
        promist.clickMethod(promist.getViewTheCartButton());
        promist.waitUntilVisible(promist.getProductName());

    }

    @And("I change the product name and save")
    public void iChangeTheProductNameAndSave() {
        String initialPriceText=promist.getPriceOfTheProductInTheCart().getText();
        double initialPrice=Double.parseDouble(initialPriceText.replaceAll("\\D+", "")) / 100;
        promist.getQuantityInputInTheCart().clear();
        promist.sendKeysMethod(promist.getQuantityInputInTheCart(),"2");
        promist.clickMethod(promist.getUpdateButtonInTheCart());
        String newPriceText = promist.getPriceOfTheProductInTheCart().getText();
        double newPrice = Double.parseDouble(newPriceText.replaceAll("\\D+", "")) / 100;


    }

    @Then("I should see the updated quantity and price accordingly")
    public void iShouldSeeTheUpdatedQuantityAndPriceAccordingly() {
        Assert.assertEquals(newPrice, initialPrice * 2, "New price is not double the initial price.");
    }


    @And("Click on delete button")
    public void clickOnDeleteButton() {
        promist.clickMethod(promist.getDeleteButtonInTheCart());
        promist.clickMethod(promist.getAcceptDeleteButton());
        DriverClass.getDriver().navigate().refresh();
    }

    @Then("I should see the product removed from the cart")
    public void iShouldSeeTheProductRemovedFromTheCart() {
        Assert.assertTrue(promist.getEmptyCartText().isDisplayed());
    }
}
