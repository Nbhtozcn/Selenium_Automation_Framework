package step_definitions;

import io.cucumber.java.en.Given;
import pages.EnUygun_POM;
import utilities.DriverClass;

public class Enuygun_Login {
    EnUygun_POM eu=new EnUygun_POM();
    @Given("En uygun login")
    public void enUygunLogin() {
        DriverClass.getDriver().get("https://www.enuygun.com/");
        eu.clickMethod(eu.getLoginButton());
        eu.sendKeysMethod(eu.getEmailInput(),"qahuntproject@gmail.com");
        eu.sendKeysMethod(eu.getPasswordInput(),"qahunt123!");
        eu.clickMethod(eu.getSubmitButton());

    }
}
