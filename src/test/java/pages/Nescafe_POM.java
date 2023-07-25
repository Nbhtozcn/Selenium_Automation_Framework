package pages;

import io.cucumber.messages.types.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;
import utilities.MyMethods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nescafe_POM extends MyMethods {
    public Nescafe_POM() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='where-to-buy button red expanded'][contains(text(),'Satın Al')])[3]")
    private WebElement satinAlButton;
    @FindBy(css = "button[aria-label='Migros ile alışveriş yapın']")
    private WebElement migrosSanalMarket;
    @FindBy(css = "h4[class='productTitle fixedHeight']")
    private List<WebElement> nameOfProductsOnNescafe;
    @FindBy(id = "LightboxFrame_2")
    private WebElement iframe;
    @FindBy(css = "span[class='price ng-binding']")
    private List<WebElement> priceOfProductsOnNescafe;
    @FindBy(css = "button[class='button primary directAddLink']")
    private List<WebElement> buySingleProduct;
    @FindBy(xpath = "(//span[@class='amount'])[1]")
    private WebElement singleProductPriceOnMigros;
    @FindBy(css = "button.mat-caption.btn.accept-all")
    private WebElement acceptAllButton;
    @FindBy(css = "h3[class='text-color-black']")
    private WebElement nameOfTheProductOnMigros;

    public WebElement getNameOfTheProductOnMigros() {
        return nameOfTheProductOnMigros;
    }

    public WebElement getAcceptAllButton() {
        return acceptAllButton;
    }
    public WebElement getSingleProductPriceOnMigros() {
        return singleProductPriceOnMigros;
    }

    public List<WebElement> getBuySingleProduct() {
        return buySingleProduct;
    }

    public List<WebElement> getPriceOfProductsOnNescafe() {
        return priceOfProductsOnNescafe;
    }

    public List<WebElement> getNameOfProductsOnNescafe() {
        return nameOfProductsOnNescafe;
    }

    public WebElement getIframe() {
        return iframe;
    }
    public WebElement getMigrosSanalMarket() {
        return migrosSanalMarket;
    }

    public WebElement getSatinAlButton() {
        return satinAlButton;
    }

}
