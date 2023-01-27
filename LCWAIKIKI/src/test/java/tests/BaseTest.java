package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public ChromeDriver openChromeDriver() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments(new String[]{"--user-data-dir=C:/Users/milan/AppData/Local/Google/Chrome/User Data"});
        options.addArguments(new String[]{"--profile-directory=Profile 1"});
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        //options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }

    public void sleep( ) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void longsleep( ) {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sleepForCode ( ) {
        try {
            Thread.sleep(60000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void text(String txt) {System.out.println(txt);}
}