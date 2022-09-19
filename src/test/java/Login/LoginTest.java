package Login;

import Base.BaseTest;
import Models.User.User;
import Models.User.UserFactory;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        homePage.goToLoginPage();
        loginPage.login(user);
    }
}
