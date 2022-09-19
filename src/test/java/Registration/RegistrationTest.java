package Registration;

import Base.BaseTest;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationTest.class);

    RegistrationPage registrationPage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeEach
    public void testSetup() {
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("Register new user")
    public void registerNewUser() {
        homePage.goToLoginPage();

        loginPage.goToRegistration();

        registrationPage.acceptAgreements();
    }
}
