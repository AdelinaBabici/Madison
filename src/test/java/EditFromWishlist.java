import com.sun.media.sound.WaveFileReader;
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

@RunWith(JUnit4.class)
public class EditFromWishlist {
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
        WebElement vip = driver.findElement(By.cssSelector("a[href*='vip']"));
        vip.click();
        WebElement product = driver.findElement(By.id("product-collection-image-373"));
        product.click();
        WebElement wishlistLink = driver.findElement(By.className("link-wishlist"));
        wishlistLink.click();

    }
    @After
    public void afterTest(){
      //  driver.quit();
    }

    @Test
    public void editProduct(){

        WebElement edit = driver.findElement(By.cssSelector("#item_272 > td.wishlist-cell4.customer-wishlist-item-cart > p > a"));
        edit.click();
        WebElement qty = driver.findElement(By.cssSelector("#qty"));
        qty.clear();
        qty.sendKeys("3");
        WebElement update = driver.findElement(By.cssSelector("a[href*='updateItemOptions'"));
        update.click();

        //??dosen`t work
        String qty2 = driver.findElement(By.className("add-to-cart-alt")).getText();
        Assert.assertTrue("product isn`t updated",qty2.matches("3"));

    }
}
