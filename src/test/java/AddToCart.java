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
        WebElement product = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > h2 > a"));
        product.click();
        WebElement addToCartBtn = driver.findElement(By.cssSelector("#product_addtocart_form > div.add-to-cart-wrapper > div > div > div.add-to-cart-buttons > button"));
        addToCartBtn.click();

        String mess = driver.findElement(By.className("success-msg")).getText();
        Assert.assertTrue("the message was not displayed",mess.contains(" was added to your shopping cart."));


    }
    public void addToWishlist(){
        WebElement accessory = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent"));
        accessory.click();
        WebElement eyewear = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(1) > a > img"));
        eyewear.click();
        WebElement addToWishlist = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > ul > li:nth-child(1) > a"));
        addToWishlist.click();
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.clear();
        email.sendKeys("ab@yahoo.com");
        WebElement password = driver.findElement(By.cssSelector("#pass"));
        password.clear();
        password.sendKeys("aaaaaa");
        WebElement loginBtn = driver.findElement(By.cssSelector("#send2 > span > span"));
        loginBtn.click();
    }
}
