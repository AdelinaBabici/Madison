package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoryPage {
    private WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnASubcategry(String name){
        List<WebElement> subcategories = driver.findElements(By.className("catblocks"));
        for(WebElement op:subcategories){
            if(op.getText().contains(name)){
                op.findElement(By.cssSelector("a[href*='http://qa2.dev.evozon.com/'")).click();
            }
        }
    }
}
