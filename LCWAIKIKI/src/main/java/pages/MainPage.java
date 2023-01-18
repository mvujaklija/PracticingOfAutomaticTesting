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

public class MainPage {

    //Looking for web elements

    @FindBy(xpath = "//a[@class='header-logo img-logo']")
    WebElement headerLogo;

    @FindBy(xpath = "//i[@class='header-favorite-icon bndl-like bndl-like-dims']")
    WebElement favoriteIcon;

    @FindBy(xpath = "//input [ @id = 'search' ]")
    WebElement searchBarInput;

    @FindBy(xpath = "//span[@class='searchText']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@id='mega_menu_dd_9'][@class='dropdown-toggle dropdown-toggle ']")
    WebElement kids;

    @FindBy(xpath = "//a[ @href ='/sr-RS/RS/category/boys/pyjamas-c104']")
    WebElement pyjamas;

    @FindBy(xpath = "//*[@id = 'model_2670934_6213538']/div[1]/img[1]")
    WebElement onePyjama;

    @FindBy(xpath = "//*[@id='rightInfoBar']/div[1]/div/div[1]/div[2]/a[1]")
    WebElement addToFavorites;

    @FindBy(xpath = "//label [ @id = 'filter-label']")
    WebElement filterButton;

    //Invoking Chrome driver

    public ChromeDriver driver = null;

    //Constructor

    public MainPage(ChromeDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Methods

    /**
     * THIS Method select section DECA/DEČACI/Pidžame on main page of LC WAIKIKI
     */

    public void selectSectionKids() {


        Actions action = new Actions(driver);
        action.moveToElement(kids).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id = 'menu_9' ]/div/div/div[1]/div[2]/div[1]"))).click();
        pyjamas.click();

    }

    /**
     * THIS Methods test functionality of favorites and head logo on page of LC WAIKIKI
     */

    public void selectOnePyjama() {

        onePyjama.click();
    }

    public void addToFavorites() {

        addToFavorites.click();

    }

    public void favoriteIcon() {

        favoriteIcon.click();

    }

    public void headerLogo() {

        headerLogo.click();

    }

    /**
     * THIS Method test functionality of search bar  on page of LC WAIKIKI
     */

    public void searchBarTest() {

        searchBarInput.click();
        searchBarInput.sendKeys(Strings.TRY_FOR_SEARCH_BAR);
        searchButton.click();

    }

}




