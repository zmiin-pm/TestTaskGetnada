package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {
    public static WebDriver setDriver(DriverType driverType) {
        switch (driverType){
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case OPERA: {
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            }
        }
        return null;
    }

    // to run from console with key "-Ddriver.type=opera". "opera" for example
    public static WebDriver setDriver () {
       DriverType driverType = DriverType.valueOf(System.getProperty("driver.type").toUpperCase());
        return setDriver(driverType);
    }
}
