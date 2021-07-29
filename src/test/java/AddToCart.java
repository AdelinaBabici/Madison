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

import java.sql.Driver;
import java.util.List;

@RunWith(JUnit4.class)

public class AddToCart {
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
    public void ableToaddToCart() {
        WebElement account = driver.findElement(By.cssSelector(".skip-link.skip-account"));
        account.click();
        WebElement login = driver.findElement(By.cssSelector("a[href*='login']"));
        login.click();
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("ab@yahoo.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.clear();
        password.sendKeys("aaaaaa");
        WebElement loginBtn = driver.findElement(By.id("send2"));
        loginBtn.click();
        WebElement vip = driver.findElement(By.cssSelector("a[href*='vip']"));
        vip.click();
        Select oselect = new Select(driver.findElement(By.cssSelector("select[title='Results per page']")));
        List<WebElement> numberPerPage = oselect.getOptions();
        oselect.selectByIndex(2);
        WebElement product = driver.findElement(By.id("product-collection-image-373"));
        product.click();
        WebElement addToCartBtn = driver.findElement(By.className("add-to-cart-buttons"));
        addToCartBtn.click();

        String mess = driver.findElement(By.className("success-msg")).getText();
        Assert.assertTrue("the message was not displayed",mess.contains(" was added to your shopping cart."));


    }

}
