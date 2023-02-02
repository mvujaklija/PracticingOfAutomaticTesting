package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
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

    @FindBy( xpath = "//*[@id = 'widgetNavigationContainer']/ul/li[3]/div/button")
    WebElement myAccount;

    @FindBy( xpath = "//*[normalize-space()='Prijava']")
    WebElement signInButton;

    @FindBy( xpath = "//input[@id='emailAddress-input']" )
    WebElement inputEmail;

    @FindBy( xpath = "//input[@id='password-input']" )
    WebElement inputPassword;

    @FindBy( xpath = "//*[@id ='login-form']/div[4]/button" )
    WebElement showPassword;

    @FindBy( xpath = "//*[@id = 'rememberMe-input']")
    WebElement staySignIn;

    @FindBy( xpath = "//button[@id='login-button']" )
    WebElement signIn;

    @FindBy( xpath = "//*[normalize-space()='Marko Branković']")
    WebElement assertText;

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
     * THIS Method is used for slowdown send keys method on DM DROGERIE page
     */

    public void sleepSendKeys( ) {

        try {
            Thread.sleep(300);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * THIS Method is used for accepting cookies on DM DROGERIE page
     */

    public void acceptCookies( ) {

        WebElement element = driver.findElement(By.cssSelector("#usercentrics-root"));
        SearchContext context = element.getShadowRoot();
        WebElement cookieAcceptAll = context.findElement(By.cssSelector("button[data-testid = 'uc-accept-all-button']"));
        cookieAcceptAll.click();
    }

    /**
     * THIS Method is used for chose option to register  on DM DROGERIE page
     */

    public void signInToAccount( ) {

        myAccount.click();
        signInButton.click();
        String currentURL = driver.getCurrentUrl( );
        assert currentURL.equals(Strings.LOGIN_PAGE_URL) : "User is on the wrong page. " + "  Actual: " + currentURL;
    }



    /**
     * THIS Method input user email on signup page of DM DROGERIE
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
     * THIS Method input user password on signup page of DM DROGERIE
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
     * THIS Method clicks on show password button on page of DM DROGERIE
     */

    public void showPassword( ) {

        showPassword.click();
    }

    /**
     * THIS Method unchecks checkbox stay sign in because we do not want that and by default it is checked on page of DM DROGERIE
     */

    public void doNotStaySignIn( ) {

        staySignIn.click();
    }

    /**
     * THIS Method clicks on sign in button on page of DM DROGERIE
     */

    public void signIn( ) {

        signIn.click( );
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        myAccount.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!assertText.isDisplayed()) throw new AssertionError("User is not register successfully");

    }
}