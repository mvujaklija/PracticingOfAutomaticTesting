package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.Strings;

/**
 * TEST FOR SIGNUP TO DM DROGERIE
 * Steps
 * 1. Navigate to a first page of DM DROGERIE
 * 2. On first page click accept all cookies
 * 3. Click on the profile icon in the top right corner. Its look like little person
 * 4. Click on button REGISTRACIJA
 * 5. After redirection click on the salutation button Gospodin
 * 6. Click on field Ime and input yours first name for registration
 * 7. Click on field Prezime and input yours last name for registration
 * 8. Click on field DD and input yours day of birth for registration
 * 9. Click on field MM and input yours month of birth for registration
 * 10. Click on field YYYY and input yours year of birth for registration
 * 11. Click on field Mejl and input yours email address for registration
 * 12. Click on field Lozinka and input yours password for registration
 * 13. Click on the checkbox Opstim uslovima poslovanja
 * 14. Click on the checkbox Moj dm newsletter-a
 * 14. Click on the button Dalje
 * <p>
 * Expected results
 * 8 User is successfully registered and will receive email to verify his email address.
 */

public class RegisterTest extends BaseTest{

    @Test

    public void signUpToDmDrogerie( ) {

        //Invoking Chrome driver

        ChromeDriver driver = openChromeDriver();

        try {

            driver.get(Strings.FIRST_PAGE_URL);
            String currentURL = driver.getCurrentUrl( );
            assert currentURL.equals( Strings.FIRST_PAGE_URL ) : "User is on the wrong page. " + "  Actual: " + currentURL;

            RegisterPage registerPage = new RegisterPage( driver );
            text("Click on the button accept all cookies");
            longsleep();
            registerPage.acceptCookies();
            text("Click on the button REGISTRACIJA");
            registerPage.registerNewAccount();
            text("Fil out the form and click button DALJE to submit registration data");
            registerPage.registerData();
        }
        finally {

            driver.quit();
        }
    }
}
