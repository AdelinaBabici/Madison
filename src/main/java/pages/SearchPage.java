package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.ref.WeakReference;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css =" h2[class*='product-name'")
    private WebElement productsDisplayed;


    public void verifyIfProductsAreDisplayed(){
        Assert.assertTrue("products aren`t displayed", productsDisplayed.isDisplayed());
    }
}
