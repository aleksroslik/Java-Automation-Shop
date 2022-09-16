package Models.User;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserFactory {

    public User getRandomUser() {
        Faker faker = new Faker(new Locale("PL"));
        User user =  new User();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.name() + "@email.com");
        user.setPassword(faker.lorem().characters(6, 8));
        user.setBirthday(String.valueOf(faker.date().birthday(18, 80)));
        return user;
    }

    public User getAlreadyRegisteredUser() {
        return new User.Builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .email("email@email.com")
                .password("password")
                .birthday("01/02/2000")
                .build();
    }
}
