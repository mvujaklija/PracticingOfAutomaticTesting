package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //Looking for web elements

    @FindBy( xpath = "//span[@class='bui-button__text'][normalize-space()='Sign in']" )
    WebElement signInButton;

    @FindBy( xpath = "//input[@id='username'][@class='ZMH9h0HCYH9GGNxHnXGJ']" )
    WebElement emailBox;

    @FindBy( xpath = "//span[@class='yfCvx60qsR50VNBG15jF'][normalize-space()='Continue with email']" )
    WebElement continueWithEmail;

    @FindBy( xpath = "//input[@id='password'][@class='ZMH9h0HCYH9GGNxHnXGJ']" )
    WebElement inputPassword;

    @FindBy( xpath = "//button[@class='Iiab0gVMeWOd4XcyJGA3 wPxWIS_rJCpwAWksE0s3 Ut3prtt_wDsi7NM_83Jc TuDOVH9WFSdot9jLyXlw EJWUAldA4O1mP0SSFXPm whxYYRnvyHGyGqxO4ici'][normalize-space()='Sign in']" )
    WebElement signIn;

    @FindBy( xpath = "//*[@id='px-captcha']")
    WebElement notABot;

    //Invoking Chrome driver

    public ChromeDriver driver = null;

    //Constructor

    public LoginPage ( ChromeDriver driver ) {

        this.driver = driver;
        driver.get ( Strings.FIRST_PAGE_URL );
        PageFactory.initElements ( driver , this );


    }

    //Methods

    /**
     * THIS Method is used for slowdown send keys method on Booking.com page
     */

    public void sleepSendKeys( ) {

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * THIS Method redirects user to sign in page of Booking.com
     */

    public void choseSignInButton( ) {

        signInButton.click( );

    }

    /**
     * THIS Method input user email to sign in page of Booking.com
     */

    public void inputEmail( ) {

        emailBox.click( );
        String email = Strings.EMAIL_FOR_SIGNIN;
        for ( int i = 0; i < email.length(); i++) {

            char c = email.charAt(i);
            String s =new StringBuilder().append(c).toString();

            emailBox.sendKeys(s);
            sleepSendKeys();

        }

    }

    /**
     * THIS Method click on button Continue with email on Booking.com page
     */

    public void continueWithEmail( ) {

        continueWithEmail.click( );

    }

    /**
     * THIS Method input user password on sign in page on Booking.com
     */

    public void inputPassword() {

        inputPassword.click ( );
        String email = Strings.PASSWORD_FOR_SIGNIN;
        for ( int i = 0; i < email.length(); i++) {

            char c = email.charAt(i);
            String s =new StringBuilder().append(c).toString();

            emailBox.sendKeys(s);
            sleepSendKeys();

        }

    }

    /**
     * THIS Method clik on Sign in button on sign in page on Booking.com
     */

    public void signIn() {

       signIn.click();

    }

    /**
     * THIS Method is used for sleep actions to verify that human is registering on Booking.com page
     */

    public void sleepMethod( ) {

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * THIS Method click on button for verification that is human registering on Booking.com page
     */

    public void humanVerification( ) {

        Actions action = new Actions(driver);
        action.moveToElement(notABot).perform();
        Actions action1 = new Actions(driver);
        action1.clickAndHold(notABot).perform();
        sleepMethod();
        Actions action2 = new Actions(driver);
        action2.release(notABot).perform();


    }


}
