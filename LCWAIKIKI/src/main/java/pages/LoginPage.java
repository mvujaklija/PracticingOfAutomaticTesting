package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    //Looking for web elements

    @FindBy( xpath = "//i[@class = 'header-profile-icon']" )
    WebElement profileIcon;

    @FindBy( xpath = "//a[@href = 'https://www.lcwaikiki.rs/sr-RS/RS/login'] " )
    WebElement signInButton;

    @FindBy( xpath = "//input[@id='LoginEmail']" )
    WebElement inputEmail;

    @FindBy( xpath = "//input[@id='Password']" )
    WebElement inputPassword;

    @FindBy( xpath = "//a[@id='loginLink'] [@class='button bc-blue login-button-link']" )
    WebElement signIn;

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
     * THIS Method is used for slowdown send keys method on page of LC WAIKIKI
     */

    public void sleepSendKeys( ) {

        try {
            Thread.sleep(300);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * THIS Method give user options for signup and sign in on page of LC WAIKIKI
     */

    public void choseProfileIcon( ) {

        Actions action = new Actions( driver );
        action.moveToElement( profileIcon );
    }

    /**
     * THIS Method redirects user to sign in page of LC WAIKIKI
     */

    public void choseSignInButton( ) {

        signInButton.click( );

    }

    /**
     * THIS Method input user email on signup page of LC WAIKIKI
     */

    public void inputEmail( ) {

        inputEmail.click( );

        String email = Strings.EMAIL_FOR_SIGNUP;
        for (int i = 0; i < email.length(); i++) {

            char c = email.charAt(i);
            String s = new StringBuilder( ).append( c ).toString( );

            inputEmail.sendKeys( s );
            sleepSendKeys( );
        }
    }

    /**
     * THIS Method input user password on signup page of LC WAIKIKI
     */

    public void inputPassword( ) {

        inputPassword.click( );

        String password = Strings.PASSWORD_FOR_SIGNIN;
        for (int i = 0; i < password.length(); i++) {

            char c = password.charAt(i);
            String s = new StringBuilder( ).append( c ).toString( );

            inputPassword.sendKeys( s );
            sleepSendKeys( );
        }
    }

    /**
     * THIS Method click on check box to verify that it is human registering on LC WAIKIKI
     */

    public void notABot( ) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds( 15 ));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
    }

    /**
     * THIS Method clicks on sign in button on page of LC WAIKIKI
     */

    public void signIn( ) {

        signIn.click( );
    }
}





