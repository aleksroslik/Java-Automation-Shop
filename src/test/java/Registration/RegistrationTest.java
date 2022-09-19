package Registration;

import Base.BaseTest;
import Models.User.User;
import Models.User.UserFactory;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationTest.class);

    RegistrationPage registrationPage;
    LoginPage loginPage;
    HomePage homePage;
    User user;

    @BeforeEach
    public void testSetup() {
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        user = new UserFactory().getRandomUser();
    }

    @Test
    @DisplayName("Register new user")
    public void registerNewUser() {
        homePage.goToLoginPage();

        loginPage.goToRegistration();

        registrationPage
                .selectRandomSocialTitle()
                .setUserData
                        (new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getBirthday()))
                .acceptAgreements()
                .submitForm();

        logger.info("Account name is: " + homePage.getAccountNameText());
        assertThat(homePage.getAccountNameText()).isEqualTo(user.getFirstName() + " " + user.getLastName());
    }
}
