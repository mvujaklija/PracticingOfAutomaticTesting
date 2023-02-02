package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    //Looking for web elements

    @FindBy( xpath = "//*[@id = 'widgetNavigationContainer']/ul/li[3]/div/button")
    WebElement myAccount;

    @FindBy( xpath = "//*[normalize-space()='Registrujte se']")
    WebElement registerButton;

    @FindBy( xpath = "//*[@id = 'firstName-input']")
    WebElement firstName;

    @FindBy( xpath = "//*[@id = 'lastName-input']")
    WebElement lastName;

    @FindBy( xpath = "//*[@id = 'birthDate-date-input-day']")
    WebElement birthDay;

    @FindBy( xpath = "//*[@id = 'birthDate-date-input-month']")
    WebElement birthMonth;

    @FindBy( xpath = "//*[@id = 'birthDate-date-input-year']")
    WebElement birthYear;

    @FindBy( xpath = "//*[@id = 'emailAddress-input']")
    WebElement registerMail;

    @FindBy( xpath = "//*[@id = 'password']")
    WebElement registerPassword;

    @FindBy( xpath = "//*[@id = 'registration-form']/div/div[4]/div[3]/div[1]/button")
    WebElement showPassword;

    @FindBy( xpath = "//*[@id = 'acceptTermsOfUse-input']")
    WebElement acceptGeneralConditions;

    @FindBy( xpath = "//*[@id = 'acceptNewsletter-input']")
    WebElement acceptNewsLetter;

    @FindBy( xpath = "//*[@id = 'submitButton']")
    WebElement submitButton;

    @FindBy( xpath = "//p[@class = 'm jb fu t w']")
    WebElement assertText;



    //Invoking Chrome driver

    public ChromeDriver driver = null;

    //Constructor

    public RegisterPage(ChromeDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Methods

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

    public void registerNewAccount( ) {

        myAccount.click();
        registerButton.click();
        String currentURL = driver.getCurrentUrl( );
        assert currentURL.equals(Strings.REGISTER_PAGE_URL) : "User is on the wrong page. " + "  Actual: " + currentURL;
    }

    /**
     * THIS Method is used for filing out form to register on DM DROGERIE page
     */

    public void registerData( ) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds( 10 ) );
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id = 'salutation-radio-button-field-HERR-radio']"))).click( );
        firstName.click();
        firstName.sendKeys(Strings.NAME);
        lastName.click();
        lastName.sendKeys(Strings.SURNAME);
        birthDay.click();
        birthDay.sendKeys(Strings.DAY);
        birthMonth.click();
        birthMonth.sendKeys(Strings.MONTH);
        birthYear.click();
        birthYear.sendKeys(Strings.YEAR);
        registerMail.click();
        registerMail.sendKeys(Strings.EMAIL_FOR_SIGNUP);
        registerPassword.click();
        registerPassword.sendKeys(Strings.PASSWORD_FOR_SIGNUP);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        showPassword.click();
        acceptGeneralConditions.click();
        acceptNewsLetter.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        submitButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!assertText.isDisplayed()) throw new AssertionError("User is not register successfully");

    }
}
