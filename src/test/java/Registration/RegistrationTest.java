package Registration;

import Base.Pages;
import Models.User;
import DataProviders.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationTest extends Pages {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationTest.class);

    User user = new UserFactory().getRandomUser();

    @Test
    @DisplayName("Register new user")
    public void registerNewUser() {
        logger.info(">>>> Start Registration test >>>>>");
        homePage.goToLoginPage();

        loginPage.goToRegistration();

        registrationPage
                .selectRandomSocialTitle()
                .setUserData(user)
                .acceptAgreements()
                .submitForm();

        logger.info("Account name is: " + homePage.getAccountNameText());
        assertThat(homePage.getAccountNameText()).isEqualTo(user.getFirstName() + " " + user.getLastName());
        logger.info(">>>> End Registration test >>>>>");
    }
}
