import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

       //Create a new webdriver instance
       WebDriver driver = new ChromeDriver();

        //Launch a new browser session
        driver.get("http://qa2.dev.evozon.com/");

        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        WebElement logo = driver.findElement(By.className("logo"));
        logo.click();

        WebElement accessories = driver.findElement(By.cssSelector(".level0.nav-3.parent"));
        accessories.click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
//

        WebDriver driver1 = new ChromeDriver();
        driver1.get("http://qa2.dev.evozon.com/");

        WebElement account = driver1.findElement(By.cssSelector(".skip-link.skip-account"));
        account.click();
        driver1.quit();
//
    WebDriver driver2 = new ChromeDriver();
        driver2.get("http://qa2.dev.evozon.com/");
        Select select = new Select(driver2.findElement(By.id("select-language")));
        List<WebElement> languages = select.getOptions();
        System.out.println(languages.size());
        select.selectByIndex(1);
        driver2.quit();

        //

        WebDriver driver3 = new ChromeDriver();
        driver3.get("http://qa2.dev.evozon.com/");
        WebElement search = driver3.findElement(By.id("search"));
        search.clear();
        search.sendKeys("top");
        search.submit();
        driver3.quit();

        WebDriver driver4 = new ChromeDriver();
        driver4.get("http://qa2.dev.evozon.com/");

        List<WebElement> products = driver4.findElements(By.className("product-name"));
        int numOfChildren = products.size();
        System.out.println(numOfChildren);
        for(WebElement element : products) {
            System.out.println(element.getText());
        }
        driver4.quit();


        WebDriver driver5 = new ChromeDriver();
        driver5.get("http://qa2.dev.evozon.com/");
        List<WebElement> headline = driver5.findElements(By.id(("header-nav")));
        for(WebElement options : headline){
            System.out.println(options.getText());
        }
        WebElement sale = driver5.findElement(By.cssSelector(".level0.nav-5.parent"));
        sale.click();
        driver5.quit();

        WebDriver driver6 = new ChromeDriver();
       driver6.get("http://qa2.dev.evozon.com/");
       WebElement account = driver6.findElement(By.cssSelector(".skip-link.skip-account"));
       account.click();
       WebElement login = driver6.findElement(By.cssSelector("a[href*='login']"));
        login.click();
        WebElement email = driver6.findElement(By.id("email"));
        email.clear();
        email.sendKeys("ab@yahoo.com");
        WebElement password = driver6.findElement(By.id("pass"));
        password.clear();
        password.sendKeys("aaaaaa");
        WebElement loginBtn = driver6.findElement(By.id("send2"));
        loginBtn.click();
        WebElement vip = driver6.findElement(By.cssSelector("a[href*='vip']"));
        vip.click();
        Select oselect = new Select(driver6.findElement(By.cssSelector("select[title='Results per page']")));
        List<WebElement> numberPerPage = oselect.getOptions();
        oselect.selectByIndex(2);
        WebElement product = driver6.findElement(By.id("product-collection-image-373"));
        product.click();
        WebElement addToCartBtn = driver6.findElement(By.className("add-to-cart-buttons"));
        addToCartBtn.click();
        driver6.quit();


  WebDriver driver7 = new ChromeDriver();
        driver7.get("http://qa2.dev.evozon.com/");
        WebElement accessory = driver7.findElement(By.cssSelector(".level0.nav-3.parent"));
        accessory.click();
        WebElement eyewear = driver7.findElement(By.cssSelector("img[src*='eyewear'"));
        eyewear.click();
        WebElement addToWishlist = driver7.findElement(By.className("link-wishlist"));
        addToWishlist.click();
        WebElement email = driver7.findElement(By.id("email"));
        email.clear();
        email.sendKeys("ab@yahoo.com");
        WebElement password = driver7.findElement(By.id("pass"));
        password.clear();
        password.sendKeys("aaaaaa");
        WebElement loginBtn = driver7.findElement(By.id("send2"));
        loginBtn.click();




    }
}
