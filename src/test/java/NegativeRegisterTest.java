import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderPage;
import pages.RegisterPage;

import java.lang.ref.WeakReference;

@RunWith(JUnit4.class)
public class NegativeRegisterTest extends BaseTest{
    HeaderPage headerPage;
    RegisterPage registerPage;

    @Test
    public void unableToRegister(){
        headerPage = new HeaderPage(driver);
        registerPage = new RegisterPage(driver);

        headerPage.clickOnAccountIcon();
        headerPage.clickOnRegisterLink();
        registerPage.clickRegisterBtn();
        registerPage.verifyMsg("This is a required field.");

    }
}
