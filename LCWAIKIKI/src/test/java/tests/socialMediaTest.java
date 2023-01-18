package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.SocialMedia;
import pages.Strings;
import java.util.ArrayList;

/**
 * TEST SOCIAL MEDIA BUTTONS
 * Steps
 * 1. Navigate to a main page
 * 2. On start page scroll down to the bottom of the page
 * 3. Click on the FACEBOOK icon
 * 4. Click on the LinkedIn icon
 * 5. Click on the PINTEREST icon
 * 6. Click on the INSTAGRAM icon
 * 7.
 * <p>
 * Expected results
 * 8 User is successfully redirected to appropriate page according to the icon that is clicked
 */

public class socialMediaTest extends BaseTest {

    @Test

    public void socialMediaTest( ) {

        //Invoking Chrome driver

        ChromeDriver driver = openChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


        try {

            driver.get(Strings.FIRST_PAGE_URL);

            //Text

            text("Clicking and redirecting to FACEBOOK, LinkedIn, PINTEREST and INSTAGRAM page of the LC WAIKIKI");

            //Test of Facebook

            text( "Testing of Facebook button");
            SocialMedia socialMedia = new SocialMedia(driver);
            socialMedia.testFacebookButton();
            ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(1));
            String currentURL = driver.getCurrentUrl();
            assert currentURL.equals("https://www.facebook.com/LCWaikikiSerbia/") : "User is on the wrong page. " + "  Actual: " + currentURL;
            driver.close();
            driver.switchTo().window(tab.get(0));

            //Test of LinkedIn

            text( "Testing of LinkedIn button");
            socialMedia.testLinkedInButton();
            ArrayList<String> tab1 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab1.get(1));
            String currentURL1 = driver.getCurrentUrl();
            assert currentURL1.equals("https://www.linkedin.com/company/lc-waikiki/?originalSubdomain=tr") : "User is on the wrong page. " + "  Actual: " + currentURL;
            driver.close();
            driver.switchTo().window(tab.get(0));

            //Test of Pinterest

            text( "Testing of Pinterest button");
            socialMedia.testPinterestButton();
            ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab2.get(1));
            String currentURL2 = driver.getCurrentUrl();
            assert currentURL2.equals("https://tr.pinterest.com/lcwaikiki/") : "User is on the wrong page. " + "  Actual: " + currentURL;
            driver.close();
            driver.switchTo().window(tab.get(0));

            //Test of Instagram

            text( "Testing of Instagram button");
            socialMedia.testInstagramButton();
            ArrayList<String> tab3 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab3.get(1));
            String currentURL3 = driver.getCurrentUrl();
            assert currentURL3.equals("https://www.instagram.com/lcwaikiki.serbia/") : "User is on the wrong page. " + "  Actual: " + currentURL;
            driver.close();
            driver.switchTo().window(tab.get(0));


        } finally {

            driver.quit();

        }

    }
}
