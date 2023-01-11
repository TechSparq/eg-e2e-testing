package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.HomePage;


public class StartPageSteps {
    private HomePage homePage = new HomePage();

    @Given("Open app")
    public void openApp() {
        homePage.start();
    }

    @Given("User login with credentials {string} {string}")
    public void userLoginWithCredentials(String email, String password) {
        homePage.login(email, password);
    }

    @When("User click on search icon")
    public void userClickOnSearchIcon() {
        homePage.clickOnSearchIcon();
    }

    @And("User search {string}")
    public void userSearch(String itemName) {
        homePage.itemSearch(itemName);
    }

    @And("User open details of item")
    public void userOpenDetailsOfItem() throws InterruptedException {
        homePage.openDetails();
    }

    @And("User add item to card")
    public void userAddItemToCard() {
        homePage.addItemToCard();
    }

    @And("User move to checkout")
    public void userMoveToCard() {
        homePage.moveToCheckout();
    }

    @And("User click add payment detail button")
    public void userClickAddPaymentDetailButton() {
        homePage.clickOnAddPaymentDetailsButton();
    }

    @And("User click on place order button")
    public void userClickOnPlaceOrderButton() {
        homePage.clickOnPlaceOrderButton();
    }

    @Then("User see order description")
    public void userSeeMessage() {
        Assertions.assertThat(homePage.getActualMessageAfterOrderPlacement()).isTrue();
    }

    @And("User log out")
    public void userLogOut() {
        homePage.logOut();
    }

    @When("User open catalog")
    public void userOpenCatalog() {
        homePage.openCatalog();
    }

    @And("User switch to Art tab")
    public void userSwitchToArtTab() {
        homePage.switchToArtTab();
    }

    @And("User continue checkout as a guest")
    public void userContinueCheckoutAsAGuest() {
        homePage.continueAsGuest();
    }

    @And("User fill shipping address and email")
    public void userFillShippingAddressAndEmail() {
        homePage.fillShippingAddress();
    }

    @And("User fill payment details")
    public void userFillPaymentDetails() throws InterruptedException {
        homePage.fillPaymentDetails();
    }
}
