package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;
import utilities.MyMethods;

import java.util.List;

public class EnUygun_POM extends MyMethods {
    public EnUygun_POM() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }
    @FindBy(css = "a[data-dialog-type='login']")
    private WebElement loginButton;
    @FindBy(css = "input[name='_email']")
    private WebElement emailInput;
    @FindBy(xpath = "(//input[@type='password'])[6]")
    private WebElement passwordInput;
    @FindBy(css = ".MuiButton01222:nth-child(1)")
    private WebElement submitButton;
    @FindBy(xpath = "//span[text()='Otobüs Bileti']")
    private WebElement busTab;
    @FindBy(xpath = "(//input[@data-testid='originsearchInput'])[1]")
    private WebElement origin;
    @FindBy(xpath = "(//input[@data-testid='destinationsearchInput'])[1]")
    private WebElement destination;
    @FindBy(css = "div[data-testid='search-from_datepicker']")
    private WebElement departureDateButton;
    @FindBy(css = "td[aria-label='Pazartesi, 10 Temmuz 2023']")
    private WebElement getDepartureDate;
    @FindBy(xpath = "(//strong[text()='Otobüs bileti bul'])[1]")
    private WebElement continueButton;
    @FindBy(xpath = "//img[contains(@alt,'Pamukkale')]")
    private List<WebElement> pamukkaleCompany;
    @FindBy(xpath = "//div[contains(@class,'hover-active')]")
    private List<WebElement> firstAvailableSeat;
    @FindBy(xpath = "//span[text()='Erkek']")
    private WebElement genderButtonForMale;
    @FindBy(id = "accept_and_continue")
    private WebElement acceptAndContinueButton;
    @FindBy(css = "input[name='contact_email']")
    private WebElement emailAddressBeforePayment;
    @FindBy(css = "input[name='contact_phone_number']")
    private WebElement phoneNumberBeforePayment;
    @FindBy(id = "passenger0_firstname")
    private WebElement passengerName;
    @FindBy(id = "passenger0_lastname")
    private WebElement passengerLastname;
    @FindBy (xpath = "(//span[@data-testid='bus-checkmark'])[2]")
    private WebElement nonCitizenCheckbox;
    @FindBy(css = "input[name='passengers[0][passport_no]']")
    private WebElement passportNumber;
    @FindBy(css = "select[name='passengers[0][passport_country_code]']")
    private WebElement countryCodeSelectionButton;
    @FindBy(xpath = "//span[text()='Ödemeye İlerle']")
    private WebElement continueToPaymentButton;
    @FindBy(xpath = "//div[text()='Ödeme yap']")
    private WebElement payButton;

    public WebElement getEmailAddressBeforePayment() {
        return emailAddressBeforePayment;
    }

    public WebElement getPhoneNumberBeforePayment() {
        return phoneNumberBeforePayment;
    }

    public WebElement getPassengerName() {
        return passengerName;
    }

    public WebElement getPassengerLastname() {
        return passengerLastname;
    }

    public WebElement getNonCitizenCheckbox() {
        return nonCitizenCheckbox;
    }

    public WebElement getPassportNumber() {
        return passportNumber;
    }

    public WebElement getCountryCodeSelectionButton() {
        return countryCodeSelectionButton;
    }

    public WebElement getContinueToPaymentButton() {
        return continueToPaymentButton;
    }

    public WebElement getPayButton() {
        return payButton;
    }

    public WebElement getOrigin() {
        return origin;
    }

    public WebElement getDestination() {
        return destination;
    }

    public WebElement getDepartureDateButton() {
        return departureDateButton;
    }

    public WebElement getGetDepartureDate() {
        return getDepartureDate;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public List<WebElement> getPamukkaleCompany() {
        return pamukkaleCompany;
    }

    public List<WebElement> getFirstAvailableSeat() {
        return firstAvailableSeat;
    }

    public WebElement getGenderButtonForMale() {
        return genderButtonForMale;
    }

    public WebElement getAcceptAndContinueButton() {
        return acceptAndContinueButton;
    }

    public WebElement getBusTab() {
        return busTab;
    }


    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }
}
