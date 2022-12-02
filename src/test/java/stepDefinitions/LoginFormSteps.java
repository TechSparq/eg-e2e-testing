package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.LoginForm;

public class LoginFormSteps {

    private LoginForm loginform = new LoginForm();

    @Given("User switch to registration form")
    public void userSwitchToRegistrationForm() {
        loginform.switchToRegistrationForm();
    }

    @When("User fill the data for registration and confirm")
    public void userFillTheDataForRegistrationAndConfirm() {
        loginform.fillRegistrationForm();
    }

    @Then("User see PTS")
    public void userSeePTS() {
        Assertions.assertThat(loginform.displayingPTS()).isTrue();
    }
}
