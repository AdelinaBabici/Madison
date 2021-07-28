import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

/*        //Create a new webdriver instance
        WebDriver driver = new ChromeDriver();

        //Launch a new browser session
        driver.get("http://qa2.dev.evozon.com/");

        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        WebElement logo = driver.findElement(By.cssSelector("#header > div > a > img.large"));
        logo.click();

        WebElement accessories = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > a"));
        accessories.click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
//

        WebDriver driver1 = new ChromeDriver();
        driver1.get("http://qa2.dev.evozon.com/");

        WebElement account = driver1.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        account.click();
        driver1.quit();
//
        WebDriver driver2 = new ChromeDriver();
        driver2.get("http://qa2.dev.evozon.com/");
        Select select = new Select(driver2.findElement(By.cssSelector("#select-language")));
        List<WebElement> languages = select.getOptions();
        System.out.println(languages.size());
        select.selectByIndex(1);
        driver2.quit();

        //

        WebDriver driver3 = new ChromeDriver();
        driver3.get("http://qa2.dev.evozon.com/");
        WebElement search = driver3.findElement(By.cssSelector("#search"));
        search.clear();
        search.sendKeys("top");
        search.submit();
        driver3.quit();

        WebDriver driver4 = new ChromeDriver();
        driver4.get("http://qa2.dev.evozon.com/");

        List<WebElement> products = driver4.findElements(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > li > div > h3"));
        int numOfChildren = products.size();
        System.out.println(numOfChildren);
        for(WebElement element : products) {
            System.out.println(element.getText());
        }
        driver4.quit();


        WebDriver driver5 = new ChromeDriver();
        driver5.get("http://qa2.dev.evozon.com/");
        List<WebElement> headline = driver5.findElements(By.cssSelector(("#nav > ol")));
        for(WebElement options : headline){
            System.out.println(options.getText());
        }
        WebElement sale = driver5.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent"));
        sale.click();
        driver5.quit();
*/
        WebDriver driver6 = new ChromeDriver();
        driver6.get("http://qa2.dev.evozon.com/");
       WebElement account = driver6.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
       account.click();
       WebElement login = driver6.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        login.click();
        WebElement email = driver6.findElement(By.cssSelector("#email"));
        email.clear();
        email.sendKeys("ab@yahoo.com");
        WebElement password = driver6.findElement(By.cssSelector("#pass"));
        password.clear();
        password.sendKeys("aaaaaa");
        WebElement loginBtn = driver6.findElement(By.cssSelector("#send2 > span > span"));
        loginBtn.click();
        WebElement vip = driver6.findElement(By.cssSelector("#nav > ol > li.level0.nav-6.last > a"));
        vip.click();
        Select oselect = new Select(driver6.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.pager > div > div > select")));
        List<WebElement> numberPerPage = oselect.getOptions();
        oselect.selectByIndex(2);
        WebElement addToCartBtn = driver6.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > button > span > span"));
        addToCartBtn.click();
        driver6.quit();


    }
}
