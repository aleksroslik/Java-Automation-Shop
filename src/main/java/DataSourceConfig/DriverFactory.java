package DataSourceConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private WebDriver driver;

    public WebDriver getDriver() {
        String browserName = System.getProperty("browserName");
        logger.info("Browser name " + browserName);
        switch (browserName) {
            case "chrome" -> getChromeDriver();
            case "firefox" -> getFireFoxDriver();
            case "ie" -> getIeDriver();
            case "edge" -> getEdgeDriver();
            default -> throw new IllegalArgumentException();
        }
        driver.get(System.getProperty("appUrl"));
        return driver;
    }

    private void getChromeDriver() {
        ChromeOptions optionsChrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        driver = new ChromeDriver(optionsChrome);
    }

    private void getFireFoxDriver() {
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        optionsFirefox.addArguments("start-maximized");
        driver = new FirefoxDriver(optionsFirefox);
    }

    private void getIeDriver() {
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver(ieOptions);
        driver.manage().window().maximize();
    }

    private void getEdgeDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        edgeOptions.addArguments("start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }
}
