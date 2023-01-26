package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.*;

/**
 * TEST SEARCH BAR on LC WAIKIKI page
 * Steps
 * 1. Navigate to a first page
 * 2. On start page hover mouse over profile icon in tob right corner (it is look like little person) to get dropdown menu
 * 3. In the dropdown menu click on the option Moje porudžbine
 * 4. On page Moje porudžbine click link Otkaži porudžbinu
 *
 * <p>
 * Expected results
 * 5. User is successfully cancel order
 */

public class CancelOrder extends BaseTest{

    @Test

    public void testOfCancelOrder() {

        //Invoking Chrome driver

        ChromeDriver driver = openChromeDriver();

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

            //Canceling order

            text( "Click to a profile icon on main page in intention to cancel order");
            pages.CancelOrder cancelOrder = new pages.CancelOrder( driver );
            cancelOrder.choseProfileIcon();
            cancelOrder.myOrdersSection();
            cancelOrder.cancelOrderLink();
            cancelOrder.setCancelOrderButton();

        }
        finally {

            //driver.quit();

        }
    }

}
