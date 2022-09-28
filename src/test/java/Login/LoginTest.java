package Login;

import Base.Pages;
import Models.User;
import DataProviders.UserFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest extends Pages {

    User user = new UserFactory().getAlreadyRegisteredUser();

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
