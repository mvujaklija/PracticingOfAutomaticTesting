package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.Strings;

/**
 * TEST SEARCH BAR on LC WAIKIKI page
 * Steps
 * 1. Navigate to a first page
 * 2. On start page hover mouse over profile icon in tob right corner (it is look like little person) to get dropdown menu
 * 3. In the dropdown menu click on the option PRIJAVA
 * 4. Click on enter email field and enter email
 * 5. Click on the enter password field and enter password
 * 6. Confirm that you are not a robot
 * 6. Click on the button Prijava
 * 7. Enter some contents to a search bar
 * 8. Click on the button PRETRAGA
 * <p>
 * Expected results
 * 8 User get results of search and can choose to buy something
 */

public class SearchBarTest extends BaseTest {

    @Test

    public void testOfSearchBar() {

        //Invoking Chrome driver

        ChromeDriver driver = openChromeDriver( );

        try {

            //Login block

            text("Log in to a LC WAIKIKI page");
            LoginPage loginPage = new LoginPage( driver );
            loginPage.choseProfileIcon( );
            loginPage.choseSignInButton( );
            String currentURL = driver.getCurrentUrl( );
            assert currentURL.equals(Strings.LOGIN_PAGE_URL) : "User is on the wrong page. " + "  Actual: " + currentURL;

            text("Input email, password and login to LC WAIKIKI page");
            loginPage.inputEmail( );
            sleep( );
            loginPage.inputPassword( );
            sleep( );
            loginPage.notABot( );
            sleep( );
            loginPage.signIn( );
            String currentURL1 = driver.getCurrentUrl( );
            assert currentURL1.equals(Strings.MAIN_PAGE_URL) : "User is on the wrong page. " + "  Actual: " + currentURL;


            //Checking functionality of search bar

            text("Click on the search bar to check its functionality");
            MainPage mainPage = new MainPage( driver );
            sleep( );
            mainPage.searchBarTest( );
            String currentURL2 = driver.getCurrentUrl( );
            assert currentURL2.equals("https://www.lcwaikiki.rs/sr-RS/RS/search?q=decaci%20pidzame") : "User is on the wrong page. " + "  Actual: " + currentURL;
        }
        finally {

            driver.quit();
        }
    }
}

