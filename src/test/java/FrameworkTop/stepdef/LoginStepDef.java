package FrameworkTop.stepdef;

import FrameworkTop.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import FrameworkTop.pages.LoginPage;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    @And("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        loginPage.enterPassword(password);

    }

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) throws InterruptedException {
        loginPage.enterUserName(username);
    }

    @And("I login")
    public void iLogin() {
        loginPage.pressLoginBtn();
    }

    @Then("login should fail with an error {string}")
    public void loginShouldFailWithAnError(String err) {
        Assert.assertTrue(loginPage.getErrTxt().equalsIgnoreCase(err));

    }
    @Given("I'm logged in")
    public void iMLoggedIn() throws InterruptedException {
        basePage.closeApp();
        basePage.launchApp();
        loginPage.login("standard_user", "secret_sauce");
    }
}
