package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.ModaMerve_POM;
import utilities.DriverClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModaMerve_Test {
    String nameOfTheProduct;
    String priceOfTheProduct;
    JavascriptExecutor jse = (JavascriptExecutor) DriverClass.getDriver();
    Actions actions = new Actions(DriverClass.getDriver());
    ModaMerve_POM modamerve = new ModaMerve_POM();

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {

        DriverClass.getDriver().get("https://www.macys.com");
        DriverClass.getDriver().findElements(By.cssSelector("button.show-for-sr+a")).get(0).click();

    }

    @When("I click on the YOUR PHOTOS menu")
    public void iClickOnTheYOURPHOTOSMenu() {
        modamerve.clickMethod(modamerve.getYourPhotosButton());

    }

    @Then("I write the content of each card on the YOUR PHOTOS page to an Excel file")
    public void iWriteTheContentOfEachCardOnTheYOURPHOTOSPageToAnExcelFile() {

    }

    @And("the Excel file includes the following information; Image Link,Product Link,User Information,Comment,Star Rating")
    public void theExcelFileIncludesTheFollowingInformationImageLinkProductLinkUserInformationCommentStarRating() {


        List<ProductInfo> productInfoList = new ArrayList<>();
        for (int i = 0; i < modamerve.getListOfYourPhotos().size() - 1; i++) {
            WebElement productLink = modamerve.getListOfProductLink().get(i);
            WebElement photoLink = modamerve.getListOfPhotoLinks().get(i);
            WebElement commentOfPhoto = modamerve.getListOfComments().get(i);
            WebElement dateOfComment = modamerve.getListOfDates().get(i);

            String productLinkValue = productLink.getAttribute("href");
            String photoLinkValue = photoLink.getAttribute("src");
            String commentOfPhotoText = commentOfPhoto.getText();
            String dateOfCommentText = dateOfComment.getText();

            ProductInfo productInfo = new ProductInfo(productLinkValue, photoLinkValue, commentOfPhotoText, dateOfCommentText);
            productInfoList.add(productInfo);
        }
        String path = "src/test/java/apachePOI/ModaMerve.xlsx";
        writeInExcel(path, productInfoList, LocalDateTime.now());
    }


    @When("I click on the Account function provided by the site on the homepage")
    public void iClickOnTheAccountFunctionProvidedByTheSiteOnTheHomepage() {
        modamerve.clickMethod(modamerve.getHomePageAccountButton());
    }

    @And("I click on the Sign Up button on the opened page")
    public void iClickOnTheSignUpButtonOnTheOpenedPage() {

        actions.moveToElement(modamerve.getSignUpButton()).click().build().perform();
    }

    @And("I enter a password different from the previously entered password in the password confirmation field")
    public void iEnterAPasswordDifferentFromThePreviouslyEnteredPasswordInThePasswordConfirmationField() {
        modamerve.sendKeysMethod(modamerve.getRegisterPasswordInput(), "123456");
        modamerve.sendKeysMethod(modamerve.getRegisterPasswordAgainInput(), "123457");
    }

    @Then("I should receive an error message confirming the password mismatch")
    public void iShouldReceiveAnErrorMessageConfirmingThePasswordMismatch() {
        Assert.assertTrue(modamerve.getPasswordNotConfirmedErrorMessage().isDisplayed());
    }

    @And("I enter a password with less than six characters in the password field")
    public void iEnterAPasswordWithLessThanSixCharactersInThePasswordField() {
        modamerve.sendKeysMethod(modamerve.getRegisterPasswordInput(), "12345");
    }

    @Then("I should receive an error message indicating that the password should be at least six characters long")
    public void iShouldReceiveAnErrorMessageIndicatingThatThePasswordShouldBeAtLeastSixCharactersLong() {
        Assert.assertTrue(modamerve.getPasswordLengthErrorMessage().isDisplayed());
    }

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        DriverClass.getDriver().get("https://www.modamerve.com/uye-kayit");
    }

    @When("I enter valid registration details")
    public void iEnterValidRegistrationDetails() {
        modamerve.sendKeysMethod(modamerve.getRegisterNameInput(), "john");
        modamerve.sendKeysMethod(modamerve.getRegisterSurnameInput(), "Doe");
        modamerve.sendKeysMethod(modamerve.getRegisterPasswordInput(), "123456");
        modamerve.sendKeysMethod(modamerve.getRegisterPasswordAgainInput(), "123456");
        modamerve.sendKeysMethod(modamerve.getRegisterPhoneNumberInput(), "1113334455");
        modamerve.sendKeysMethod(modamerve.getRegisterEmailInput(), modamerve.generateRandomEmail());

        jse.executeScript("arguments[0].click()", modamerve.getRegisterKVKKCheckbox());

        jse.executeScript("arguments[0].click()", modamerve.getRegisterMemberShipAgreementCheckbox());
    }

    @And("I click on the Save button")
    public void iClickOnTheSaveButton() {

        jse.executeScript("arguments[0].click();", modamerve.getRegisterSaveButton());


    }

    @And("I should see a confirmation message stating that my registration was successful")
    public void iShouldSeeAConfirmationMessageStatingThatMyRegistrationWasSuccessful() {
        Assert.assertTrue(modamerve.getRegisterSuccessMessage().getText().contains("you are a member now."));
    }

    @Given("I am on the product listing page")
    public void iAmOnTheProductListingPage() {
        DriverClass.getDriver().get("https://www.modamerve.com/tesettur");
    }

    @When("I select a product and size")
    public void iSelectAProductAndSize() {
        nameOfTheProduct = modamerve.getNameListOfTheProducts().get(0).getText();
        priceOfTheProduct = modamerve.getPriceOfTheProductInTheContent().getText();
        modamerve.clickMethod(modamerve.getListOfProducts().get(0));
        List<WebElement> filteredElements = modamerve.getListOfSizes().stream()
                .filter(element -> !element.getAttribute("class").contains("passive"))
                .collect(Collectors.toList());

        if (!filteredElements.isEmpty()) {
            WebElement firstElement = filteredElements.get(0);
            firstElement.click();
        }
        System.out.println(nameOfTheProduct);

    }

    @And("I click on the Add to Cart button")
    public void iClickOnTheAddToCartButton() {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverClass.getDriver();
        jsExecutor.executeScript("window.scrollTo(0, 0);");
        actions.moveToElement(modamerve.getAddToCartButton()).click().build().perform();
    }

    @Then("the product should be added to the cart")
    public void theProductShouldBeAddedToTheCart() {
        modamerve.setWait(5);
        Assert.assertEquals(nameOfTheProduct, modamerve.getSingleProductNameInTheCart().getText());
    }

    @And("the total cart value should be updated with the product price")
    public void theTotalCartValueShouldBeUpdatedWithTheProductPrice() {

        Assert.assertTrue(priceOfTheProduct.contains(modamerve.getSingleProductPriceInTheCart().getText()));
    }


    static class ProductInfo {
        private String productLink;
        private String photoLink;
        private String commentOfPhoto;
        private String dateOfComment;

        public ProductInfo(String productLink, String photoLink, String commentOfPhoto, String dateOfComment) {
            this.productLink = productLink;
            this.photoLink = photoLink;
            this.commentOfPhoto = commentOfPhoto;
            this.dateOfComment = dateOfComment;
        }

        public String getProductLink() {
            return productLink;
        }

        public String getPhotoLink() {
            return photoLink;
        }

        public String getCommentOfPhoto() {
            return commentOfPhoto;
        }

        public String getDateOfComment() {
            return dateOfComment;
        }
    }

    public static void writeInExcel(String path, List<ProductInfo> productInfoList, LocalDateTime currentTime) {
        try {
            XSSFWorkbook workbook;
            if (new File(path).exists()) {
                FileInputStream fileInputStream = new FileInputStream(path);
                workbook = new XSSFWorkbook(fileInputStream);
                fileInputStream.close();
            } else {
                workbook = new XSSFWorkbook();
            }
            String sheetName = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            XSSFSheet sheet = workbook.createSheet(sheetName);


            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Product Link");
            headerRow.createCell(1).setCellValue("Photo Link");
            headerRow.createCell(2).setCellValue("Comment of Photo");
            headerRow.createCell(3).setCellValue("Date of Comment");


            int rowNum = 1;
            for (ProductInfo productInfo : productInfoList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(productInfo.getProductLink());
                row.createCell(1).setCellValue(productInfo.getPhotoLink());
                row.createCell(2).setCellValue(productInfo.getCommentOfPhoto());
                row.createCell(3).setCellValue(productInfo.getDateOfComment());
            }


            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
