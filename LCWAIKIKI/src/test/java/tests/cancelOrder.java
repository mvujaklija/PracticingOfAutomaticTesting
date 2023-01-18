package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
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

public class cancelOrder extends BaseTest{

    @Test

    public void testOfCancelOrder() {

        //Invoking Chrome driver

        ChromeDriver driver = openChromeDriver();

        try {

            //Login

            text("Log in to a LC WAIKIKI page");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.choseProfileIcon();
            loginPage.choseSignInButton();
            loginPage.loginUser(Strings.EMAIL_FOR_SIGNIN, Strings.PASSWORD_FOR_SIGNIN);

            //Canceling order

            text( "Click to a profile icon on main page in intention to cancel order");
            CancelOrder cancelOrder = new CancelOrder( driver );
            cancelOrder.choseProfileIcon();
            cancelOrder.myOrdersSection();
            cancelOrder.cancelOrderLink();
            cancelOrder.setCancelOrderButton();

        }
        finally {

            driver.quit();

        }
    }

}
