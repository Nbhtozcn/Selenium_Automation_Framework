package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.EvimdekiPsikolog_POM;
import utilities.DriverClass;

public class EvimdekiPsikolog_Test {
    EvimdekiPsikolog_POM evimdekiPsikolog = new EvimdekiPsikolog_POM();

    @Given("I am on the Evimdeki Psikologlar website homepage")
    public void iAmOnTheEvimdekiPsikologlarWebsiteHomepageHttpsWwwEvimdekipsikologCom() {
        DriverClass.getDriver().get("https://www.evimdekipsikolog.com/");
    }

    @When("I click on the Topluluk button in the top tab")
    public void iClickOnTheToplulukButtonInTheTopTab() {
        evimdekiPsikolog.clickMethod(evimdekiPsikolog.getToplulukButton());
    }

    @And("I scroll down the webpage")
    public void iScrollDownTheWebpage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverClass.getDriver();
        jsExecutor.executeScript("window.scrollBy(0, 1200);");
    }

    @And("I click on the Katıl button under the {string} section")
    public void iClickOnTheKatılButtonUnderTheSection(String topluluk) {
        String originalWindow = DriverClass.getDriver().getWindowHandle();
        for (int i = 0; i < evimdekiPsikolog.getCommunityTypeBeforeKatil().size(); i++) {
            if (evimdekiPsikolog.getCommunityTypeBeforeKatil().get(i).getText().equals(topluluk)) {
                while (!isElementInView(evimdekiPsikolog.getKatilButtons().get(i))) {
                    scrollDown(300);
                }
                evimdekiPsikolog.clickMethod(evimdekiPsikolog.getKatilButtons().get(i));
            }
        }
        for (String windowHandle : DriverClass.getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                DriverClass.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    @Then("I should see that the opened page is related to the payment page of the {string} community")
    public void iShouldSeeThatTheOpenedPageIsRelatedToThePaymentPageOfTheCommunity(String topluluk) {
        Assert.assertTrue(evimdekiPsikolog.getCommunityTypeAfterKatil().getText().contains(topluluk));
        System.out.println(topluluk +" and related number of member "+ evimdekiPsikolog.getNumberOfMemberInCommunity().getText());
    }
    private boolean isElementInView(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverClass.getDriver();
        return (boolean) jsExecutor.executeScript(
                "var rect = arguments[0].getBoundingClientRect();" +
                        "return (rect.top >= 0 && rect.bottom <= window.innerHeight);", element);
    }
    private void scrollDown(int pixels) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverClass.getDriver();
        jsExecutor.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }
}

