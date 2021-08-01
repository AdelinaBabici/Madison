import com.sun.media.sound.WaveFileReader;
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

@RunWith(JUnit4.class)
public class EditFromWishlistTest extends BaseTest {
    HeaderPage headerPage;
    CategoryPage categoryPage;
    ProductsPage productsPage;
    LoginPage loginPage;
    MyWishlistPage myWishlistPage;
    CartPage cartPage;

    @Test
    public void editProduct() {

        headerPage = new HeaderPage(driver);
        categoryPage = new CategoryPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        myWishlistPage = new MyWishlistPage(driver);
        cartPage = new CartPage(driver);

        headerPage.clickOnAccountIcon();
        headerPage.clickOnLoginLink();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        headerPage.accessHeaderPage("VIP");
        productsPage.accessProductDetails("GEOMETRIC CANDLE HOLDERS");
        productsPage.clickOnAddToWishlistLink();
        myWishlistPage.clickOnEditBtn();
        productsPage.changeQuantity("5");
        productsPage.clickOnUpdateWishlistLink();
        myWishlistPage.verifyIfProductIsUpdated("5");

    }

    @Test
    public void updateProduct() {
        headerPage = new HeaderPage(driver);
        categoryPage = new CategoryPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        myWishlistPage = new MyWishlistPage(driver);
        cartPage = new CartPage(driver);

        headerPage.clickOnAccountIcon();
        headerPage.clickOnLoginLink();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        headerPage.accessHeaderPage("VIP");
        productsPage.accessProductDetails("GEOMETRIC CANDLE HOLDERS");
        productsPage.clickOnAddToWishlistLink();
        myWishlistPage.enterAComment("more candles");
        myWishlistPage.clickOnUpdateBtn();
        myWishlistPage.verifyIfCommentIsDisplayed("more candles");


    }

}