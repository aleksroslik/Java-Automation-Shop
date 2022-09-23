package DataProviders;

import Models.User;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class UserFactory {

    public User getAlreadyRegisteredUser() {
        return new User.Builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .email("completely.random@email.com")
                .password("password")
                .birthday("01/02/2000")
                .build();
    }

    public User getRandomUser() {
        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return new User.Builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.name() + ".com")
                .password(faker.lorem().characters(6, 8))
                .birthday(sdf.format(faker.date().birthday(18, 80)))
                .build();
    }
}
