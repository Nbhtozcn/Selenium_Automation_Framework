package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.UygunAkademi_POM;
import utilities.DriverClass;

public class UygunAkademi_Test {
    UygunAkademi_POM ua = new UygunAkademi_POM();
    ScenarioContext scenarioContext=new ScenarioContext();
    String activationCode;

    @Given("Kayit ol sayfasina git")
    public void kayitOlSayfasinaGit() {
        DriverClass.getDriver().get("https://egitim.uygunakademi.com/Register");
    }

    @And("Ad Soyadi gir")
    public void adSoyadiGir() {
        ua.sendKeysMethod(ua.getNameInput(), ua.generateRandomFullName());
        ua.sendKeysMethod(ua.getEmailInput(), ua.generateRandomEmail());
    }

    @And("Email adresini gir")
    public void emailAdresiniGir() {
        ua.sendKeysMethod(ua.getEmailInput(), ua.generateRandomEmail());
    }

    @And("Sifreyi gir")
    public void sifreyiGir() {
        String password = ua.generateRandomPassword();
        ua.sendKeysMethod(ua.getPasswordInput(), password);
        ua.sendKeysMethod(ua.getConfirmPasswordInput(), password);
    }

    @And("TC Vatandasi degilim butonuna tikla")
    public void tcVatandasiDegilimButonunaTikla() {
        ua.clickMethod(ua.getIsCitizenShipCheckBox());
    }

    @And("ILERI butonuna tikla")
    public void ileriButonunaTikla() {
        ua.clickMethod(ua.getNextButton());
    }

    @And("OGRENCI secenegine tikla")
    public void ogrenciSecenegineTikla() {
        ua.clickMethod(ua.getAccountTypes().get(0));
    }

    @And("Ogrenci telefon numarasini gir")
    public void OgrenciTelefonNumarasiniGir() {
        ua.sendKeysMethod(ua.getStudentPhoneNumberInput(),ua.generatePhoneNumber());
    }

    @And("Seviye ve Sube sec")
    public void seviyeVeSubeSec() {
        Select selectLevel=new Select(ua.getLevelsSelector());
        selectLevel.selectByIndex(1);

        Select selectClass=new Select(ua.getClassSelector());
        ua.setWait(2);
        selectClass.selectByIndex(1);
    }

    @And("Ogrenci TC kimlik numarasi gir")
    public void ogrenciTcKimlikNumarasiGir() {
        ua.sendKeysMethod(ua.getStudentIdentityNumber(),ua.generateNumericIdentity(14));
    }

    @When("KAYIT OL a tikla")
    public void kayitOLATikla() {
        ua.clickMethod(ua.getSignupButton());

    }
    @And("Aktivasyon kodunu kaydet")
    public void aktivasyonKodunuKaydet() {
        ua.setWait(3);
        activationCode = ua.getDescriptions().get(4).getText();

    }

    @Then("Kayıt işleminiz başarı ile tamamlanmıştır metnini gor")
    public void kayıtIşleminizBaşarıIleTamamlanmıştırMetniniGor() {
        System.out.println(activationCode);
        Assert.assertEquals(ua.getSuccessMessage().getText(),"Kayıt işleminiz başarı ile tamamlanmıştır.");
    }

    @And("Gecersiz bir ogrenci telefon numarasi gir")
    public void gecersizBirTelefonNumarasiGir() {
        ua.sendKeysMethod(ua.getStudentPhoneNumberInput(),ua.generateNumericIdentity(6));
    }

    @Then("Lutfen telefon numaranizi giriniz hata mesajini gor")
    public void lutfenTelefonNumaraniziGirinizHataMesajiniGor() {
        Assert.assertEquals(ua.getPhoneNumberErrorMessage().getText(),"Lutfen telefon numaranizi giriniz");
    }

    @And("VELI secenegine tikla")
    public void veliSecenegineTikla() {
        ua.clickMethod(ua.getAccountTypes().get(1));
    }
    @And("Veli Telefon numarasini gir")
    public void veliTelefonNumarasiniGir() {
        ua.sendKeysMethod(ua.getParentPhoneNumber(),ua.generatePhoneNumber());
    }

    @And("Veli TC kimlik numarasi gir")
    public void veliTCKimlikNumarasiGir() {
        ua.sendKeysMethod(ua.getParentIdentityNumber(),ua.generateNumericIdentity(14));
    }


    @And("Aktivasyon kodunu gir ve SORGULA ya tikla")
    public void aktivasyonKodunuGirVeSORGULAYaTikla() {
        ua.sendKeysMethod(ua.getActivationKeyInput(), activationCode);

    }


    @And("Gecersiz bir veli Telefon numarasini gir")
    public void gecersizBirVeliTelefonNumarasiniGir() {
        ua.sendKeysMethod(ua.getParentPhoneNumber(),ua.generateNumericIdentity(6));
    }

    @Then("Veli icin Lutfen telefon numaranizi giriniz hata mesajini gor")
    public void veliIcinLutfenTelefonNumaraniziGirinizHataMesajiniGor() {
Assert.assertEquals(ua.getParentPhoneNumberErrorMessage().getText(),"Lutfen telefon numaranizi giriniz");
    }
}
