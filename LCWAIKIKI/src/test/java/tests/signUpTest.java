package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.SignupPage;
import pages.Strings;
import java.util.concurrent.TimeUnit;

/**
 * TEST FOR SIGNUP TO LC WAIKIKI
 * Steps
 * 1. Navigate to a main page
 * 2. On start page click profile icon in tob right corner (it is look like little person)
 * 3. Click on the option OTVORITE NALOG
 * 4. Click on enter email field
 * 5. Click on the enter password field
 * 6. Click on the icon to show hide password
 * 7. Click on the enter phone number field
 * 8. Click on checkbox to receive email notification about promotions
 * 9. Click on the checkbox to receive sms notification about promotions
 * 10. click on the checkbox for accepting general conditions
 * 11. Click on the checkbox to verify that it is human and not robot registering
 * 12. Click on the button Otvorite nalog
 * 13. Click on the verification code field and enter verification code
 * 14. Click on the button Potvrdi
 * <p>
 * Expected results
 * 8 User is successfully registered and can go to start shopping by click on button
 */

public class signUpTest extends BaseTest {

    @Test

    public void signUpToLcWaikiki( ) {

        //Invoking Chrome driver

        ChromeDriver driver = openChromeDriver();

        try {

            driver.get(Strings.FIRST_PAGE_URL);
            String currentURL = driver.getCurrentUrl( );
            assert currentURL.equals( Strings.FIRST_PAGE_URL ) : "User is on the wrong page. " + "  Actual: " + currentURL;

            text("Clicking on the profile icon and redirecting to signup page of the LC WAIKIKI");

            SignupPage signupPage = new SignupPage( driver );
            signupPage.choseProfileIcon( );

            text("Click on the option OTVORITE NALOG");

            signupPage.choseSignUpButton( );
            String currentURL1 = driver.getCurrentUrl();
            assert currentURL1.equals( Strings.REGISTER_PAGE_URL ) : "User is on the wrong page. " + "  Actual: " + currentURL;

            text("Input email that you use to register and login to LC WAIKIKI page");

            signupPage.inputEmail( );

            text("Input password that you use to register and login to LC WAIKIKI page");

            signupPage.inputPassword( );

            text("Input phone number where you will get verification code for validate registration on LC WAIKIKI page");

            signupPage.inputPhoneNumber( );
            sleep();

            text("Click on checkbox to receive promotion over sms to a number that you provided to LC WAIKIKI page");

            signupPage.smsChekBoxInfo( );
            sleep();

            text("Click on the checkbox to accept general terms and conditions of LC WAIKIKI page");

            signupPage.generalConditionsCheckBox( );
            sleep();

            text("Click on the checkbox of reCAPTCHA  of LC WAIKIKI page");
            signupPage.notABot( );

            text("Click on the button Otvorite nalog");
            signupPage.confirmRegistrationButton( );


            text( "Input verification code that you get over mobile that you provide to LC WAIKIKI ");
            signupPage.verificationCodeBox( );

            text( "Confirmation of verification code and finishing registration");
            driver.manage( ).timeouts( ).implicitlyWait(20, TimeUnit.SECONDS);
            signupPage.verificationCodeConfirm( );
        }
        finally
        {
            //driver.quit();
        }
    }
}

