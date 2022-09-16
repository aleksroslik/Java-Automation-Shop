package Models.User;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthday;

    public User(final Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.birthday = builder.birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String birthday;

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
    }
}
