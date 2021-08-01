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
public class AddToWishlistTest extends BaseTest{
    HeaderPage headerPage;
    CategoryPage categoryPage;
    ProductsPage productsPage;
    LoginPage loginPage;
    MyWishlistPage myWishlistPage;

    @Test
    public void addProductToWishList(){
        headerPage = new HeaderPage(driver);
        categoryPage = new CategoryPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        myWishlistPage = new MyWishlistPage(driver);

        WebElement accessory = driver.findElement(By.cssSelector(".level0.nav-3.parent"));
        accessory.click();
      //  headerPage.clickOnACategory("ACCESSORIES");

        categoryPage.clickOnASubcategry("EYEWEAR");
        productsPage.clickOnAddToWishlistLink();
        loginPage.login(Constants.EMAIL,Constants.PASSWORD);
        myWishlistPage.verifyPresenceOfProduct("AVIATOR SUNGLASSES");


    }
}
