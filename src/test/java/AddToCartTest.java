import helper.Constants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.*;

import java.sql.Driver;
import java.util.List;

@RunWith(JUnit4.class)

public class AddToCartTest extends BaseTest {

    HeaderPage headerPage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;


    @Test
    public void ableToaddToCart() {
        headerPage = new HeaderPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);

        headerPage.accessAcount();
        headerPage.accessLoginPage();
        loginPage.login(Constants.EMAIL,Constants.PASSWORD);
        headerPage.accessHeaderPage("VIP");
        productsPage.accessProductDetails("GEOMETRIC CANDLE HOLDERS");
        productDetailsPage.addToCart();
        cartPage.verifyMessage(" was added to your shopping cart.");
        cartPage.verifyPresenceOfProduct("GEOMETRIC CANDLE HOLDERS");


    }

}
