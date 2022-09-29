package DataProviders;

public class User {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String birthday;
    private final String address;
    private final String alternativeAddress;
    private final String city;
    private final String postalCode;

    public User(final Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.birthday = builder.birthday;
        this.address = builder.address;
        this.alternativeAddress = builder.alternativeAddress;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String birthday;
        private String address;
        private String alternativeAddress;
        private String city;
        private String postalCode;

        public Builder firstName (final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName (final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email (final String email) {
            this.email = email;
            return this;
        }

        public Builder password (final String password) {
            this.password = password;
            return this;
        }

        public Builder birthday (final String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder address (final String address) {
            this.address = address;
            return this;
        }

        public Builder alternativeAddress (final String alternativeAddress) {
            this.alternativeAddress = alternativeAddress;
            return this;
        }

        public Builder city (final String city) {
            this.city = city;
            return this;
        }

        public Builder postalCode (final String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAlternativeAddress() {
        return alternativeAddress;
    }
}
