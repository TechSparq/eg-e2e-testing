package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.LoginForm;
import pages.ProfilePage;

public class LoginFormSteps {

    private LoginForm loginform = new LoginForm();
    private ProfilePage profilePage = new ProfilePage();

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

    @And("User move to My Account")
    public void userMoveToMyAccount() {
        profilePage.openMyAccount();
    }

    @And("User open Save Addresses tab")
    public void userOpenSaveAddressesTab() {
        profilePage.openSavedAddresses();
    }

    @And("User click on add new button")
    public void userClickOnAddNewButton() {
        profilePage.clickOnAddNewButton();
    }

    @And("User fill address data and save")
    public void userFillAddressDataAndSave() {
        profilePage.fillAddressData();
    }

    @Then("User validate that added address is display")
    public void userValidateThatAddedAddressIsDisplay() {
        Assertions.assertThat(profilePage.validateSavedAddressIsDisplay()).isTrue();
    }

    @And("User move to Saved Payments")
    public void userMoveToSavedPayments() {
        profilePage.openSavedPayments();
    }

    @And("User fill payment data and save")
    public void userFillPaymentDataAndSave() {
        profilePage.fillPaymentData();
    }

    @Then("User validate that added payment method is display")
    public void userValidateThatAddedPaymentMethodIsDisplay() {
        Assertions.assertThat(profilePage.validateSavedPaymentMethodIsDisplay()).isTrue();
    }

    @And("User open profile menu")
    public void userOpenProfileMenu() {
        profilePage.openProfileMenu();
    }
}
