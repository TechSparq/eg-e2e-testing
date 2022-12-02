package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private final By loginField = By.xpath("//input[@name = 'email']");
    private final By passwordField = By.xpath("//input[@name = 'password']");
    private final By loginButton = By.xpath("//p[contains(text(), 'login')]/../button");
    private final By searchIcon = By.xpath("//div[text() = 'search']");
    private final By searchField = By.xpath("//input[@placeholder='WHAT ARE YOU LOOKING FOR?']");
    private final By viewDetailsButton = By.xpath("//div[text() = 'view details']");
    private final By itemSize = By.xpath("//p[text() = 'Size']/../div/button");
    private final By itemSize2 = By.xpath("//p[text() = 'Size']/../div/button[4]");
    private final By itemColor = By.xpath("//p[text() = 'Color']/../div/button");
    private final By addToCardButton = By.xpath("//p[text() = 'add to cart']");
    private final By cardIcon = By.xpath("//p[text() = '1']");
    private final By checkoutButton = By.xpath("//p[text() = 'checkout']/..");
    private final By addPaymentDetailsButton = By.xpath("//p[text() = 'add payment details']/..");
    private final By placeOrderButton = By.xpath("//p[text() = 'place order']/..");
    private final By messageAfterOrderPlacement = By.xpath("//p[text() = 'order summary']/../..");
    private final By profileIcon = By.xpath("//p[text() = ' PTS']/..");
    private final By logOutButton = By.xpath("//p[text() = 'Log Out']");
    private final By catalog = By.xpath("//div[text() = 'shop']");
    private final By artTab = By.xpath("//div[text() = 'Art']");

    public void login(String email, String password){
        driver.findElement(loginField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
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
        driver.findElement(cardIcon).click();
        driver.findElement(checkoutButton).click();
    }

    public void clickOnAddPaymentDetailsButton() {
        waitUntilPageIsLoaded();
        driver.findElement(addPaymentDetailsButton).click();
    }

    public void clickOnPlaceOrderButton() {
        waitUntilPageIsLoaded();
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
        clickByJavaScript(driver.findElement(catalog));
    }

    public void switchToArtTab() {
        waitUntilPageIsLoaded();
        clickByJavaScript(driver.findElement(artTab));
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//p[text() = 'Art']"))));
    }

}
