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

public class ShoppingPage {

    //Looking for web elements

    @FindBy( xpath = "//i [ @class = 'header-profile-icon bndl-user-icon bndl-user-icon-dims' ]" )
    WebElement profileIcon;

    @FindBy(xpath = "//a[@class='header-logo img-logo logo-center']")
    WebElement headerLogo;

    @FindBy ( xpath =  "//a[@id='mega_menu_dd_9'][@class='dropdown-toggle dropdown-toggle ']")
    WebElement kids;

    @FindBy ( xpath =  "//a[ @href ='/sr-RS/RS/category/boys/pyjamas-c104']")
    WebElement pyjamas;

    @FindBy ( xpath = "//*[@id= 'model_2673076_6371845']/div[1]/img[1]")
    WebElement onePyjama;

    @FindBy ( xpath = "//*[@id = 'option-size' ]/a[6]")
    WebElement chooseSize;

    @FindBy ( xpath = "//*[@id= 'pd_add_to_cart' ]")
    WebElement addToChart;

    @FindBy ( xpath = "//span[@class='spanCart cart-item-count header-cart-quantity']")
    WebElement shoppingChartBadge;

    @FindBy( xpath = "//a [ @href = 'https://www.lcwaikiki.rs/sr-RS/RS/mybag' ]")
    WebElement shoppingChart;

    @FindBy ( xpath = "//*[@id = 'Cart_CompleteOrder']")
    WebElement checkOut;

    @FindBy ( xpath = "//*[@id = 'BillingAddressViewModel_FullName']")
    WebElement nameOfBuyer;

    @FindBy (xpath = "//*[@id = 'select2-BillingAddressViewModel_PostalCodeId-container' ]")
    WebElement postalCodeContainer;

    @FindBy ( xpath = "/html/body/span/span/span[1]/input")
    WebElement postalCode;

    @FindBy ( xpath = "//*[@id= 'select2-BillingAddressViewModel_PostalCodeId-results']/li")
    WebElement selectPostalCode;

    @FindBy ( xpath = "//textarea[@name='BillingAddressViewModel.Address'][@class='ym-disable-keys']")
    WebElement billingAddress;

    @FindBy ( xpath = "//*[@id = 'BillingAddressViewModel_PhoneNumberWithCountryCode']")
    WebElement phoneNumber;

    @FindBy (xpath =  "//*[@id = 'BillingAddressViewModel_AddressDefinition']")
    WebElement placeOfDelivery;

    @FindBy ( xpath = "//a[@id='btn-cargo-continue'][@class='button bc-blue center ']")
    WebElement continueOnNextStage;

    @FindBy ( xpath = "//*[@id= 'rudiments-contract-cashondelivery']/div[1]/label/div/ins")
    WebElement acceptingGeneralConditions;

    @FindBy ( xpath = "//*[@id = 'btn-cash-on-delivery-payment-confirm']")
    WebElement procidePayment;

    //Invoking Chrome driver

    public ChromeDriver driver = null;

    //Constructor

    public ShoppingPage(ChromeDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Methods

    /**
     * THIS Method select section DECA/DEČACI/Pidžame on main page of LC WAIKIKI
     */

    public void selectSectionKids ( ) {


        Actions action = new Actions( driver );
        action.moveToElement( kids ).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds( 10 ) );
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id = 'menu_9' ]/div/div/div[1]/div[2]/div[1]"))).click();
        pyjamas.click();

    }

    /**
     * THIS Method select one of products on page of LC WAIKIKI
     */

    public void selectOnePyjama ( ) {

        onePyjama.click();
    }

    /**
     * THIS Method chooses size of products on page of LC WAIKIKI
     */

    public void choseSize ( ) {

        chooseSize.click();
    }

    /**
     * THIS Method adds one of products on page of LC WAIKIKI
     */

    public void addToChart ( ) {

        addToChart.click();
    }

    /**
     * THIS Method get number of items in sopping chart
     */

    public Object getNumberFromShoppingChartBadge ( ) {

        assert shoppingChartBadge.isDisplayed ( ) : "Shopping chart badge is not display number of items. Expected to number of items be there.";
        String number = shoppingChartBadge.getText ( );
        return number;

    }

    /**
     * THIS Method clicks on the shopping chart icon of LC WAIKIKI
     */

    public void shoppingChart ( ) {

        shoppingChart.click();

    }

    /**
     * THIS Method redirects user to check out of LC WAIKIKI
     */

    public void checkOut ( ) {

        checkOut.click();

    }

    /**
     * THIS Method redirects user to input data for delivery out of LC WAIKIKI
     */

    public void deliveryToHomeAddress ( ) {

        nameOfBuyer.click();
        nameOfBuyer.sendKeys(Strings.NAME_OF_BUYER);
        postalCodeContainer.click();
        postalCode.click();
        postalCode.sendKeys(Strings.POSTAL_CODE);

    }

    /**
     * THIS Method is continues of input data for delivery out of LC WAIKIKI
     */

    public void deliveryToHomeAddress1 ( ) {

        billingAddress.sendKeys(Strings.DELIVERY_ADDRESS);
        phoneNumber.click();
        phoneNumber.sendKeys(Strings.PHONE_NUMBER);
        placeOfDelivery.click();
        placeOfDelivery.sendKeys(Strings.PLACE_OF_DELIVERY);
        continueOnNextStage.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds( 10 ) );
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id= 'anchor-cash-on-delivery']"))).click();
        acceptingGeneralConditions.click();
        procidePayment.click();

    }
}
