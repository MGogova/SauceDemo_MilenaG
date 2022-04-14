package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletedOrderPage {
    protected WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    WebElement checkoutHeader;

    public CompletedOrderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean getCheckoutHeader() {
        return checkoutHeader.isDisplayed();
    }
}
