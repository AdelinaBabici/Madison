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

import java.util.List;

@RunWith(JUnit4.class)
public class WishlistToCart {
     WebDriver driver;
    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa2.dev.evozon.com/");
        WebElement account = driver.findElement(By.cssSelector(".skip-link.skip-account"));
        account.click();
        WebElement login = driver.findElement(By.cssSelector("a[href*='login'"));
        login.click();
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.clear();
        email.sendKeys("ab@yahoo.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.clear();
        password.sendKeys("aaaaaa");
        WebElement loginBtn = driver.findElement(By.id("send2"));
        loginBtn.click();

    }
   @After
    public void afterTest(){
       // driver.quit();
    }

    @Test
    public void addFromWishlistToCart(){

        WebElement vip = driver.findElement(By.cssSelector("a[href*='vip']"));
        vip.click();
        WebElement product = driver.findElement(By.id("product-collection-image-373"));
        product.click();
        WebElement wishlistLink = driver.findElement(By.className("link-wishlist"));
        wishlistLink.click();

        WebElement addToCartBtn = driver.findElement(By.cssSelector(".cart-cell button[title*='Add to Cart"));
        addToCartBtn.click();

        List<WebElement> elements = driver.findElements(By.id("shopping-cart-table"));
        boolean productFound = false;
        for(WebElement el: elements){
            if(el.findElement(By.cssSelector("h2 a")).getText().equals("BROAD ST. FLAPOVER BRIEFCASE")){
                productFound = true;
                break;
            }
            Assert.assertTrue("product is not displayed in cart",productFound);
        }

    }



}
