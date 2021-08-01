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

    }

    public void accessProductDetails(String productName){
        List<WebElement> products = driver.findElements(By.cssSelector("h2 a"));
        for(WebElement el: products){
            if(el.getText().contains(productName)){
               el.click();
                break;
            }
        }

    }
}
