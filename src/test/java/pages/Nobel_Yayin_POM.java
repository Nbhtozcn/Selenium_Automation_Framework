package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;
import utilities.MyMethods;

import java.util.List;

public class Nobel_Yayin_POM extends MyMethods {
    public Nobel_Yayin_POM() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Sing Up']")
    private WebElement signUpButton;
    @FindBy(css = "input[placeholder='Your Name']")
    private WebElement signupNameInput;
    @FindBy(css = "input[placeholder='Your Surname']")
    private WebElement signupSurnameInput;
    @FindBy(css = "input[placeholder='Your telephone number']")
    private WebElement signupPhoneNumber;
    @FindBy(xpath = "(//input[@placeholder='E-Mail Address'])[2]")
    private WebElement signupEmailAddress;
    @FindBy(xpath = "(//input[@placeholder='Your password'])[2]")
    private WebElement signupPassword;
    @FindBy(xpath = "(//input[@type='submit'])[2]")
    private WebElement signupSubmitButton;
    @FindBy(xpath = "(//a[text()='My Account'])[2]")
    private WebElement myAccountButton;
    @FindBy(xpath = "(//a[@id='HesabimCikisYap'])[2]")
    private WebElement logoutButton;
    @FindBy(xpath = "//a[text()='LEADERSHIP TEAM']")
    private WebElement leaderShipTeamButton;
    @FindBy(css = "div.diller>font:nth-child(2)")
    private WebElement languageAsEnglishButton;
    @FindBy(xpath = "//a[text()='Login / Sing Up']")
    private WebElement homepageLoginSignupButton;
    @FindBy(css = "ul.kategoriler>li:nth-child(2)>a")
    private WebElement educationButtonUnderCategories;
    @FindBy(css = "select[id='sirala']")
    private WebElement selectOrderTypeButton;
    @FindBy(css = "div.bilgi>span:nth-child(2)")
    private List<WebElement> listOfPriceForEducationBook;
    @FindBy(css = "div.bilgi>button")
    private List<WebElement> listOfBuyButtonForEducationBook;
    @FindBy(id = "satinAlDugme")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[text()='Complete the Transaction']")
    private WebElement completeTheTransactionButton;
    @FindBy(css = "div.siparisOzeti>div:nth-child(3)>font:nth-child(2)")
    private WebElement cargoPriceInTheCart;
    @FindBy(xpath = "(//input[@placeholder='E-Mail Address'])[1]")
    private WebElement loginEmailAddress;
    @FindBy(xpath = "(//input[@placeholder='Your password'])[1]")
    private WebElement loginPassword;
    @FindBy(xpath = "(//input[@type='submit'])[1]")
    private WebElement loginSubmitButton;
    @FindBy(id = "arama")
    private WebElement searchButton;
    @FindBy(css = "div.sonucIcerikKitap.sonucIcerik")
    private WebElement seeAllBooksButtonAfterSearch;
    @FindBy(css = "div.urunler>ul>li>a")
    private WebElement searchedBookLink;

    @FindBy(xpath = "//font[text()='Add to Favorites']")
    private WebElement addToFavoritesButton;
    @FindBy(css = "div.MesajOnay")
    private WebElement addToFavoritesVerificationMessage;
    @FindBy(css = "div.kitapBaslik")
    private WebElement nameOfTheFavoriteBookAfterSearch;
    @FindBy(css = "li>div>a:nth-child(1)")
    private WebElement nameOfTheFavoriteBookInFav;
    @FindBy(css = "li>div>a:nth-child(2)")
    private WebElement removeFromFavButton;
    @FindBy(xpath = "//a[text()=' My Favorites']")
    private WebElement myFavoritesButton;
    @FindBy(css = "div.sepetBos")
    private WebElement productNotFoundInFav;

    public WebElement getProductNotFoundInFav() {
        return productNotFoundInFav;
    }

    public WebElement getMyFavoritesButton() {
        return myFavoritesButton;
    }

    public WebElement getRemoveFromFavButton() {
        return removeFromFavButton;
    }

    public WebElement getNameOfTheFavoriteBookInFav() {
        return nameOfTheFavoriteBookInFav;
    }

    public WebElement getNameOfTheFavoriteBookAfterSearch() {
        return nameOfTheFavoriteBookAfterSearch;
    }

    public WebElement getAddToFavoritesVerificationMessage() {
        return addToFavoritesVerificationMessage;
    }

    public WebElement getAddToFavoritesButton() {
        return addToFavoritesButton;
    }

    public WebElement getSearchedBookLink() {
        return searchedBookLink;
    }

    public WebElement getSeeAllBooksButtonAfterSearch() {
        return seeAllBooksButtonAfterSearch;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getLoginSubmitButton() {
        return loginSubmitButton;
    }

    public WebElement getLoginEmailAddress() {
        return loginEmailAddress;
    }

    public WebElement getLoginPassword() {
        return loginPassword;
    }

    public WebElement getCargoPriceInTheCart() {
        return cargoPriceInTheCart;
    }

    public WebElement getCompleteTheTransactionButton() {
        return completeTheTransactionButton;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public List<WebElement> getListOfBuyButtonForEducationBook() {
        return listOfBuyButtonForEducationBook;
    }

    public List<WebElement> getListOfPriceForEducationBook() {
        return listOfPriceForEducationBook;
    }

    public WebElement getSelectOrderTypeButton() {
        return selectOrderTypeButton;
    }

    public WebElement getEducationButtonUnderCategories() {
        return educationButtonUnderCategories;
    }

    public WebElement getHomepageLoginSignupButton() {
        return homepageLoginSignupButton;
    }

    public WebElement getLanguageAsEnglishButton() {
        return languageAsEnglishButton;
    }

    public WebElement getLeaderShipTeamButton() {
        return leaderShipTeamButton;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getMyAccountButton() {
        return myAccountButton;
    }

    public WebElement getSignupNameInput() {
        return signupNameInput;
    }

    public WebElement getSignupSurnameInput() {
        return signupSurnameInput;
    }

    public WebElement getSignupPhoneNumber() {
        return signupPhoneNumber;
    }

    public WebElement getSignupEmailAddress() {
        return signupEmailAddress;
    }

    public WebElement getSignupPassword() {
        return signupPassword;
    }

    public WebElement getSignupSubmitButton() {
        return signupSubmitButton;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }
}
