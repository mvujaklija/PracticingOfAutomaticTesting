package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.SignupPage;
import pages.Strings;

/**
 * TEST FOR SIGNUP TO Booking.com
 * Steps
 * 1. Navigate to a main page
 * 2. On start page click REGISTER button in tob right corner
 * 3. On the next page in email field input email that you want to use for registration
 * 4. Click on the button Continue with email
 * 5. On the next page in password field input password you want to use for yours account
 * 6. On the same page in confirm password field retype same password to confirm password you want to use
 * 7. Click on the button Create account

 * <p>
 * Expected results
 * 8 User is successfully registered and can go to start browsing on Booking.com
 */

public class registerTest extends BaseTest {

    @Test

    public void regiserToBookingCom() {

        //Invoking Chrome driver

        ChromeDriver driver = openChromeDriver();

        try {

            driver.get(Strings.FIRST_PAGE_URL);
            String currentURL = driver.getCurrentUrl();
            assert currentURL.equals(Strings.FIRST_PAGE_URL) : "User is on the wrong page. " + "  Actual: " + currentURL;

            text("Click on the REGISTER button");

            SignupPage signupPage = new SignupPage(driver);
            signupPage.registerButton();
            sleepFourSeconds();
            signupPage.inputEmail();
            sleepFourSeconds();
            signupPage.continueWithEmail();
            sleepFourSeconds();
            signupPage.inputPassword();
            sleepFourSeconds();
            signupPage.confirmPassword();
            sleepFourSeconds();
            signupPage.createAccount();
            sleepFourSeconds();
            signupPage.humanVerification();



        }
        finally {

            //driver.quit();

        }
    }
}
