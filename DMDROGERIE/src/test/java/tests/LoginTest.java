package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Strings;

/**
 * TEST FOR LOGIN TO DM DROGERIE page
 * Steps
 * 1. Navigate to a first page of DM DROGERIE
 * 2. On first page click accept all cookies
 * 2. Click on the profile icon in the top right corner. Its look like little person
 * 3. Click on button PRIJAVA
 * 4. Click on enter email field and enter email
 * 5. Click on the enter password field and enter password
 * 6. Confirm that you are not a robot
 * 7. Click on the button Prijava
 * <p>
 * Expected results
 * 8 User is successfully logged in to account and can go to start shopping
 */

public class LoginTest extends BaseTest {

    @Test

    public void loginToDmDrogerie( ) {

        //Invoking Chrome driver

        ChromeDriver driver = openChromeDriver();

        try {

            //Test of Login


            LoginPage loginPage = new LoginPage( driver );
            text("Click on the button accept all cookies");
            longsleep();
            loginPage.acceptCookies();

            text("Sign in to account");
            loginPage.signInToAccount();

            text("Input email, password and login to DM DROGERIE page");
            loginPage.inputEmail( );
            sleep( );
            loginPage.inputPassword( );
            sleep( );
            loginPage.showPassword();
            sleep();
            loginPage.doNotStaySignIn();
            sleep();
            loginPage.signIn( );


        }
        finally {

            //driver.quit( );
        }
    }
}