package Base;

import DataSourceConfig.AppProperties;
import DataSourceConfig.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    protected static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected static WebDriver driver;
    private static AppProperties appProperties;

    @BeforeAll
    static void setDriver() {
        appProperties = AppProperties.getInstance();
    }

    @BeforeEach
    public void setUp() {
        driver = new DriverFactory().getDriver();
        logger.info(">>>>> Driver started successfully <<<<<");
    }

    @AfterEach
    public void close() {
        driver.quit();
        logger.info(">>>>> Driver closed <<<<<");
    }
}
