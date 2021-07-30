package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "pass")
    private WebElement passwordInput;
    @FindBy(id = "send2")
    private WebElement submitBtn;

    public void enterEmail(String useremail){
        emailInput.clear();
        emailInput.sendKeys(useremail);
    }
    public void enterPass(String userpassword){
        passwordInput.clear();
        passwordInput.sendKeys(userpassword);
    }
    public void login(String userEmail, String userPassword){
        enterEmail(userEmail);
        enterPass(userPassword);
        submitBtn.click();
    }
}
