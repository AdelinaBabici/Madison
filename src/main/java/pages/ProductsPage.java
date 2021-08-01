package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
@FindBy(className = "link-wishlist")
private WebElement linkWishlist;

    @FindBy(css = ".qty-wrapper input[id*='qty'")
    private WebElement qtyInput;

    @FindBy(css = "a[href*='updateItemOptions'")
    private WebElement updateLink;

    public void accessProductDetails(String productName){
        List<WebElement> products = driver.findElements(By.cssSelector("h2 a"));
        for(WebElement el: products){
            if(el.getText().contains(productName)){
               el.click();
                break;
            }
        }

    }
    public void clickOnAddToWishlistLink(){
        linkWishlist.click();
    }
    public void changeQuantity(String qty){
        qtyInput.clear();
        qtyInput.sendKeys(qty);
    }

    public void clickOnUpdateWishlistLink(){
        updateLink.click();
    }
}
