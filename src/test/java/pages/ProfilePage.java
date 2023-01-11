package pages;

import org.openqa.selenium.By;

public class ProfilePage extends BasePage {

    private final By myAccount = By.xpath("//a[@href='/account/personal-information']");
    private final By savedAddressesTab = By.xpath("//p[text() = 'Saved Addresses']");
    private final By addNewButton = By.xpath("//p[text() = 'add new']/..");
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By addressLine = By.name("address1");
    private final By countryName = By.name("countryCode");
    private final By stateName = By.name("stateCode");
    private final By cityName = By.name("city");
    private final By zipCode = By.name("postalCode");
    private final By phoneNumber = By.name("phone");
    private final By saveButton = By.xpath("//p[text() = 'save']/..");
    private final By savedAddress = By.xpath("//p[text() = 'Address #']/..");
    private final By savedPaymentsTab = By.xpath("//p[text() = 'Saved Payments']");
    private final By cardNumber = By.name("cardnumber");
    private final By durationOfCard = By.name("exp-date");
    private final By cvcField = By.name("cvc");
    private final By paymentMethod = By.xpath("//p[text() = 'payment method #1']");
    private final By profileMenu = By.id("profile");


    public void openMyAccount() {
        driver.findElement(myAccount).click();
    }

    public void openSavedAddresses() {
        driver.findElement(savedAddressesTab).click();
    }

    public void clickOnAddNewButton() {
        driver.findElement(addNewButton).click();
    }

    public void  fillAddressData() {
        driver.findElement(firstName).sendKeys("Roman");
        driver.findElement(lastName).sendKeys("Romanenko");
        driver.findElement(addressLine).sendKeys("4869 Parkview Dr apt H");
        driver.findElement(countryName).sendKeys("United States");
        driver.findElement(stateName).sendKeys("Oregano");
        driver.findElement(cityName).sendKeys("Lake Oswego");
        driver.findElement(zipCode).sendKeys("97035");
        driver.findElement(phoneNumber).sendKeys("5415984181");
        driver.findElement(saveButton).click();
    }

    public boolean validateSavedAddressIsDisplay(){
        return driver.findElement(savedAddress).isDisplayed();
    }

    public void openSavedPayments() {
        driver.findElement(savedPaymentsTab).click();
    }

    public void fillPaymentData() {
        driver.findElement(cardNumber).sendKeys("4242424242424242");
        driver.findElement(durationOfCard).sendKeys("1223");
        driver.findElement(cvcField).sendKeys("123");
        driver.findElement(countryName).sendKeys("United States");
        driver.findElement(zipCode).sendKeys("97035");
        driver.findElement(saveButton).click();
    }

    public boolean validateSavedPaymentMethodIsDisplay() {
        return  driver.findElement(paymentMethod).isDisplayed();
    }

    public void openProfileMenu() {
        driver.findElement(profileMenu).click();
    }
}


