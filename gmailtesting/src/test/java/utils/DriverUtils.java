package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class DriverUtils {

    public static  WebDriver _driver;

    @Before
    public void setUp() {
    	System.setProperty("webdriver.gecko.driver", "C:\\\\selenium\\geckodriver.exe");
        _driver = new FirefoxDriver();
    }

    public static WebDriver getDriver() {
        if ( _driver == null) {
        	System.setProperty("webdriver.gecko.driver", "C:\\\\selenium\\geckodriver.exe");
            _driver = new FirefoxDriver();
        }
        return _driver;
    }

    @After
    public void tearDown() throws Exception {
        _driver.close();
        _driver.quit();
    }
}