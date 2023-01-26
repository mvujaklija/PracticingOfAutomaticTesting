package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShoppingPage;
import pages.Strings;

/**
 * TEST SEARCH BAR on LC WAIKIKI page
 * Steps
 * 1. Navigate to a first page
 * 2. On start page hover mouse over profile icon in tob right corner (it is look like little person) to get dropdown menu
 * 3. In the dropdown menu click on the option PRIJAVA
 * 4. Click on enter email field and enter email
 * 5. Click on the enter password field and enter password
 * 6. Click on the button Prijava
 * 7. Chose one product for buying
 * 8. Add product to the shopping chart
 * 9. Click on the shopping chart button
 * 8. Click on the check-out
 * <p>
 * Expected results
 * 8 User is successfully order product to home address
 */

public class BuyOneItem extends BaseTest{

        @Test

        public void testOfBuyingItem() {

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

                //Adding products to shopping chart and checking the content of shopping chart

                ShoppingPage shoppingPage = new ShoppingPage( driver );
                shoppingPage.selectSectionKids( );
                shoppingPage.selectOnePyjama( );
                shoppingPage.choseSize( );
                shoppingPage.addToChart( );
                sleep( );
                assert shoppingPage.getNumberFromShoppingChartBadge ( ).equals ( "1" ) : "Wrong number of items. Expected: 1,  Actual   " + shoppingPage.getNumberFromShoppingChartBadge();
                shoppingPage.shoppingChart( );
                shoppingPage.checkOut( );
                sleep( );
                shoppingPage.deliveryToHomeAddress( );
                shoppingPage.assertMethod();

            }
            finally {

                //driver.quit();

            }

        }

}
