package qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.CsvHelper;

import java.io.IOException;

public class CheckoutTest extends TestUtil {
    @DataProvider(name = "loginUser")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/loginUser.csv");
    }

    @Test(dataProvider = "loginUser")
    public void successfulLoginTest(String userName, String password){

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);

        productsPage.addItemToTheCart("fleece-jacket");
        productsPage.enterIntoCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.fillCheckoutInfo("Milena", "Gogova", "1680");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.finishCheckout();

        CompletedOrderPage completedOrderPage = new CompletedOrderPage(driver);
        Assert.assertTrue(completedOrderPage.getCheckoutHeader());


    }
}
