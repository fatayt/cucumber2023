package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Day16_C6_LoginStepDefinations {
    LoginPage loginPage = new LoginPage();
    @Given("kullanici application sayfasindadir")
    public void kullanici_application_sayfasindadir() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
    }
    @Given("kullanici manager {string} girer")
    public void kullanici_manager_girer(String string) {
        loginPage.username.sendKeys(string);
    }
    @Then("kullanici login buttonuna click eder")
    public void kullanici_login_buttonuna_click_eder() {

    }
    @Then("kullanici {string} oldugunu very eder")
    public void kullanici_oldugunu_very_eder(String string) {

    }
}
