package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class AppManager {
    //private WebDriver driver;

    private EventFiringWebDriver driver;

    public Logger logger = LoggerFactory.getLogger(AppManager.class);

    static String browser;
    public AppManager(){browser = System.getProperty("browser", BrowserType.CHROME);}

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method) {
        //driver = new ChromeDriver();
        if (browser.equals(BrowserType.CHROME)){
            driver = new EventFiringWebDriver(new ChromeDriver());
            logger.info("use chrome");
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("use firefox");
        }else {
            driver = new EventFiringWebDriver(new ChromeDriver());
            logger.info("use chrome");
        }

        driver.manage().window().maximize();

        logger.info("Start testing -> " +method.getName());
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method) {
        logger.info("Stop testing -> "+method.getName());
       if (driver != null)
           driver.quit();
    }
}
