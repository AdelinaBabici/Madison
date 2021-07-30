package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
 private WebDriver driver;

 public HeaderPage(WebDriver driver){
     this.driver = driver;
     PageFactory.initElements(driver,this);
 }

 @FindBy(css = ".skip-link.skip-account")
    private WebElement accountIcon;
 @FindBy(css = "a[href*='login']")
 private WebElement loginLink;
 @FindBy(css = "a[href*='vip']")
 private WebElement vip;
 @FindBy(css = "a[title*='Register'")
 private WebElement registerLink;

 public void accessAcount(){
     accountIcon.click();
 }
public void accessLoginPage(){
     loginLink.click();
}
public void accessVipPage(){
     vip.click();
}
public void accessRegisterPage(){
     registerLink.click();
}

}
