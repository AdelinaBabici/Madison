package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.ref.WeakReference;
import java.util.List;

public class MyWishlistPage {
    private WebDriver driver;

    public MyWishlistPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(css = ".cart-cell button[title*='Add to Cart")
    private WebElement addToCartBtn;

    @FindBy(css = "a[href*='http://qa2.dev.evozon.com/wishlist/index/configure/'")
    private WebElement editBtn;
    @FindBy(css = ".cart-cell input[class*='input-text qty validate-not-negative-number'")
    private WebElement updatedQty;
    @FindBy(css = "textarea[title*='Comment'")
    private WebElement commentsSection;
    @FindBy(css = "button[title*='Update Wishlist'")
    private WebElement updateBtn;


    public void verifyPresenceOfProduct(String productName) {
        List<WebElement> wishlistProducts = driver.findElements(By.cssSelector("#wishlist-table tr[id]"));
        boolean productFound = false;
        for (WebElement el :  wishlistProducts) {
            if (el.findElement(By.cssSelector("h3 a")).getText().equals(productName)) {
                productFound = true;
                break;
            }
        }
        Assert.assertTrue("product not added to wishlist", productFound);

    }

    public void clickOnAddToCartBtn(){
        addToCartBtn.click();
    }
    public void clickOnEditBtn(){
        editBtn.click();
    }

    public void verifyIfProductIsUpdated(String qty){

         Assert.assertTrue("Quantity has not been updated",updatedQty.getAttribute("value").equals(qty));
    }

    public void enterAComment(String comment){
        commentsSection.clear();
        commentsSection.sendKeys(comment);
    }
    public void clickOnUpdateBtn(){
        updateBtn.click();
    }

    public void verifyIfCommentIsDisplayed(String comment){
        Assert.assertTrue("Comment isn`t displayed", commentsSection.getAttribute("value").equals(comment));
    }



}
