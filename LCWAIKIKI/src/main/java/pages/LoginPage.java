package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //Looking for web elements

    @FindBy( xpath = "//i [ @class = 'header-profile-icon' ]" )
    WebElement profileIcon;

    @FindBy( xpath = "//a [ @href = 'https://www.lcwaikiki.rs/sr-RS/RS/login' ] " )
    WebElement signInButton;

    @FindBy( xpath = "//input [ @id='LoginEmail' ]" )
    WebElement inputEmail;

    @FindBy( xpath = "//input [ @id='Password' ]" )
    WebElement inputPassword;

    @FindBy( xpath = "//a [ @id='loginLink' ] [ @class='button bc-blue login-button-link' ]" )
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
     * THIS Method input user email and password on signup page of LC WAIKIKI
     */

    public void loginUser(String email, String password ) {

        inputEmail.click ( );
        assert inputEmail.isDisplayed( ) : "Input email field is not present. Expected to be there";
        inputEmail.sendKeys ( email );
        assert inputPassword.isDisplayed( ) : "Input password field is not present. Expected to be there";
        inputPassword.click ( );
        inputPassword.sendKeys ( password );
        assert signIn.isDisplayed( ) : "Prijava button is not present. Expected to be there";
        signIn.click ( );

    }

}



