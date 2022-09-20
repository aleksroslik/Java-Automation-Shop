package Login;

import Base.BaseTest;
import Models.User.User;
import Models.User.UserFactory;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    User user;

    @BeforeEach
    public void testSetup() {
        user = new UserFactory().getAlreadyRegisteredUser();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void loginExistingUser() {
        logger.info(">>>> Start Login test >>>>>");
        homePage.goToLoginPage();
        loginPage.loginUser(user);

        logger.info("Account name is: " + homePage.getAccountNameText());
        assertThat(homePage.getAccountNameText()).isEqualTo(user.getFirstName() + " " + user.getLastName());
        logger.info(">>>> End Login test >>>>>");
    }
}
