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
public class AddToWishlist {
    WebDriver driver;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa2.dev.evozon.com/");
    }
    @After
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void addToWishList(){

        WebElement accessory = driver.findElement(By.cssSelector(".level0.nav-3.parent"));
        accessory.click();
        WebElement eyewear = driver.findElement(By.cssSelector("img[src*='eyewear'"));
        eyewear.click();
        WebElement addToWishlist = driver.findElement(By.className("link-wishlist"));
        addToWishlist.click();
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("ab@yahoo.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.clear();
        password.sendKeys("aaaaaa");
        WebElement loginBtn = driver.findElement(By.id("send2"));
        loginBtn.click();

        List<WebElement> elementList= driver.findElements(By.cssSelector("#wishlist-table tr[id]"));
        boolean productFound=false;
        for(WebElement el: elementList){
        if(el.findElement(By.cssSelector("h3 a")).getText().equals("AVIATOR SUNGLASSES")){
        productFound=true;
        break;
}

        }

        Assert.assertTrue("product not added to wishlist", productFound);
    }
}
