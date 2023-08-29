package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;
import utilities.MyMethods;

public class Promist_POM extends MyMethods {
    public Promist_POM() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }
    @FindBy(css = ".float-lg-right > span")
    private WebElement UyeGirisiButton;
    @FindBy(css = "#txtemail")
    private WebElement emailInput;
    @FindBy(css = "#txtpassword")
    private WebElement passwordInput;
    @FindBy(css = "button[class='btn btn-primary user-name-button']")
    private WebElement submitButtonForLogin;
    @FindBy(css = "button[name='btn_user_menu_model']>span")
    private WebElement myNameAfterLoggedIn;
    @FindBy(xpath = "(//a[@class='nav-link dropdown-toggle'])[1]")
    private WebElement UrunlerimizFromNavBar;
    @FindBy(xpath = "((//a[@class='nav-link dropdown-toggle'])[1]/following-sibling::ul//li)[1]//a")
    private WebElement b2cETicaretPaketleri;
    @FindBy(css = "a.form-close-button")
    private WebElement closeThePopUpButton;
    @FindBy(xpath = "(//div[@class='package package package-2']//div//a)[1]")
    private WebElement b2cETicaretStandartSatinAlButton;
    @FindBy(css = "a[class='add-to-cart-detail']")
    private WebElement addToCartButton;
    @FindBy(css = "span.my-cart-title.float-left")
    private WebElement cartButton;
    @FindBy(css = "a[class='btn btn-success']")
    private WebElement viewTheCartButton;
    @FindBy(css = "td.product-name>a")
    private WebElement productName;
    @FindBy(css = "input[class='cartQuantity']")
    private WebElement quantityInputInTheCart;
    @FindBy(css = "span.cart-price.bigger")
    private WebElement priceOfTheProductInTheCart;
    @FindBy(css = "a[class='btn btn-success update']")
    private  WebElement updateButtonInTheCart;
    @FindBy(css = "a[class='delete']")
    private WebElement deleteButtonInTheCart;
    @FindBy(css = "button[class='btn btn-primary bootbox-accept']")
    private WebElement acceptDeleteButton;
    @FindBy(css = ".alert-heading>span")
    private WebElement emptyCartText;

    public WebElement getEmptyCartText() {
        return emptyCartText;
    }

    public WebElement getAcceptDeleteButton() {
        return acceptDeleteButton;
    }

    public WebElement getDeleteButtonInTheCart() {
        return deleteButtonInTheCart;
    }

    public WebElement getUpdateButtonInTheCart() {
        return updateButtonInTheCart;
    }

    public WebElement getPriceOfTheProductInTheCart() {
        return priceOfTheProductInTheCart;
    }

    public WebElement getQuantityInputInTheCart() {
        return quantityInputInTheCart;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getViewTheCartButton() {
        return viewTheCartButton;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getB2cETicaretStandartSatinAlButton() {
        return b2cETicaretStandartSatinAlButton;
    }

    public WebElement getCloseThePopUpButton() {
        return closeThePopUpButton;
    }

    public WebElement getB2cETicaretPaketleri() {
        return b2cETicaretPaketleri;
    }

    public WebElement getUrunlerimizFromNavBar() {
        return UrunlerimizFromNavBar;
    }

    public WebElement getMyNameAfterLoggedIn() {
        return myNameAfterLoggedIn;
    }

    public WebElement getUyeGirisiButton() {
        return UyeGirisiButton;
    }

    public void setUyeGirisiButton(WebElement uyeGirisiButton) {
        UyeGirisiButton = uyeGirisiButton;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(WebElement emailInput) {
        this.emailInput = emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(WebElement passwordInput) {
        this.passwordInput = passwordInput;
    }

    public WebElement getSubmitButtonForLogin() {
        return submitButtonForLogin;
    }

    public void setSubmitButtonForLogin(WebElement submitButtonForLogin) {
        this.submitButtonForLogin = submitButtonForLogin;
    }
}
