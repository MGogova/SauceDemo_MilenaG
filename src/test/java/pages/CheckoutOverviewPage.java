package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    protected WebDriver driver;

    @FindBy(id = "finish")
    WebElement finishButton;

    public CheckoutOverviewPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void finishCheckout(){finishButton.click();
    }
}

