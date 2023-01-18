package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelOrder {

    @FindBy( xpath = "//i[@class = 'header-profile-icon bndl-user-icon bndl-user-icon-dims']" )
    WebElement profileIcon;

    @FindBy ( xpath = "//ul[@class='dropdown-menu'] //a[normalize-space()='Moje porudžbine'] ")
    WebElement myOrders;

    @FindBy ( xpath = "//a[@id='Ro-Responsive-OrderList2'][normalize-space()='\uF027 Otkaži porudžbinu']")
    WebElement cancelOrder;

    @FindBy( xpath = "//a[ @id = 'modalSaveChangesYesBtn']")
    WebElement cancelOrderButton;



    //Invoking Chrome driver

    public ChromeDriver driver = null;

    //Constructor

    public CancelOrder(ChromeDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Methods

        /**
         * THIS Method chose profile icon on page of LC WAIKIKI
         */

        public void choseProfileIcon( ) {

            assert profileIcon.isDisplayed( ) : "Profile icon is not present. Expected to be there";

            Actions action = new Actions(driver);
            action.moveToElement(profileIcon).perform();

        }

        /**
         * THIS Method enter to profile section Moje porudžbine on page of LC WAIKIKI
         */

        public void myOrdersSection( ) {

            myOrders.click();

        }

        /**
         * THIS Method give user options for cancel order on page of LC WAIKIKI
         */

        public void cancelOrderLink( ) {

            cancelOrder.click();

        }

    /**
     * THIS Method give user options for cancel order on page of LC WAIKIKI
     */

    public void setCancelOrderButton( ) {

        cancelOrderButton.click();

    }

}

