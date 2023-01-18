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

public class SignupPage {

    //Looking for web elements

    @FindBy( xpath = "//i[@class = 'header-profile-icon']")
    WebElement profileIcon;

    @FindBy( xpath = "//a[@href ='https://www.lcwaikiki.rs/sr-RS/RS/register']")
    WebElement signUpButton;

    @FindBy ( xpath = "//input[@id = 'RegisterFormView_RegisterEmail']")
    WebElement inputEmail;

    @FindBy ( xpath = "//input[@id = 'RegisterFormView_Password']")
    WebElement inputPassword;

    @FindBy ( xpath = "//input[@id = 'RegisterPhoneNumberTR']")
    WebElement inputPhoneNumber;

    @FindBy ( xpath =  "//*[@id='RegisterFormView_IsSmsChecked']/following-sibling::ins")
    WebElement smsCheckBox;

    @FindBy ( xpath = "//div[@class='input-checkbox'] //div[@class='icheckbox']")
    WebElement generalConditionsCheckBox;

    @FindBy ( css = "//a[@class='button bc-blue register-button-link submit-button sign-up']")
    WebElement openAccount;

    @FindBy ( xpath = "//span/following-sibling::input[@id='RegisterFormView_ActivationCode']")
    WebElement smsCodeBox;

    @FindBy ( xpath = "//script/following-sibling::a[@class='button bc-blue register-button-link submit-button']")
    WebElement confirmVerificationCode;

    @FindBy( xpath = "//p[@class = 'urs-first']")
    WebElement headerText;

    //Invoking Chrome driver

    public ChromeDriver driver = null;

    //Constructor

    public SignupPage(ChromeDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Methods

    /**
     * THIS Method is used for slowdown send keys method on Booking.com page
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

        assert profileIcon.isDisplayed( ) : "Profile icon is not present. Expected to be there";

        Actions action = new Actions(driver);
        action.moveToElement(profileIcon).perform();
    }

    /**
     * THIS Method redirects user to signup page of LC WAIKIKI
     */

    public void choseSignUpButton( ) {

        signUpButton.click( );
    }

    /**
     * THIS Method input user email to signup page of LC WAIKIKI
     */

    public void inputEmail( ) {

        inputEmail.click( );

        String email = Strings.EMAIL_FOR_SIGNUP;
        for ( int i = 0; i < email.length( ); i++) {

            char c = email.charAt(i);
            String s = new StringBuilder( ).append( c ).toString( );

            inputEmail.sendKeys( s );
            sleepSendKeys();
        }
    }

    /**
     * THIS Method input user password to signup page of LC WAIKIKI
     */

    public void inputPassword( ) {

        inputPassword.click( );

        String password = Strings.PASSWORD_FOR_SIGNUP;
        for ( int i = 0; i < password.length( ); i++) {

            char c = password.charAt(i);
            String s = new StringBuilder( ).append( c ).toString( );

            inputPassword.sendKeys(s);
            sleepSendKeys();
        }
    }

    /**
     * THIS Method input user phone number to signup page of LC WAIKIKI
     */

    public void inputPhoneNumber( ) {

        inputPhoneNumber.click();

        String phone = Strings.PHONE_NUMBER;
        for (int i = 0; i < phone.length( ); i++) {

            char c = phone.charAt(i);
            String s = new StringBuilder().append(c).toString();

            inputPhoneNumber.sendKeys(s);
            sleepSendKeys();
        }
    }

    /**
     * THIS Method click on check box to receive sms info from LC WAIKIKI
     */

    public void smsChekBoxInfo( ) {

        smsCheckBox.click( );
    }

    /**
     * THIS Method click on check box to general conditions and terms from LC WAIKIKI
     */

    public void generalConditionsCheckBox( ) {

        generalConditionsCheckBox.click( );

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
     * THIS Method confirms entered data and submit user data to page of LC WAIKIKI
     */

    public void confirmRegistrationButton( ) {

        openAccount.click();
    }

    /**
     * THIS Method input select verification code box that user get on phone number provided to LC WAIKIKI
     */

    public void verificationCodeBox( ) {

        smsCodeBox.sendKeys( Strings.VERIFICATION_CODE );

    }

    /**
     * THIS Method click on the button Potvrdi to send verification code that user get on provided phone number to LC WAIKIKI
     */

    public void verificationCodeConfirm( ) {

        confirmVerificationCode.click();
    }


}
