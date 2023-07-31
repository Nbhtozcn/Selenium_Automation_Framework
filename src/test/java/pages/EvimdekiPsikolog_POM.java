package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;
import utilities.MyMethods;

import java.util.List;

public class EvimdekiPsikolog_POM extends MyMethods {
    public EvimdekiPsikolog_POM() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }
    @FindBy(xpath = "(//button[@class='btn btn-block btn-default multiselect dropdown-toggle text-left custom-select text-center'])[2]")
    private WebElement titleButton;
    @FindBy(css = "select[id='title']")
    private WebElement selection;
    @FindBy(id = "consultant-search")
    private WebElement searchButton;
    @FindBy(xpath = "//a[text()='PSİKOLOGLAR']")
    private WebElement psikologlar;
    @FindBy(xpath = "(//span[@class='multiselect-selected-text'])[2]")
    private WebElement selectedTitle;
    @FindBy(css = "div.bs4-row.align-items-end")
    private WebElement choiceSection;
    @FindBy(xpath = "//a[text()='TOPLULUK']")
    private WebElement toplulukButton;
    @FindBy(css = ".card-body>button")
    private List<WebElement> katilButtons;
    @FindBy(css = "div.card-title.titleCommunityType")
    private List<WebElement> communityTypeBeforeKatil;
    @FindBy(css = ".mca10d787e_userName")
    private WebElement communityTypeAfterKatil;
    @FindBy(xpath = "//*[contains(text(), 'Üye sayısı')]")
    private WebElement numberOfMemberInCommunity;

    public WebElement getToplulukButton() {
        return toplulukButton;
    }

    public List<WebElement> getKatilButtons() {
        return katilButtons;
    }

    public List<WebElement> getCommunityTypeBeforeKatil() {
        return communityTypeBeforeKatil;
    }

    public WebElement getCommunityTypeAfterKatil() {
        return communityTypeAfterKatil;
    }

    public WebElement getNumberOfMemberInCommunity() {
        return numberOfMemberInCommunity;
    }

    public WebElement getChoiceSection() {
        return choiceSection;
    }

    public WebElement getTitleButton() {
        return titleButton;
    }

    public WebElement getSelection() {
        return selection;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getPsikologlar() {
        return psikologlar;
    }

    public WebElement getSelectedTitle() {
        return selectedTitle;
    }
}
