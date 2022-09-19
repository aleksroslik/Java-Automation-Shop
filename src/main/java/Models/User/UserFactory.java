package Models.User;

import com.github.javafaker.Faker;

public class UserFactory {

    public User getAlreadyRegisteredUser() {
        return new User.Builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .email("email@email.com")
                .password("password")
                .birthday("01/02/2000")
                .build();
    }

    public User getRandomUser() {
        Faker faker = new Faker();
        return new User.Builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.name() + "@email.com")
                .password(faker.lorem().characters(6, 8))
                .birthday(String.valueOf(faker.date().birthday(18, 80)))
                .build();
    }
}
