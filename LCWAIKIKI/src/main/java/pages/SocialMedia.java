package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMedia {

    //Looking for web elements

    @FindBy(xpath = "//a [ @href = 'https://www.facebook.com/LCWaikikiSerbia/' ]")
    WebElement facebookButton;

    @FindBy(xpath = "//a [ @href = 'https://tr.linkedin.com/company/lc-waikiki' ]")
    WebElement linkedInButton;

    @FindBy(xpath = "//a [ @href = 'https://tr.pinterest.com/lcwaikiki/' ]")
    WebElement pinterestButton;

    @FindBy(xpath = "//a [ @href = 'https://www.instagram.com/lcwaikiki.serbia/' ]")
    WebElement instagramButton;

    //Invoking Chrome driver

    public ChromeDriver driver = null;


    //Constructor

    public SocialMedia(ChromeDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods

    /**
     * THIS Method redirect user to Facebook page of LC WAIKIKI
     */

    public void testFacebookButton( ) {

        assert facebookButton.isDisplayed( ) : "Facebook button is not present. Expected to be there";

        facebookButton.click( );

    }

    /**
     * THIS Method redirect user to LinkedIn page of LC WAIKIKI
     */

    public void testLinkedInButton( ) {

        assert linkedInButton.isDisplayed( ) : "LinkedIn button is not present. Expected to be there";

        linkedInButton.click( );

    }

    /**
     * THIS Method redirect user to Pinterest page of LC WAIKIKI
     */

    public void testPinterestButton( ) {

        assert pinterestButton.isDisplayed( ) : "LinkedIn button is not present. Expected to be there";

        pinterestButton.click( );

    }

    /**
     * THIS Method redirect user to Instagram page of LC WAIKIKI
     */

    public void testInstagramButton( ) {

        assert instagramButton.isDisplayed( ) : "LinkedIn button is not present. Expected to be there";

        instagramButton.click( );

    }


}
