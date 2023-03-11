package com.talentLMS.UI.driverFactory;

import com.talentLMS.UI.dataProviders.ConfigReader;
import org.openqa.selenium.WebDriver;

/**
 * @author Nurbek Aibashov
 */
public class Driver {

    private Driver(){

    }
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            switch (ConfigReader.getProperty("browser").toLowerCase()){
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "Edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                case "FireFox":
                    driver = FirefoxWebDriver.loadFireFoxDriver();
                    break;
                case "Safari":
                    driver = SafariWebDriver.loadSafariDriver();
                    break;
                default:
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
            }
        }

        return driver;
    }
    public static void closeDriver(){
        try {
            if (driver != null){
                driver.close();
                driver.quit();
                driver = null;
            }
        }catch (Exception e){
            System.out.println("Error while closing driver");
        }
    }
}
    