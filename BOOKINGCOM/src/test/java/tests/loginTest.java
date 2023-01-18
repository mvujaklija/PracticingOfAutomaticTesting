package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

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

public class loginTest extends BaseTest{

    @Test

    public void logInToBookingCom() {

        //Invoking Chrome driver

        ChromeDriver driver = openChromeDriver();

        try {

            text("Navigate to a start page and select Sign in button");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.choseSignInButton();
            sleepFourSeconds();
            loginPage.inputEmail();
            sleepFourSeconds();
            loginPage.continueWithEmail();
            sleepFourSeconds();
            loginPage.inputPassword();
            sleepFourSeconds();
            loginPage.signIn();
            sleepFourSeconds();
            loginPage.humanVerification();


    }
    finally {

            //driver.quit();

        }
    }
}
