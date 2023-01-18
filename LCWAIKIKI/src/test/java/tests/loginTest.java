package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Strings;

/**
 * TEST FOR SIGNUP TO LC WAIKIKI
 * Steps
 * 1. Navigate to a first page of LC WAIKIKI
 * 2. On first page hover mouse over profile icon in top right corner (it is look like little person) to get dropdown menu
 * 3. In the dropdown menu click on the option PRIJAVA
 * 4. Click on enter email field and enter email
 * 5. Click on the enter password field and enter password
 * 6. Click on the button Prijava
  * <p>
 * Expected results
 * 8 User is successfully loged in to acount and can go to start shopping
 */

public class loginTest extends BaseTest {

    @Test

    public void loginToLcWaikiki( ) {

        //Invoking Chrome driver

        ChromeDriver driver = openChromeDriver();

        try {

            //Text

            text("Hovering with the mouse over the profile icon and redirecting to signup page of the LC WAIKIKI");

            //Test of Login

            text("Select profile icon");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.choseProfileIcon();

            //Test of entering data and sign in on the page LC WAIKIKI

            text("Click on the option PRIJAVA");
            loginPage.choseSignInButton();
            String currentURL = driver.getCurrentUrl();
            assert currentURL.equals(Strings.LOGIN_PAGE_URL) : "User is on the wrong page. " + "  Actual: " + currentURL;

            text("Input email, password and login to LC WAIKIKI page");
            loginPage.loginUser(Strings.EMAIL_FOR_SIGNIN, Strings.PASSWORD_FOR_SIGNIN);
            String currentURL1 = driver.getCurrentUrl();
            assert currentURL1.equals(Strings.MAIN_PAGE_URL) : "User is on the wrong page. " + "  Actual: " + currentURL;

        }
        finally {

            //driver.quit();

        }

    }

}
