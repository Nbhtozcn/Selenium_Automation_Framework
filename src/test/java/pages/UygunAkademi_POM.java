package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;
import utilities.MyMethods;

import java.util.List;

public class UygunAkademi_POM extends MyMethods {
    public UygunAkademi_POM() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(id = "firstname")
    private WebElement nameInput;
    @FindBy(css = "input[type='email']")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(css = "input[name='RegisterAccount.ConfirmPassword']")
    private WebElement confirmPasswordInput;
    @FindBy(id = "IsCitizenShip")
    private WebElement isCitizenShipCheckBox;
    @FindBy(css = "input[name='next']")
    private WebElement nextButton;

    @FindBy(css = "div.icon")
    private List<WebElement> accountTypes;
    @FindBy(id = "RegisterStudent_PhoneNumber")
    private WebElement studentPhoneNumberInput;
    @FindBy(id = "RegisterStudent_IdentityNumber")
    private WebElement studentIdentityNumber;
    @FindBy(css = "select[id='Levels']")
    private WebElement levelsSelector;
    @FindBy(css = "select[id='classroomName']")
    private WebElement classSelector;
    @FindBy(css = "input[value='Kayıt Ol']")
    private WebElement signupButton;
    @FindBy(xpath = "//*[@id='RegisterResult_ActivationCode']/following-sibling::div//h4")
    private WebElement successMessage;
    @FindBy(css = "p[class='description']")
    private List<WebElement> descriptions;
    @FindBy(id = "RegisterStudent_PhoneNumber-error")
    private WebElement phoneNumberErrorMessage;
    @FindBy(id = "RegisterStudentParent_PhoneNumber")
    private WebElement parentPhoneNumber;
    @FindBy(id = "RegisterStudentParent_IdentityNumber")
    private WebElement parentIdentityNumber;
    @FindBy(css = "input[id='activationKeyValue']")
    private WebElement activationKeyInput;
    @FindBy(css = "input[value='Sorgula']")
    private WebElement sorgulaButton;

    public WebElement getSorgulaButton() {
        return sorgulaButton;
    }

    public WebElement getActivationKeyInput() {
        return activationKeyInput;
    }

    public WebElement getParentIdentityNumber() {
        return parentIdentityNumber;
    }

    public WebElement getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public WebElement getPhoneNumberErrorMessage() {
        return phoneNumberErrorMessage;
    }

    public List<WebElement> getDescriptions() {
        return descriptions;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public WebElement getSignupButton() {
        return signupButton;
    }

    public WebElement getClassSelector() {
        return classSelector;
    }

    public WebElement getLevelsSelector() {
        return levelsSelector;
    }

    public WebElement getStudentIdentityNumber() {
        return studentIdentityNumber;
    }

    public WebElement getStudentPhoneNumberInput() {
        return studentPhoneNumberInput;
    }

    public List<WebElement> getAccountTypes() {
        return accountTypes;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getConfirmPasswordInput() {
        return confirmPasswordInput;
    }

    public WebElement getIsCitizenShipCheckBox() {
        return isCitizenShipCheckBox;
    }
}
