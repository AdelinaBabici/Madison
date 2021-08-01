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
import pages.*;

import java.util.List;

@RunWith(JUnit4.class)
public class WishlistToCartTest extends BaseTest{
    HeaderPage headerPage;
    CategoryPage categoryPage;
    ProductsPage productsPage;
    LoginPage loginPage;
    MyWishlistPage myWishlistPage;
    CartPage cartPage;

    @Test
    public void addFromWishlistToCart(){
        headerPage = new HeaderPage(driver);
        categoryPage = new CategoryPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        myWishlistPage = new MyWishlistPage(driver);
        cartPage = new CartPage(driver);

        headerPage.clickOnAccountIcon();
        headerPage.clickOnLoginLink();
        loginPage.login(Constants.EMAIL,Constants.PASSWORD);
        headerPage.accessHeaderPage("VIP");
        productsPage.accessProductDetails("GEOMETRIC CANDLE HOLDERS");
        productsPage.clickOnAddToWishlistLink();
        myWishlistPage.clickOnAddToCartBtn();
        cartPage.verifyPresenceOfProduct("GEOMETRIC CANDLE HOLDERS");
        cartPage.verifyMessage(" was added to your shopping cart.");


    }

}
