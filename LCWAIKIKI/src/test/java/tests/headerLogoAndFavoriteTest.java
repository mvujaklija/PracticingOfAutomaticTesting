//package tests;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//import pages.LoginPage;
//import pages.MainPage;
//import pages.Strings;
//
///**
// * TEST SEARCH BAR on LC WAIKIKI page
// * Steps
// * 1. Navigate to a first page and log in to acount
// * 2. On start page hover mouse over navigation bar to get dropdown menu and select button DECA
// * 3. In the dropdown menu click on the option DEČACI
// * 4. In the section DECACI click link Pidžame
// * 5. Select one of the pyjamas and click on it
// * 6. In new tab click to icon that look like hearth to add product to favorites
// * 7. In the top right corner click to icon that is look like hearth
// * 8. Werify that selected product is in favorites page
// * 9. Click on heather logo to get back to a main page
// * <p>
// * Expected results
// * 8. In favorites page selected product is present. After click on heather logo user is back on the main page
// */
//
//public class headerLogoAndFavoriteTest extends BaseTest {
//
//    @Test
//
//    public void testOfHeaderAndFavorites( ) {
//
//        //Invoking Chrome driver
//
//        ChromeDriver driver = openChromeDriver( );
//
//        try {
//
//            //Login
//
//            text("Log in to a LC WAIKIKI page");
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.choseProfileIcon();
//            loginPage.choseSignInButton();
//            loginPage.loginUser(Strings.EMAIL_FOR_SIGNIN, Strings.PASSWORD_FOR_SIGNIN);
//
//            //Selection
//
//            text( "Cheching of funcionality of favorite icon and header logo");
//            MainPage mainPage = new MainPage(driver);
//            mainPage.selectSectionKids();
//            String currentURL = driver.getCurrentUrl();
//            assert currentURL.equals("https://www.lcwaikiki.rs/sr-RS/RS/category/boys/pyjamas-c104") : "User is on the wrong page. " + "  Actual: " + currentURL;
//            sleepForAll();
//            mainPage.selectOnePyjama();
//            String currentURL1 = driver.getCurrentUrl();
//            assert currentURL1.equals("https://www.lcwaikiki.rs/sr-RS/RS/product/LC-WAIKIKI/%D0%95%D1%80%D0%BB%D0%B5%D1%80-%D0%91%D0%B0%D0%BB%D0%B0/Komplet-pid%C5%BEama/6213538/2670934") : "User is on the wrong page. " + "  Actual: " + currentURL;
//            sleepForAll();
//            mainPage.addToFavorites();
//            sleepForAll();
//            mainPage.favoriteIcon();
//            String currentURL3 = driver.getCurrentUrl();
//            assert currentURL3.equals("https://www.lcwaikiki.rs/sr-RS/RS/myfavoritelist") : "User is on the wrong page. " + "  Actual: " + currentURL;
//            sleepForAll();
//            mainPage.headerLogo();
//            String currentURL4 = driver.getCurrentUrl();
//            assert currentURL4.equals("https://www.lcwaikiki.rs/sr-RS/RS") : "User is on the wrong page. " + "  Actual: " + currentURL;
//
//        }
//        finally {
//
//            driver.quit();
//
//        }
//
//    }
//
//}
