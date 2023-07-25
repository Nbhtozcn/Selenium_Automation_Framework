package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.Nobel_Yayin_POM;
import utilities.DriverClass;

public class Nobel_Yayin_Test2 {
    String nameOfTheFavoriteBookAfterSearch;
    String nameOfTheFavoriteBookInFavorites;

    Nobel_Yayin_POM nobelYayin = new Nobel_Yayin_POM();

    @Given("The user is on the homepage")
    public void TheUserIsOnTheHomepage() {
        DriverClass.getDriver().get("https://www.nobelyayin.com/");
    }

    @And("The user select English as language")
    public void theUserSelectEnglishAsLanguage() {
        nobelYayin.clickMethod(nobelYayin.getLanguageAsEnglishButton());
    }

    @When("I click on Education button from Categories")
    public void iClickOnEducationButtonFromCategories() {
        nobelYayin.clickMethod(nobelYayin.getEducationButtonUnderCategories());
    }

    @And("I select Descending by Price")
    public void iSelectDescendingByPrice() {
        Select select = new Select(nobelYayin.getSelectOrderTypeButton());
        select.selectByVisibleText("Descending by Price");
    }

    @And("I click Add to Cart button for the first book priced over {int}")
    public void iClickAddToCartButtonForTheFirstBookPricedOver(int arg0) {
        for (int i = 0; i < nobelYayin.getListOfPriceForEducationBook().size(); i++) {
            if (extractIntegerValue(nobelYayin.getListOfPriceForEducationBook().get(i).getText()) > 400) {
                nobelYayin.clickMethod(nobelYayin.getListOfBuyButtonForEducationBook().get(i));
                break;
            }
        }
        nobelYayin.clickMethod(nobelYayin.getAddToCartButton());
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        nobelYayin.clickMethod(nobelYayin.getCompleteTheTransactionButton());
    }

    @Then("I should see that the shipping fee is {double}₺")
    public void iShouldSeeThatTheShippingFeeIs₺(double arg0) {
        int cargoPrice = extractIntegerValue(nobelYayin.getCargoPriceInTheCart().getText());
        Assert.assertEquals(cargoPrice, 0);

    }

    @And("I click Add to Cart button for the first book priced less than {int}")
    public void iClickAddToCartButtonForTheFirstBookPricedLessThan(int arg0) {
        for (int i = 0; i < nobelYayin.getListOfPriceForEducationBook().size(); i++) {
            System.out.println(nobelYayin.getListOfPriceForEducationBook().get(i).getText());
            if (extractIntegerValue(nobelYayin.getListOfPriceForEducationBook().get(i).getText()) > 100) {
                nobelYayin.clickMethod(nobelYayin.getListOfBuyButtonForEducationBook().get(i));
                break;
            }
        }
        nobelYayin.clickMethod(nobelYayin.getAddToCartButton());

    }

    @Then("I should see the shipping fee calculated as {double}₺")
    public void iShouldSeeTheShippingFeeCalculatedAs₺(double arg0) {
        int cargoPrice = extractIntegerValue(nobelYayin.getCargoPriceInTheCart().getText());
        Assert.assertEquals(cargoPrice, 2700);
    }

    @And("I am logged in to my account")
    public void iAmLoggedInToMyAccount() {
        nobelYayin.clickMethod(nobelYayin.getHomepageLoginSignupButton());
        nobelYayin.sendKeysMethod(nobelYayin.getLoginEmailAddress(), "qahuntproject@gmail.com");
        nobelYayin.sendKeysMethod(nobelYayin.getLoginPassword(), "qahunt");
        nobelYayin.clickMethod(nobelYayin.getLoginSubmitButton());
        DriverClass.getDriver().navigate().back();
        DriverClass.getDriver().navigate().back();


    }

    @When("I search for a book using its title")
    public void iSearchForABookUsingItsTitle() {
        nobelYayin.sendKeysMethod(nobelYayin.getSearchButton(), "Algoritma Tasarımı ve Geliştirme - JAVA ve C# Programlama Dili Örnekleri");


    }

    @And("I find a book that I want to add to my favorites")
    public void iFindABookThatIWantToAddToMyFavorites() {
        nobelYayin.setWait(3);
        nobelYayin.clickMethod(nobelYayin.getSeeAllBooksButtonAfterSearch());
    }

    @When("I click on the {string} button for that book")
    public void iClickOnTheButtonForThatBook(String arg0) {
        nobelYayin.clickMethod(nobelYayin.getAddToFavoritesButton());
        nameOfTheFavoriteBookAfterSearch = nobelYayin.getNameOfTheFavoriteBookAfterSearch().getText();


    }

    @And("I should see a confirmation message indicating that the book has been added successfully")
    public void iShouldSeeAConfirmationMessageIndicatingThatTheBookHasBeenAddedSuccessfully() {
        Assert.assertTrue(nobelYayin.verifyIsDisplayedMethod(nobelYayin.getAddToFavoritesVerificationMessage()));
    }

    @Then("the book should be added to my list of favorite books")
    public void theBookShouldBeAddedToMyListOfFavoriteBooks() {
        nobelYayin.clickMethod(nobelYayin.getMyAccountButton());
        nobelYayin.clickMethod(nobelYayin.getMyFavoritesButton());
        nameOfTheFavoriteBookInFavorites = nobelYayin.getNameOfTheFavoriteBookInFav().getText();
        Assert.assertEquals(nameOfTheFavoriteBookAfterSearch, nameOfTheFavoriteBookInFavorites);

    }

    @Then("I click on My Account button")
    public void iClickOnMyAccountButton() {
        nobelYayin.clickMethod(nobelYayin.getMyAccountButton());
    }

    @When("I click on My Favorites button")
    public void iClickOnMyFavoritesButton() {
        nobelYayin.clickMethod(nobelYayin.getMyFavoritesButton());
    }


    @When("I click on the Remove button for that book")
    public void iClickOnTheRemoveButtonForThatBook() {
        nobelYayin.clickMethod(nobelYayin.getRemoveFromFavButton());
    }

    @Then("the book should be removed from my list of favorite books")
    public void theBookShouldBeRemovedFromMyListOfFavoriteBooks() {
        nobelYayin.setWait(2);
        Assert.assertTrue(nobelYayin.getProductNotFoundInFav().isDisplayed());
    }

    public int extractIntegerValue(String text) {
        String cleanedText = text.replaceAll("[^0-9]", "");
        cleanedText = cleanedText.replace(",", "");
        return Integer.parseInt(cleanedText);
    }


    @When("Signup")
    public void signup() {

    }
}
