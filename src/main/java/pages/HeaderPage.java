package pages;

import com.sun.webkit.graphics.WCRectangle;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class HeaderPage {
    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".skip-link.skip-account")
    private WebElement accountIcon;
    @FindBy(css = "a[href*='login']")
    private WebElement loginLink;

    @FindBy(css = "a[title*='Register'")
    private WebElement registerLink;
    @FindBy(id = "search")
    private WebElement searchField;


    public void clickOnAccountIcon() {
        accountIcon.click();
    }

    public void clickOnLoginLink() {
        loginLink.click();
    }

    public void accessHeaderPage(String headerName) {
        List<WebElement> headline = driver.findElements(By.id(("header-nav")));
        for (WebElement options : headline) {
            if (options.getText().contains(headerName)) {
                options.click();
                break;
            }
        }

    }


    public void clickOnRegisterLink() {
        registerLink.click();
    }

 public void clickOnACategory(String name){ //????????????????remembers the name from the other method
     List<WebElement> headline = driver.findElements(By.id(("header-nav")));
     for (WebElement options : headline) {
         if(options.getText().contains(name)){
             options.click();
             break;
         }
     }
 }

 public void enterSomethingInSearchField(String something){
        searchField.clear();
        searchField.sendKeys(something);

 }
public void enterFromKeyboard(){
    searchField.sendKeys(Keys.ENTER);
}

}