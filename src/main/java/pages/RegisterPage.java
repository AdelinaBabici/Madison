package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "button[title*='Register'")
    private WebElement registerBtn;
    @FindBy(className = "validation-advice")
    private WebElement adviceMsg;

    public void unableToRegister(){
        registerBtn.click();
    }
    public void verifyMsg(String message){
        String validate = adviceMsg.getText();
        Assert.assertTrue("the user was able to register", validate.equals(message));
    }
}
