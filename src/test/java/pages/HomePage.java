package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    private final By loginField = By.name("email");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//p[text() = 'login']");
    private final By loginButtonHomePage = By.xpath("//p[text() = 'Login']/..");
    private final By searchIcon = By.xpath("//div[text() = 'search']");
    private final By searchField = By.xpath("//input[@placeholder='WHAT ARE YOU LOOKING FOR?']");
    private final By viewDetailsButton = By.xpath("//div[text() = 'view details']");
    private final By addToCardButton = By.xpath("//p[text() = 'add to cart']");
    private final By cardIcon = By.id("cart");
    private final By viewCard = By.id("viewCart");
    private final By checkoutButton = By.id("checkout");
    private final By addPaymentDetailsButton = By.id("addPaymentDetails");
    private final By placeOrderButton = By.id("placeOrder");
    private final By messageAfterOrderPlacement = By.xpath("//p[text() = 'order summary']/../..");
    private final By profileIcon = By.id("profile");
    private final By logOutButton = By.xpath("//p[text() = 'Log Out']");
    private final By catalog = By.id("shop");
    private final By artTab = By.id("art");
    private final By checkoutAsGuest = By.xpath("//p[text() = 'checkout as a guest']/..");
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By addressLine = By.id("address1");
    private final By countryName = By.id("countryCode");
    private final By stateDropDown = By.xpath("//input[@id = 'stateCode']/..//button[@title='Open']");
    private final By cityName = By.name("city");
    private final By zipCode = By.name("postalCode");
    private final By phoneNumber = By.name("phone");
    private final By cardNumber = By.name("cardnumber");
    private final By durationOfCard = By.name("exp-date");
    private final By cvcField = By.name("cvc");
    private final By countryNamePD = By.xpath("//input[@id = 'country']");
    private final By zipCodePD = By.name("zipCode");

    public void login(String email, String password){
        try {
            driver.findElement(loginField).sendKeys(email);
        } catch (NoSuchElementException e) {
            driver.findElement(loginButtonHomePage).click();
            driver.findElement(loginField).sendKeys(email);
            driver.findElement(passwordField).sendKeys(password);
            waitUntilPageIsLoaded();
            clickByJavaScript(driver.findElement(loginButton));
            waitUntilPageIsLoaded();
        }
    }

    public void clickOnSearchIcon() {
        driver.findElement(searchIcon).click();
    }

    public void itemSearch(String itemName) {
        driver.findElement(searchField).sendKeys(itemName + "\n");
        waitUntilPageIsLoaded();
    }

    public void openDetails() throws InterruptedException {
        Thread.sleep(2000);
        clickByJavaScript(driver.findElement(viewDetailsButton));
    }

    public void addItemToCard() {
        new WebDriverWait(driver,Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(driver.findElement(addToCardButton)));
        clickByJavaScript(driver.findElement(addToCardButton));
    }

    public void moveToCheckout() {
        driver.findElement(viewCard).click();
        driver.findElement(checkoutButton).click();
    }

    public void clickOnAddPaymentDetailsButton() {
        driver.findElement(addPaymentDetailsButton).click();
    }

    public void clickOnPlaceOrderButton() {
        clickByJavaScript(driver.findElement(placeOrderButton));
    }

    public boolean getActualMessageAfterOrderPlacement() {
        waitUntilPageIsLoaded();
        return driver.findElement(messageAfterOrderPlacement).isDisplayed();
    }

    public void logOut() {
        driver.findElement(profileIcon).click();
        driver.findElement(logOutButton).click();
    }

    public void openCatalog() {
        waitUntilPageIsLoaded();
        driver.findElement(catalog).click();
    }

    public void switchToArtTab() {
        waitUntilPageIsLoaded();
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfAllElements(driver.findElements(artTab)));
        driver.findElement(artTab).click();
    }

    public void continueAsGuest() {
        driver.findElement(checkoutAsGuest).click();
    }

    public void fillShippingAddress() {
        driver.findElement(firstName).sendKeys("Roman");
        driver.findElement(lastName).sendKeys("Romanenko");
        driver.findElement(addressLine).click();
        driver.findElement(addressLine).sendKeys("4869 Parkview Dr apt H");
        driver.findElement(countryName).click();
        driver.findElement(countryName).sendKeys("US");
        driver.findElement(stateDropDown).click();
        clickByJavaScript(driver.findElement(By.xpath("//li[text() = 'Oregon']")));
        driver.findElement(cityName).sendKeys("Lake Oswego");
        driver.findElement(zipCode).sendKeys("97035");
        driver.findElement(phoneNumber).sendKeys("5415984181");
        driver.findElement(loginField).sendKeys("roman.romanenko@grinteq.com");
        driver.findElement(addPaymentDetailsButton).click();
    }

    public void fillPaymentDetails() {
        List<WebElement> listOfFrames = driver.findElements(By.xpath("//iframe[contains(@name,'__privateStripeFrame')]"));
        driver.switchTo().frame(listOfFrames.get(0).getAttribute("name"));
        driver.findElement(cardNumber).click();
        driver.findElement(cardNumber).sendKeys("4242424242424242");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(listOfFrames.get(1).getAttribute("name"));
        driver.findElement(durationOfCard).click();
        driver.findElement(durationOfCard).sendKeys("1223");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(listOfFrames.get(2).getAttribute("name"));
        driver.findElement(cvcField).click();
        driver.findElement(cvcField).sendKeys("123");
        driver.switchTo().defaultContent();
        driver.findElement(countryNamePD).click();
        driver.findElement(countryNamePD).sendKeys("US");
        driver.findElement(zipCodePD).click();
        driver.findElement(zipCodePD).sendKeys("97035");
        driver.findElement(placeOrderButton).click();
    }
}
