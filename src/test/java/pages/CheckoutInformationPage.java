package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {
    protected WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;

    @FindBy(id="continue")
    WebElement buttonContinue;

    public CheckoutInformationPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillCheckoutInfo(String firstName, String lastName, String postalCode) {
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
        postalCodeInput.click();
        postalCodeInput.sendKeys(postalCode);
        buttonContinue.click();
    }
}