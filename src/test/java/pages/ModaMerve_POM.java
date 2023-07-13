package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;
import utilities.MyMethods;

import java.util.List;

public class ModaMerve_POM extends MyMethods {
    public ModaMerve_POM() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(css = "a[title='SİZDEN GELENLER']")
    private WebElement yourPhotosButton;
    @FindBy(css = "a.col.kargotakip")
    private WebElement cargoTrackingButton;

    //image link product link commentOfProduct, Date of Photo
    @FindBy(css = "div[class='product neumorphic ridge']")
    private List<WebElement> listOfYourPhotos;

    @FindBy(css = "div[class='product neumorphic ridge']>div[class='cart']>a")
    private List<WebElement> listOfProductLink;
    @FindBy(css = "div[class='product neumorphic ridge']>div>a>img")
    private List<WebElement> listOfPhotoLinks;
    @FindBy(css = "div[class='comment']")
    private List<WebElement> listOfComments;
    @FindBy(css = "div[class='date']")
    private List<WebElement> listOfDates;
    @FindBy(css = "button[id='ProductsenderCargoFinder_findCargoBtn']")
    private WebElement displayCargoTrackButtonForNonMember;
    @FindBy(xpath = "//a[text()='Account']")
    private WebElement homePageAccountButton;
    @FindBy(id = "member-register")
    private WebElement signUpButton;
    @FindBy(id = "password")
    private WebElement registerPasswordInput;
    @FindBy(id = "password_again")
    private WebElement registerPasswordAgainInput;
    @FindBy(xpath = "//span[text()='Password not confirmed.']")
    private WebElement passwordNotConfirmedErrorMessage;
    @FindBy(xpath = "//span[text()='Must be min 6 character.']")
    private WebElement passwordLengthErrorMessage;
    @FindBy(css = "input[id='name']")
    private WebElement registerNameInput;
    @FindBy(css = "input[id='surname']")
    private WebElement registerSurnameInput;
    @FindBy(css = "div[class='myFlagIcon']")
    private WebElement registerCountryCodeDropdownMenu;
    @FindBy(xpath = "//span[text()='USA']")
    private WebElement registerUSAFromCountryDropdown;
    @FindBy(css = "input[id='mobile_phone']")
    private WebElement registerPhoneNumberInput;
    @FindBy(css = "input[id='email']")
    private WebElement registerEmailInput;
    @FindBy(xpath = "(//div[@class='fl input-wrap checkbox'])[4]")
    private WebElement registerMemberShipAgreementCheckbox;
    @FindBy(xpath = "(//div[@class='fl input-wrap checkbox'])[5]")
    private WebElement registerKVKKCheckbox;
    @FindBy(css = "button[id='uye-kayit-btn-btn']")
    private WebElement registerSaveButton;
    @FindBy(css = "div[id='mainColumn']>div:nth-child(2)")
    private WebElement registerSuccessMessage;
    @FindBy(css = "div[class='fl col-12 catalogWrapper']>div>div>div>a")
    private List<WebElement> listOfProducts;
    @FindBy(css = "div.fl.col-12.proRowName>div>a")
    private List<WebElement> nameListOfTheProducts;
    @FindBy(css = ".fl.col-12.ease.variantList>a")
    private List<WebElement> listOfSizes;
    @FindBy(xpath = "(//a[@id='addCartBtn'])[2]")
    private WebElement addToCartButton;
    @FindBy(css = "span.basketlist-productinfo-title")
    private WebElement singleProductNameInTheCart;
    @FindBy(css = "div[class='col col-6 col-xs-12 a-left p-left currentPrice discoF simge-tl ']")
    private WebElement priceOfTheProductInTheContent;
    @FindBy(css = ".shoppingReview_container>dl>div>dd")
    private WebElement singleProductPriceInTheCart;

    public List<WebElement> getNameListOfTheProducts() {
        return nameListOfTheProducts;
    }

    public WebElement getSingleProductPriceInTheCart() {
        return singleProductPriceInTheCart;
    }

    public WebElement getPriceOfTheProductInTheContent() {
        return priceOfTheProductInTheContent;
    }

    public WebElement getSingleProductNameInTheCart() {
        return singleProductNameInTheCart;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public List<WebElement> getListOfSizes() {
        return listOfSizes;
    }

    public List<WebElement> getListOfProducts() {
        return listOfProducts;
    }

    public WebElement getRegisterSuccessMessage() {
        return registerSuccessMessage;
    }

    public WebElement getRegisterSaveButton() {
        return registerSaveButton;
    }

    public WebElement getRegisterCountryCodeDropdownMenu() {
        return registerCountryCodeDropdownMenu;
    }

    public WebElement getRegisterUSAFromCountryDropdown() {
        return registerUSAFromCountryDropdown;
    }

    public WebElement getRegisterNameInput() {
        return registerNameInput;
    }

    public WebElement getRegisterSurnameInput() {
        return registerSurnameInput;
    }

    public WebElement getRegisterPhoneNumberInput() {
        return registerPhoneNumberInput;
    }

    public WebElement getRegisterEmailInput() {
        return registerEmailInput;
    }

    public WebElement getRegisterMemberShipAgreementCheckbox() {
        return registerMemberShipAgreementCheckbox;
    }

    public WebElement getRegisterKVKKCheckbox() {
        return registerKVKKCheckbox;
    }

    public WebElement getPasswordLengthErrorMessage() {
        return passwordLengthErrorMessage;
    }

    public WebElement getPasswordNotConfirmedErrorMessage() {
        return passwordNotConfirmedErrorMessage;
    }

    public WebElement getRegisterPasswordAgainInput() {
        return registerPasswordAgainInput;
    }

    public WebElement getRegisterPasswordInput() {
        return registerPasswordInput;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getHomePageAccountButton() {
        return homePageAccountButton;
    }

    public WebElement getDisplayCargoTrackButtonForNonMember() {
        return displayCargoTrackButtonForNonMember;
    }

    public List<WebElement> getListOfYourPhotos() {
        return listOfYourPhotos;
    }

    public List<WebElement> getListOfProductLink() {
        return listOfProductLink;
    }

    public List<WebElement> getListOfPhotoLinks() {
        return listOfPhotoLinks;
    }

    public List<WebElement> getListOfComments() {
        return listOfComments;
    }

    public List<WebElement> getListOfDates() {
        return listOfDates;
    }

    public WebElement getCargoTrackingButton() {
        return cargoTrackingButton;
    }

    public WebElement getYourPhotosButton() {
        return yourPhotosButton;
    }
}
