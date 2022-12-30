package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private final By loginField = By.name("email");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//p[text() = 'login']");
    private final By loginButtonHomePage = By.xpath("//p[text() = 'Login']/..");
    private final By searchIcon = By.id("search");
    private final By searchField = By.xpath("//input[@placeholder='WHAT ARE YOU LOOKING FOR?']");
    private final By viewDetailsButton = By.xpath("//div[text() = 'view details']");
    private final By itemSize = By.xpath("//p[text() = 'Size']/../div/button");
    private final By itemSize2 = By.xpath("//p[text() = 'Size']/../div/button[4]");
    private final By itemColor = By.xpath("//p[text() = 'Color']/../div/button");
    private final By addToCardButton = By.xpath("//p[text() = 'add to cart']");
    private final By cardIcon = By.id("cart");
    private final By viewCard = By.xpath("//a[text() = 'view cart']");
    private final By checkoutButton = By.id("checkout");
    private final By addPaymentDetailsButton = By.id("addPaymentDetails");
    private final By placeOrderButton = By.id("placeOrder");
    private final By messageAfterOrderPlacement = By.xpath("//p[text() = 'order summary']/../..");
    private final By profileIcon = By.id("profile");
    private final By logOutButton = By.xpath("//p[text() = 'Log Out']");
    private final By catalog = By.id("shop");
    private final By artTab = By.id("art");

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
            //driver.findElement(loginButton).click();
        }
    }

    public void clickOnSearchIcon() {
        waitUntilPageIsLoaded();
        clickByJavaScript(driver.findElement(searchIcon));
    }

    public void itemSearch(String itemName) {
        driver.findElement(searchField).sendKeys(itemName + "\n");
    }

    public void openDetails() {
        waitUntilPageIsLoaded();
        clickByJavaScript(driver.findElement(viewDetailsButton));
    }

    public void selectSize() {driver.findElement(itemSize).click();}

    public void selectColor() {
        try {
            driver.findElement(itemColor).click();
        } catch (ElementClickInterceptedException e){
            clickByJavaScript(driver.findElement(itemSize2));
            driver.findElement(itemColor).click();
        }
    }

    public void addItemToCard() {
        try {
            driver.findElement(addToCardButton).click();
        } catch (ElementClickInterceptedException e){
            clickByJavaScript(driver.findElement(itemSize2));
            driver.findElement(itemColor).click();
            driver.findElement(addToCardButton).click();
        }
    }

    public void moveToCheckout() {
        driver.findElement(viewCard).click();
        driver.findElement(checkoutButton).click();
        waitUntilPageIsLoaded();
    }

    public void clickOnAddPaymentDetailsButton() {
        driver.findElement(addPaymentDetailsButton).click();
        waitUntilPageIsLoaded();
    }

    public void clickOnPlaceOrderButton() {
        clickByJavaScript(driver.findElement(placeOrderButton));
        waitUntilPageIsLoaded();
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
                until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//p[text() = 'Art']"))));
        driver.findElement(artTab).click();
    }

}
