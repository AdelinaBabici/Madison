package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "success-msg")
    private WebElement validationMsg;

    public boolean receiveValidMsg(String message) {
        boolean validMsg = false;
        if (validationMsg.getText().contains(message)) {
            return validMsg = true;
        } else {
            return false;
        }

    }

    public void verifyMessage(String message) {
        Assert.assertTrue("the message was not displayed", receiveValidMsg(message));
    }

    public void verifyPresenceOfProduct(String productName) {
        List<WebElement> cartProducts = driver.findElements(By.className("product-cart-info"));
        boolean productFound = false;
        for (WebElement el : cartProducts) {
            if (el.findElement(By.cssSelector("h2 a")).getText().equals(productName)) {
                productFound = true;
                break;
            }
        }
        Assert.assertTrue("product is not displayed in cart", productFound);

    }
}
