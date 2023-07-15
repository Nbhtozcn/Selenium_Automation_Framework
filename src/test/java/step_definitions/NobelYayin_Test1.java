package step_definitions;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Nobel_Yayin_POM;
import utilities.DriverClass;
import utilities.ExcelUtilities;

import java.io.FileInputStream;
import java.io.IOException;

public class NobelYayin_Test1 extends Nobel_Yayin_POM {
    Nobel_Yayin_POM nobelYayin = new Nobel_Yayin_POM();

    @BeforeTest
    public void setup() {
        DriverClass.getDriver().get("https://www.nobelyayin.com/");
        nobelYayin.clickMethod(nobelYayin.getLanguageAsEnglishButton());
    }

    @Test(dataProvider = "signUpData")
    public void signUpTest(String name, String lastName, String phoneNumber, String email, String password) {

        String formattedNumber = phoneNumber.replaceFirst("\\.", "").replaceAll("E\\d$", "");
        nobelYayin.clickMethod(nobelYayin.getHomepageLoginSignupButton());
        nobelYayin.clickMethod(nobelYayin.getSignUpButton());
        nobelYayin.sendKeysMethod(nobelYayin.getSignupNameInput(), name);
        nobelYayin.sendKeysMethod(nobelYayin.getSignupSurnameInput(), lastName);
        nobelYayin.sendKeysMethod(nobelYayin.getSignupPhoneNumber(), formattedNumber);
        nobelYayin.sendKeysMethod(nobelYayin.getSignupEmailAddress(), email);
        nobelYayin.sendKeysMethod(nobelYayin.getSignupPassword(), password);
        nobelYayin.clickMethod(nobelYayin.getSignupSubmitButton());
        Assert.assertTrue(nobelYayin.verifyIsDisplayedMethod(nobelYayin.getMyAccountButton()));
        nobelYayin.clickMethod(nobelYayin.getMyAccountButton());
        nobelYayin.clickMethod(nobelYayin.getLogoutButton());
        DriverClass.getDriver().navigate().back();
        DriverClass.setWait(3);
        DriverClass.getDriver().navigate().back();
        DriverClass.setWait(3);
        DriverClass.getDriver().navigate().back();
        DriverClass.setWait(10);
    }

    public Object[][] getDataFromExcel(String path, String sheetName) {
        Sheet sheet;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int rowCount = sheet.getPhysicalNumberOfRows() - 1;
        int columnCount = sheet.getRow(0).getLastCellNum() - 1;

        Object[][] data = new Object[rowCount][columnCount];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 1; j <= columnCount; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j - 1] = cell.toString();
                if (j == 4) {
                    ExcelUtilities.updateDataInExcel("src/test/java/apachePOI/Nobel_Yayin_TC1.xlsx", "Sheet1", i, j, nobelYayin.generateRandomEmail());
                }
            }
        }
        return data;
    }

    @DataProvider(name = "signUpData")
    public Object[][] getSignUpData() {
        String path = "src/test/java/apachePOI/Nobel_Yayin_TC1.xlsx";
        String sheetName = "Sheet1";

        return getDataFromExcel(path, sheetName);
    }

}
