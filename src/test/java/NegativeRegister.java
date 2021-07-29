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

import java.lang.ref.WeakReference;

@RunWith(JUnit4.class)
public class NegativeRegister {
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
    public void unableToRegister(){
        WebElement account = driver.findElement(By.cssSelector(".skip-link.skip-account"));
        account.click();
        WebElement register = driver.findElement(By.cssSelector("a[title*='Register'"));
        register.click();
        WebElement submitBtn = driver.findElement(By.cssSelector("button[title*='Register'"));
        submitBtn.click();

        String validate = driver.findElement(By.className("validation-advice")).getText();

        Assert.assertTrue("the user was able to register", validate.equals("This is a required field."));
    }
}
