package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    //Looking for web elements

    @FindBy( xpath = "//span[@class='bui-button__text'][normalize-space()='Register']")
    WebElement registerButton;

    @FindBy( xpath = "//input[@id='username'][@class='ZMH9h0HCYH9GGNxHnXGJ']")
    WebElement emailBox;

    @FindBy( xpath = "//span[@class='yfCvx60qsR50VNBG15jF'][normalize-space()='Continue with email']")
    WebElement continueWithEmail;

    @FindBy( xpath = "//input[@id='new_password'][@class='ZMH9h0HCYH9GGNxHnXGJ']")
    WebElement newPassword;

    @FindBy( xpath = "//input[@id='confirmed_password'][@class='ZMH9h0HCYH9GGNxHnXGJ']")
    WebElement confirmNewPassword;

    @FindBy( xpath = "//button[@class='Iiab0gVMeWOd4XcyJGA3 wPxWIS_rJCpwAWksE0s3 Ut3prtt_wDsi7NM_83Jc TuDOVH9WFSdot9jLyXlw EJWUAldA4O1mP0SSFXPm whxYYRnvyHGyGqxO4ici']")
    WebElement createAccount;

    @FindBy( xpath = "//*[@id='px-captcha']")
    WebElement notABot;

    //Invoking Chrome driver

    public ChromeDriver driver = null;

    //Constructor

    public SignupPage(ChromeDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Methods

    /**
     * THIS Method click on the register button on Booking.com page
     */

    public void registerButton( ) {

        assert registerButton.isDisplayed( ) : "Register button is not present. Expected to be there";

        registerButton.click();

    }

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
     * THIS Method click on email field and input email letter by letter in to the form for registration on Booking.com page
     */

    public void inputEmail( ) {

        emailBox.click();
        String email = Strings.EMAIL_FOR_SIGNUP;
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

        continueWithEmail.click();

    }

    /**
     * THIS Method click on password field and input password letter by letter in to the form for registration on Booking.com page
     */

    public void inputPassword( ) {

        newPassword.click();
        String password = Strings.PASSWORD_FOR_SIGNUP;
        for ( int i = 0; i < password.length(); i++) {

            char c = password.charAt(i);
            String s =new StringBuilder().append(c).toString();

            newPassword.sendKeys(s);
            sleepSendKeys();

        }

    }

    /**
     * THIS Method click on confirm password field and input password letter by letter in to the form for registration on Booking.com page
     */

    public void confirmPassword( ) {

        confirmNewPassword.click();
        String password = "Lukicamukica2018+@";
        for ( int i = 0; i < password.length(); i++) {

            char c = password.charAt(i);
            String s =new StringBuilder().append(c).toString();

            confirmNewPassword.sendKeys(s);
            sleepSendKeys();

        }
    }

    /**
     * THIS Method click on password field and input new password for registration on Booking.com page
     */

    public void createAccount( ) {

        createAccount.click();

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
