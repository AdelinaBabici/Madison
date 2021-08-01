import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pages.HeaderPage;
import pages.SearchPage;

@RunWith(JUnit4.class)
public class SearchFieldTest extends BaseTest{

    HeaderPage headerPage;
    SearchPage searchPage;

    @Test
    public void search(){
        headerPage = new HeaderPage(driver);
        searchPage = new SearchPage(driver);

        headerPage.enterSomethingInSearchField("top");
        headerPage.enterFromKeyboard();
        searchPage.verifyIfProductsAreDisplayed();


    }




}
